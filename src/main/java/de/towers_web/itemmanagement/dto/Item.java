package de.towers_web.itemmanagement.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Base64;

@Data
@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String link;
    private String fileName;
    private String owner;
    private String description;
    private boolean isAvailable;
    @Lob
    private byte[] file;

    public String getImage(){
        return Base64.getEncoder().encodeToString(file);
    }

}
