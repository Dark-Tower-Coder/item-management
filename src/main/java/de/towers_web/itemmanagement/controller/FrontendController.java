package de.towers_web.itemmanagement.controller;

import de.towers_web.itemmanagement.dto.Item;
import de.towers_web.itemmanagement.service.ItemService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class FrontendController {

    @Autowired
    ItemService itemService;

    private String[] availableSites = new String[]{"401", "404", "500", "charts", "index", "layout-sidenav-light", "layout-static", "login", "password", "register", "tables"};


    @GetMapping(value = {"/{site}"})
    public String site(Model model, @PathVariable String site) {

        for (String availableSite : availableSites) {
            if (availableSite.equals(site)) {
                if (site.equals("index")) {
                    createTableSite(model);
                }
                return site;
            }
        }

        return "404";
    }


    private Model createTableSite(Model model) {

        List<Item> itemList = new ArrayList<>();
        itemList = itemService.getAllItems();

        model.addAttribute("itemList", itemList);

        model.addAttribute("newItem", new NewItem());

        return model;
    }

    public void createItemInDB() {
        Item exampleItemWithAllAttributes = new Item();

        exampleItemWithAllAttributes.setLink("https://www.amazon.de/Gardena-12300-Heckenschere-NatureCut-Mehrfarbig/dp/B07YSSZRW8/ref=sr_1_3?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2NIQIAQU33ANR&dchild=1&keywords=heckenschere&qid=1618256775&sprefix=heckens%2Caps%2C192&sr=8-3");
        exampleItemWithAllAttributes.setAvailable(true);
        exampleItemWithAllAttributes.setDescription(
                "Info zu diesem Artikel\n" +
                        "Besonders kraftschonend: Mit 23 cm langen Präzisionsklingen mit Wellenschliff für genaues Schneiden\n" +
                        "Komfortable Handhabung: Bequemes Arbeiten dank ergonomisch geformter Holzgriffe");
        exampleItemWithAllAttributes.setOwner("Richard");
        exampleItemWithAllAttributes.setFileName("schere.jpg");
        exampleItemWithAllAttributes.setName("Die beste Schere der Welt!");

        try {
            exampleItemWithAllAttributes.setFile(Files.readAllBytes(Paths.get("src/main/resources/static/itemImages/taschenmesser.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemService.saveItem(exampleItemWithAllAttributes);
    }

    @PostMapping(value = "/newItems", consumes = {"multipart/form-data"})
    public String addEvent(@ModelAttribute("newItem") NewItem newItem, BindingResult bindingResult, @RequestParam("file") MultipartFile multipartFile, Model model) {

/*        createItemInDB();
        if(true){
            return "index";
        }*/
        Item item = new Item();

        if (!multipartFile.isEmpty()) {
            try {
                item.setFile(multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                item.setFile(Files.readAllBytes(Paths.get("src/main/resources/static/itemImages/taschenmesser.jpg")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        item.setName(newItem.getName());
        item.setOwner(newItem.getOwner());
        item.setAvailable(newItem.isAvailable());
        item.setDescription(newItem.getDescription());
        item.setLink(newItem.getLink());

        itemService.saveItem(item);

        createTableSite(model);

        return "index";
    }


    @Data
    public class NewItem {
        private String name;
        private String link;
        private String fileName;
        private String owner;
        private String description;
        private boolean isAvailable;
        private byte[] file;
    }
}
