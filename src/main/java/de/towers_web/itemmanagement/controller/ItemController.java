package de.towers_web.itemmanagement.controller;

import de.towers_web.itemmanagement.dto.Item;
import de.towers_web.itemmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all-items")
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<List<Item>>(this.itemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping("/save-item")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(this.itemService.saveItem(item), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-item/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id){
        this.itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
