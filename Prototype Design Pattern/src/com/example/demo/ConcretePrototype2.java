package com.example.demo;

public class ConcretePrototype2 implements CloneablePrototype {

	private int number;

	public ConcretePrototype2(int number) {
		this.number = number;
	}

	@Override
	public CloneablePrototype clone() {
		return new ConcretePrototype2(this.number);
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
