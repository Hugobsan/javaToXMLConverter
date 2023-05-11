package javaParaXml;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		JOptionPane.showConfirmDialog( null, "Bem-vindo ao sistema de conversão .java para .xml\n O sistema encontra-se em fase inicial e é passível de erros.\n\n Clique em OK para continuar.", "Bem-vindo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		String javaFilesPath = JOptionPane.showInputDialog(null, "Digite o caminho absoluto do diretório que contém os arquivos Java.\n Ex: C:\\temp\\jEdit", "Arquivos Java", JOptionPane.INFORMATION_MESSAGE, null, null, "C:\\temp\\jEdit").toString();

		if(javaFilesPath == null || javaFilesPath.equals("")){
			JOptionPane.showMessageDialog(null, "Caminho inválido. O programa será encerrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		//String destinoPath = JOptionPane.showInputDialog(null, "Digite o caminho absoluto do diretório de destino dos arquivos XML.\n Ex: C:\\temp\\xml", "Arquivos XML", null, null, null, "C:\\temp\\xml");
		String destinoPath = JOptionPane.showInputDialog(null, "Digite o caminho absoluto do diretório de destino dos arquivos XML.\n Ex: C:\\temp\\xml", "Arquivos XML", JOptionPane.INFORMATION_MESSAGE, null, null, "C:\\temp\\xml").toString();

		if(destinoPath == null || destinoPath.equals("")){
			JOptionPane.showMessageDialog(null, "Caminho inválido. O programa será encerrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		//Percorre o dirPath e todos os subdiretórios e para cada arquivo .java encontrado chama o método converterParaXml

		//Cria um array para armazenar os arquivos Java
		ArrayList<File> arquivosJava = new ArrayList<File>();

		//Percorre o diretório e todos os subdiretórios
		buscarArquivosJava(new File(javaFilesPath), arquivosJava);

		System.out.println("Total de arquivos Java encontrados: " + arquivosJava.size());

		//Para cada arquivo Java encontrado, chama o método converterParaXml
		for (File file : arquivosJava) {
			ArquivoJava arquivojava = new ArquivoJava();
			arquivojava.setCaminhoAbsoluto(file.getAbsolutePath());
			arquivojava.setDestinoXML(destinoPath);
			//NomeArquivo = pasta.nomeArquivo sem a extensão
			String nome = file.getAbsolutePath().replace(javaFilesPath, "").replace(".java", "").replace("\\", ".").replaceFirst(".", "");
			arquivojava.setNomeArquivo(nome);
			arquivojava.converterParaXml();
		}
	}

	public static void buscarArquivosJava(File dir, ArrayList<File> arquivosJava) {
        File[] arquivos = dir.listFiles();
        for (File arquivo : arquivos) {
            if (arquivo.isDirectory()) {
                buscarArquivosJava(arquivo, arquivosJava);
            } else if (arquivo.getName().endsWith(".java")) {
                arquivosJava.add(arquivo);
            }
        }
    }

}
