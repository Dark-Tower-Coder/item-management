package de.towers_web.itemmanagement.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {

    @Id
    private int id;
    private String name;
    private String link;
    private String pathToPicture;
    private String owner;
    private String description;
    private boolean isAvailable;

}
