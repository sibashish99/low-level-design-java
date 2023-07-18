package com.example.java;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza = new BasicPizza();

        // Add extra cheese using decorator
        pizza = new CheeseDecorator(pizza);

        // Add mushrooms using another decorator
        //pizza = new MushroomDecorator(pizza);

        // Now, the pizza has both extra cheese and mushrooms
        System.out.println("Pizza description: " + pizza.getDescription());
        System.out.println("Total cost: $" + pizza.getCost());
	}

}
