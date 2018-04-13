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

		// String url = "http://192.168.0.15:8080/nidea/login";

		String url = "http://localhost:8080/nidea/login";
		String url2 = "http://localhost:8080/backoffice/materiales";
		String url3 = "http://localhost:8080/backoffice/materiales?op=1";

		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin")
				.data("password", "admin").execute();

		Document doc = response.parse();
		System.out.println(doc.getElementsByTag("h1").get(0).text());

		Element div = doc.getElementById("form-group");
		Elements crear = doc.getElementsByTag("a");
		Elements botton = doc.getElementsByTag("button");

	}

}
