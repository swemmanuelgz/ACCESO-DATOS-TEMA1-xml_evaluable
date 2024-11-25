package com.mycompany.xml_evaluable;

import java.util.List;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.mycompany.xml_evaluable.model.RSS;

public class Xml_writter {
    public void writeXML(String fileName, List<RSS> rssItems) {
        try {
            // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Nodo raíz
            Element root = document.createElement("rssFeed");
            document.appendChild(root);

            // Agregar cada elemento RSS al XML
            for (RSS item : rssItems) {
                Element itemElement = document.createElement("item");

                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(item.getTitulo()));
                itemElement.appendChild(title);

                Element date = document.createElement("date");
                date.appendChild(document.createTextNode(item.getFecha().toString()));
                itemElement.appendChild(date);

                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(item.getAutor()));
                itemElement.appendChild(author);

                Element link = document.createElement("link");
                link.appendChild(document.createTextNode(item.getURL()));
                itemElement.appendChild(link);

                root.appendChild(itemElement);
            }

            // Transformar el documento en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            Writer writer = new FileWriter(fileName);
            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);
            writer.close();

            System.out.println("Archivo XML generado: " + fileName);
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
