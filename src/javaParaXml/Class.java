package javaParaXml;

import java.util.List;

public class Class {
    private String name;
    private List<Method> methods;
    private List<Attribute> attributes;


    public Class() {
    }

    public Class(String name, List<Method> methods, List<Attribute> attributes) {
        this.name = name;
        this.methods = methods;
        this.attributes = attributes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Method> getMethods() {
        return this.methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    
}
