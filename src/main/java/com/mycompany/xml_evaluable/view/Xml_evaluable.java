/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.xml_evaluable.view;

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
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";

        System.out.println("Hello World!");
        RssController rssController = new RssController();
        String URL ="https://www.europapress.es/rss/rss.aspx?buscar=inteligencia-artificial";
        RSS rssItem = rssController.getRSS(URL);
        System.out.println(ANSI_GREEN+rssItem.toString()+ANSI_RESET);
        
    }
}
