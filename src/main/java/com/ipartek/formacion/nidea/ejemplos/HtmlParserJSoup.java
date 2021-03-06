package com.ipartek.formacion.nidea.ejemplos;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserJSoup {

	public static void main(String[] args) throws IOException {

		/*
		 * Document doc = Jsoup.connect("http://example.com/").get(); String title =
		 * doc.title(); Elements anclas = doc.getElementsByTag("a");
		 * System.out.println("TITULO " + title);
		 * 
		 * for (Element ancla : anclas) {
		 * 
		 * String urlPagina2 = ancla.attr("href"); Document doc2 =
		 * Jsoup.connect(urlPagina2).get(); System.out.println("titulo pagina 2 " +
		 * doc2.title());
		 * 
		 * }
		 */

		String url = "http://localhost:8080/nidea/login";

		// Entramos en la primera pagina mandando unos parametros al login para que
		// podamos acceder automaticamente
		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin")
				.data("password", "admin").execute();

		// Enviamos los datos
		Document doc = response.parse();
		/*
		 * Para verificar que estamos en la pagina adecuada cogemos los datos de una
		 * etiqueta existente
		 */

		// Donde estoy,pagina de lista de productos

		// Muestro el contenido,en este caso del titulo que esta en H1
		System.out.println(doc.getElementsByTag("h1").get(0).text());

		String cookieSession = response.cookies().get("JSESSIONID");

		Elements button = doc.getElementsByTag("button");

		// Accedo a las propiedades del boton
		for (Element contenidoboton : button) {
			Elements a = contenidoboton.getElementsByTag("a");
			String urldestino = a.attr("href");

			// Paso por pantalla la url donde va a apuntar
			System.out.println(urldestino);

			// Añado el restante de la url para que pueda navegar
			String direccioncompleta = "http://localhost:8080/nidea/" + urldestino;

			// Muestro para ver que la url esta bien formada
			System.out.println(direccioncompleta);

			// Muestro el valor del boton de donde estoy,para saber si es, el boton que
			// busco
			Elements botonvistaproductos = doc.getElementsByTag("form");

			System.out.println(botonvistaproductos.text());

			Connection.Response responseCrearMaterial = Jsoup.connect("http://:8080/nidea/backoffice/materiales?op=2")
					.method(Connection.Method.POST).data("nombre", "Mesa").data("precio", "11.0")
					.cookie("JSESSIONID", cookieSession).execute();
			Document crearmaterial = responseCrearMaterial.parse();

			Document crearmaterial1 = response.parse();
			/*
			 * Me conecto a esa direccion url y le paso unos parametros,en este caso para el
			 * formulario
			 *
			 * 
			 */

		}

	}
}
