package com.example.java;

public class Application {
	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i){
		case 3: return sockAdapter.get3Volt();
		case 12: return sockAdapter.get12Volt();
		case 120: return sockAdapter.get120Volt();
		default: return sockAdapter.get120Volt();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
		
		SocketAdapter sockAdapter1 = new SocketClassAdapterImpl();
		Volt v13 = getVolt(sockAdapter1,3);
		Volt v112 = getVolt(sockAdapter1,12);
		Volt v1120 = getVolt(sockAdapter1,120);
		System.out.println("v3 volts using Class Adapter="+v13.getVolts());
		System.out.println("v12 volts using Class Adapter="+v112.getVolts());
		System.out.println("v120 volts using Class Adapter="+v1120.getVolts());
	}

}
