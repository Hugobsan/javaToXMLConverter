package javaParaXml;

import java.io.File;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		String dirPath = "C:\\temp\\jEdit";
		
		//Percorre o dirPath e todos os subdiretórios e para cada arquivo .java encontrado chama o método converterParaXml

		//Cria um array para armazenar os arquivos Java
		ArrayList<File> arquivosJava = new ArrayList<File>();

		//Percorre o diretório e todos os subdiretórios
		buscarArquivosJava(new File(dirPath), arquivosJava);

		System.out.println("Total de arquivos Java encontrados: " + arquivosJava.size());

		//Para cada arquivo Java encontrado, chama o método converterParaXml
		for (File file : arquivosJava) {
			ArquivoJava arquivojava = new ArquivoJava();
			arquivojava.setCaminhoAbsoluto(file.getAbsolutePath());
			//NomeArquivo = pasta.nomeArquivo sem a extensão
			String nome = file.getAbsolutePath().replace(dirPath, "").replace(".java", "").replace("\\", ".").replaceFirst(".", "");
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
