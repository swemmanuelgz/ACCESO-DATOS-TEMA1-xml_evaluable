package com.mycompany.xml_evaluable.controller;

import java.util.List;

import com.mycompany.xml_evaluable.model.RSS;
import com.mycompany.xml_evaluable.repository.RssRepository;

public class RssController {
    private RssRepository rssRepository;

    public RssController() {
        this.rssRepository = new RssRepository();
    }

    public RssController(RssRepository rssRepository) {
        this.rssRepository = rssRepository;
    }
    
    public List<RSS> getRSS(String URL) {
        return rssRepository.getRSS(URL);
    }

    
}
