package de.towers_web.itemmanagement.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String link;
    private String pathToPicture;
    private String owner;
    private String description;
    private boolean isAvailable;

}
