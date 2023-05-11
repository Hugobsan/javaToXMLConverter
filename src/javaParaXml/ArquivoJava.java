package javaParaXml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*Importando biblioteca qdox*/
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;

public class ArquivoJava {
	private String caminhoAbsoluto;
	private String nomeArquivo;
	
	public ArquivoJava() {
		
	}
	
	public ArquivoJava(String caminhoAbsoluto, String nomeArquivo) {
		this.caminhoAbsoluto = caminhoAbsoluto;
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public String getCaminhoAbsoluto() {
		return caminhoAbsoluto;
	}

	public void setCaminhoAbsoluto(String caminhoAbsoluto) {
		this.caminhoAbsoluto = caminhoAbsoluto;
	}
	
	/**
	 * Função que converte o arquivo .java definido no caminho absoluto para o 	
	 * formato xml
	 * 
	 * @return void
	 */
	public void converterParaXml( ){
        try
        {
            JavaDocBuilder builder = new JavaDocBuilder();
            builder.addSource(new FileReader(caminhoAbsoluto));
            JavaClass classes[] = builder.getClasses();

			List<Class> allClasses = new ArrayList<Class>();

            for (JavaClass classeJava : classes)
            {
				//Preenchendo uma lista de atributos com os atributos da classe
				List<Attribute> atributos = new ArrayList<Attribute>();
				
				for (com.thoughtworks.qdox.model.JavaField field :classeJava.getFields()){
					Attribute atributo = new Attribute(field.getName(), field.getType().toString());
					
					atributos.add(atributo);
				}

				//Preenchendo uma lista de métodos com os métodos da classe
				List<Method> metodos = new ArrayList<Method>();

				for (com.thoughtworks.qdox.model.JavaMethod method :classeJava.getMethods()){
					
					Method metodo = new Method(method.getName());
					
					metodos.add(metodo);
				}
				
				//Criando um objeto XmlBlock com os dados da classe
				Class bloco = new Class(classeJava.getName(), metodos, atributos);

				//Adicionando o objeto XmlBlock na lista de blocos
				allClasses.add(bloco);

            }

			//Criando um objeto XmlFile com os dados do arquivo
			XmlFile arquivo = new XmlFile(nomeArquivo, allClasses);
			
			arquivo.gerarXml();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
