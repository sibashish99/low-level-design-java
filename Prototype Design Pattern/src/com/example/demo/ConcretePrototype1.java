package com.example.demo;

public class ConcretePrototype1 implements CloneablePrototype {
	private String property;

    public ConcretePrototype1(String property) {
        this.property = property;
    }
	@Override
	public CloneablePrototype clone() {
		// TODO Auto-generated method stub
		return new ConcretePrototype1(this.property);
	}
	
	 public void setProperty(String property) {
	        this.property = property;
	    }

	    public String getProperty() {
	        return property;
	    }

}
