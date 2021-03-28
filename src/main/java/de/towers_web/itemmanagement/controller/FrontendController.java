package de.towers_web.itemmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontendController {

    private String[] availableSites = new String[]{"401", "404", "500", "charts", "index", "layout-sidenav-light", "layout-static", "login", "password", "register", "tables"};


    @GetMapping(value = {"/{site}"})
    public String site(@PathVariable String site) {

        for (String availableSite : availableSites) {
            if (availableSite.equals(site)) {
                return site;
            }
        }

        return "404";
    }
}
