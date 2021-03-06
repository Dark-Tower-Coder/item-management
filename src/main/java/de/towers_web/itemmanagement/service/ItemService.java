package de.towers_web.itemmanagement.service;

import de.towers_web.itemmanagement.dto.Item;
import de.towers_web.itemmanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        return this.itemRepository.save(item);
    }

    public void deleteItem(int id) {
        this.itemRepository.deleteById(id);
    }
}
