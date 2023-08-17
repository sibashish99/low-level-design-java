package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrototypeManager manager = new PrototypeManager();

        ConcretePrototype1 prototype1 = new ConcretePrototype1("property1");
        manager.registerPrototype("Prototype1", prototype1);

        ConcretePrototype2 prototype2 = new ConcretePrototype2(42);
        manager.registerPrototype("Prototype2", prototype2);

        CloneablePrototype clonedPrototype1 = manager.createPrototype("Prototype1");
        System.out.println("Cloned Prototype1 Property: " + ((ConcretePrototype1)clonedPrototype1).getProperty());

        CloneablePrototype clonedPrototype2 = manager.createPrototype("Prototype2");
        System.out.println("Cloned Prototype2 Number: " + ((ConcretePrototype2)clonedPrototype2).getNumber());
	}

}
