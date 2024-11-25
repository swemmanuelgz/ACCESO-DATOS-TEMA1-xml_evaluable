/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.xml_evaluable.view;

import java.util.List;

import javax.sql.rowset.spi.XmlWriter;

import com.mycompany.xml_evaluable.CustomXmlWriter;
import com.mycompany.xml_evaluable.controller.RssController;
import com.mycompany.xml_evaluable.model.RSS;

/**
 *
 * @author damdu217
 */
public class Xml_evaluable {

    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        System.out.println("Hello World!");

        // Controlador para manejar la lógica RSS
        RssController rssController = new RssController();
        String url = "https://www.europapress.es/rss/rss.aspx?buscar=inteligencia-artificial";

        // Obtener la lista de elementos RSS
        List<RSS> rssItems = (List<RSS>) rssController.getRSS(url);

        // Imprimir en consola los elementos obtenidos
        for (RSS item : rssItems) {
            System.out.println(ANSI_GREEN + item.toString() + ANSI_RESET);
        }

        // Crear archivo XML
        CustomXmlWriter xmlWriter = new CustomXmlWriter();
        String fileName = "25-11-2024-list.xml";
        xmlWriter.writeXML(fileName, rssItems);

        System.out.println("Archivo XML generado exitosamente: " + fileName);
    }
}
