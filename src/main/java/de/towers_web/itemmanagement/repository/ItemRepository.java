package de.towers_web.itemmanagement.repository;

import de.towers_web.itemmanagement.dto.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{

    List<Item> findAll();
}
