package com.ipartek.formacion.nidea.pojo;

public class Coche implements AutoCloseable {

	public Coche() {
		super();
		
		System.out.println("Creamos un Coche");
	}
	
	public void conducir() {
		
		System.out.println("Estamos Conduciendo");
	}

	@Override
	public void close() throws Exception {
		
		System.out.println("Paramos el Coche");
		
	}
	
	public static void main(String[] args) {
		/*Si declaramos un objeto que implemente la interfaz Autoclosable dentro de los parentesis de TRY
		  Cuando llega al FINALLY se ejecuta de forma automatica su metodo close,Solo en Java 7 en Java 6 no funciona y tienes que cerrar*/
	
		try(Coche c= new Coche()) {
			System.out.println("Empezamos a programar");
			c.conducir();
		} catch (Exception e) {
		System.out.println("Tenemos una excepcion");
		}finally {
			System.out.println("Finalizamos");
			
		}
	}

	
	
	
}
