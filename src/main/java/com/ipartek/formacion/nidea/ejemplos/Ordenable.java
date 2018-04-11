package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;

public class Ordenable {

	
	ArrayList<Ordenable> arrayOrdenado= new ArrayList<Ordenable>();
	
	private int numerodePatas;
	private int numerodeVacunas;
	
	public int getNumerodePatas() {
		return numerodePatas;
	}
	public void setNumerodePatas(int numerodePatas) {
		this.numerodePatas = numerodePatas;
	}
	public int getNumerodeVacunas() {
		return numerodeVacunas;
	}
	public void setNumerodeVacunas(int numerodeVacunas) {
		this.numerodeVacunas = numerodeVacunas;
	}
}
