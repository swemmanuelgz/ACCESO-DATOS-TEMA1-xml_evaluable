package com.mycompany.xml_evaluable.controller;

import com.mycompany.xml_evaluable.model.RSS;
import com.mycompany.xml_evaluable.repository.RssRepository;

public class RssController {
    private RssRepository rssRepository;

    public RssController() {
    }

    public RssController(RssRepository rssRepository) {
        this.rssRepository = rssRepository;
    }
    
    public RSS getRSS(String URL) {
        return rssRepository.getRSS(URL);
    }

    
}
