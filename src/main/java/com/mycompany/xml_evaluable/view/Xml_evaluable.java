/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.xml_evaluable.view;

import java.util.List;

import javax.sql.rowset.spi.XmlWriter;

import com.mycompany.xml_evaluable.controller.RssController;
import com.mycompany.xml_evaluable.model.RSS;

/**
 *
 * @author damdu217
 */
public class Xml_evaluable {

    public static void main(String[] args) {
        //Codigos de colores para el console
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        // URL del feed RSS
        String URL = "https://www.europapress.es/rss/rss.aspx?buscar=inteligencia-artificial";

        // Crear un objeto RssController
        RssController rssController = new RssController();

        // Obtener los elementos RSS como una lista
        List<RSS> rssItems = rssController.getRSS(URL);

        // Mostrar los artículos en consola
        for (RSS item : rssItems) {
            System.out.println(ANSI_GREEN + item.toString() + ANSI_RESET);
        }

        // Crear un objeto XmlWriter y escribir el XML
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.writeXML("25-11-2024-list.xml", rssItems);
    }
}
