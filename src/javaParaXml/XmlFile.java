package javaParaXml;

import java.util.List;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlFile {

    private List<Class> classes;
    private String fileName;
    private String filePath  = "C:\\temp\\xml";


    public XmlFile() {
    }

    public XmlFile(String fileName, List<Class> classes) {
        this.fileName = fileName;
        this.classes = classes;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Class> getClasses() {
        return this.classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    /**
     * Função que gera o arquivo xml a partir do caminho absoluto e da lista de classes
     * 
     * As ações realizadas dentro desse método são desconhecidas e obscuras até mesmo para
     * grandes mestres da programação. Tentar modificar uma linha sequer pode abrir uma brecha
     * para males nunca vistos antes!!
     * 
     * @return void
     */

    public void gerarXml() {
        try{
            //Cria um novo objeto Document Builder Factory
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

            //Cria um novo objeto Document Builder
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Cria um novo documento XML
            Document doc = docBuilder.newDocument();

            //Cria o elemento raiz
            Element rootElement = doc.createElement("classes");
            doc.appendChild(rootElement);

            //Percorre a lista de classes
            for (Class classe : classes) {
                //Cria o elemento classe
                Element classElement = doc.createElement("classe");
                rootElement.appendChild(classElement);

                //Cria o elemento nome
                Element nameElement = doc.createElement("nome");
                nameElement.appendChild(doc.createTextNode(classe.getName()));
                classElement.appendChild(nameElement);

                //Cria o elemento atributos
                Element attributesElement = doc.createElement("atributos");
                classElement.appendChild(attributesElement);

                //Percorre a lista de atributos
                for (Attribute attribute : classe.getAttributes()) {
                    //Cria o elemento atributo
                    Element attributeElement = doc.createElement("atributo");
                    attributesElement.appendChild(attributeElement);

                    
                    //Cria o elemento tipo
                    Element attributeTypeElement = doc.createElement("tipo");
                    attributeTypeElement.appendChild(doc.createTextNode(attribute.getType()));
                    attributeElement.appendChild(attributeTypeElement);

                    //Cria o elemento nome
                    Element attributeNameElement = doc.createElement("nome");
                    attributeNameElement.appendChild(doc.createTextNode(attribute.getName()));
                    attributeElement.appendChild(attributeNameElement);

                }

                //Cria o elemento métodos
                Element methodsElement = doc.createElement("metodos");
                classElement.appendChild(methodsElement);

                //Percorre a lista de métodos
                for (Method method : classe.getMethods()) {
                    //Cria o elemento método
                    Element methodElement = doc.createElement("metodo");
                    methodsElement.appendChild(methodElement);

                    //Cria o elemento nome
                    Element methodNameElement = doc.createElement("nome");
                    methodNameElement.appendChild(doc.createTextNode(method.getName()));
                    methodElement.appendChild(methodNameElement);
                }
            }

            //Cria um novo objeto Transformer Factory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            //Cria um novo objeto Transformer
            Transformer transformer = transformerFactory.newTransformer();

            //Cria um novo objeto DOM Source
            DOMSource source = new DOMSource(doc);

            //Cria um novo objeto Stream Result
            StreamResult result = new StreamResult(new File(filePath + "\\"+ fileName +".xml"));

            //Transforma o documento em um arquivo XML
            transformer.transform(source, result);

            System.out.println("Arquivo XML criado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao criar o arquivo XML: " + e.getMessage());
        }

    }

    
}
