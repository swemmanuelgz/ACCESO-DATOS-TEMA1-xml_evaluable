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
        System.out.println("Hello World!");
        RssController rssController = new RssController();
        String URL ="https://www.europapress.es/rss/rss.aspx?buscar=inteligencia-artificial";
        RSS rssItem = rssController.getRSS(URL);
        System.out.println(rssItem.toString());
        
    }
}
