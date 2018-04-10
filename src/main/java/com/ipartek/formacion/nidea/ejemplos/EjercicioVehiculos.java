package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {


		Vehiculo rayomacqueen= new Vehiculo();
		System.out.println(rayomacqueen.toString());
System.out.println("-----------------------------------");
	VehiculoElectrico Testa= new VehiculoElectrico();
	System.out.println(Testa.toString());

	System.out.println("Tesla");
	System.out.println("Color: "+ Testa.getColor());
	}
	
	

}
