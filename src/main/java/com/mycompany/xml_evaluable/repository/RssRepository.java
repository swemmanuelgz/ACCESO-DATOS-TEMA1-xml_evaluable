package com.mycompany.xml_evaluable.repository;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mycompany.xml_evaluable.model.RSS;

public class RssRepository {

    public List<RSS> getRSS(String URL) {
        List<RSS> rssItems = new ArrayList<>();

        try {
            // Realiza la conexión HTTP
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();

            // Parsear el XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // Obtener los elementos "item"
            NodeList itemList = document.getElementsByTagName("item");

            for (int i = 0; i < itemList.getLength(); i++) {
                Node node = itemList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extraer datos del XML
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String fechaStr = element.getElementsByTagName("pubDate").item(0).getTextContent();
                    String autor = element.getElementsByTagName("author").item(0) != null
                            ? element.getElementsByTagName("author").item(0).getTextContent()
                            : "Desconocido";
                    String link = element.getElementsByTagName("link").item(0).getTextContent();

                    // Convertir la fecha
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
                    Date date = dateFormat.parse(fechaStr);

                    // Crear un objeto RSS y agregarlo a la lista
                    rssItems.add(new RSS(title, date, autor, link));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el RSS: " + e.getMessage());
            e.printStackTrace();
        }

        return rssItems;
    }
}
