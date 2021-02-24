package de.towers_web.itemmanagement.controller;

import de.towers_web.itemmanagement.dto.Item;
import de.towers_web.itemmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all-items")
    public ResponseEntity<List<Item>> getAllItems(){
        return new ResponseEntity<List<Item>>(itemService.getAllItems(), HttpStatus.OK);
    }
}
