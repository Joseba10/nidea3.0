package com.ipartek.formacion.nidea.debug;

public class LLAMADAS_ENTRE_METODOS {

	
	public static void main(String[] args) {
	
	Object vista = a();
	System.out.println(vista);
}

	private static Object a() {
		
		return b();
		
	}

	private static Object b() {
	
		return c();
	}

	private static Object c() {
		
		return Utilidades.diahoy();
	}
}