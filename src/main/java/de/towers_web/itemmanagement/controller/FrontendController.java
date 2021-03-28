package de.towers_web.itemmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontendController {

/*    @GetMapping("/index")
    public String getIndexPage() {

        return "index";
    }

    @GetMapping("/tables")
    public String getTablesPage() {

        return "tables";
    }*/

    @GetMapping(value = {"/{site}"})
    public String site(@PathVariable String site) {
        return site;
    }
}
