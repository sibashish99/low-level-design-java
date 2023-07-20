package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = AnimalFactory.createAnimal("dog");
        Animal cat = AnimalFactory.createAnimal("Cat");

        if (dog != null) {
            dog.makeSound(); 
        }

        if (cat != null) {
            cat.makeSound(); 
        }
	}

}
