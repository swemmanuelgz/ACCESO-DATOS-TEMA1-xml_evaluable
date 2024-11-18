package com.mycompany.xml_evaluable.repository;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rss;
    }

}
