package com.example.java;

public class CheeseDecorator extends PizzaDecorator {

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public String getDescription() {
        return pizza.getDescription() + ", extra cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0;
    }
	
	

}
