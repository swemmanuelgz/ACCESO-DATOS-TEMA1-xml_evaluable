package com.mycompany.xml_evaluable.repository;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mycompany.xml_evaluable.model.RSS;

public class RssRepository {

    public ArrayList<RSS> getRSS(String URL){
        ArrayList<RSS> rss = new ArrayList<>();

        try {
            //Conectamos a la URL
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();

            //Parseamos el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();
            //Nodo
            NodeList itemList = document.getElementsByTagName("item");

            for (int i = 0; i < itemList.getLength(); i++) {
                Node node = itemList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String fechaStr = element.getElementsByTagName("pubDate").item(0).getTextContent();
                    String autor = element.getElementsByTagName("author").item(0) != null ? 
                                    element.getElementsByTagName("author").item(0).getTextContent() : "Desconocido";

                    String link = element.getElementsByTagName("link").item(0).getTextContent();

                    //Convertimos a Date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
                    Date  date = dateFormat.parse(fechaStr);

                    //Creamos el objeto RSS
                    RSS rssItem = new RSS(title, date, autor, link);
                    rss.add(rssItem);

                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return rss;
    }

}
