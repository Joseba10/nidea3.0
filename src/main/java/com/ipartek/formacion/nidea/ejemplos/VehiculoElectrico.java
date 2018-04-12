package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {

	private float potencia; //KW

	public VehiculoElectrico() {
		super();
	this.potencia=0;
	System.out.println("Vehiculo Electrico Instanciado");
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString()+ "VehiculoElectrico [potencia=" + potencia + "]";
	}
	
	@Override
	public void arrancar() {
		
		System.out.println("Pulsar el Boton de encendido");
	}

	public VehiculoElectrico(float potencia) {
		this();//Cambiar Super por this()
		this.potencia = potencia;
	}




	
}
