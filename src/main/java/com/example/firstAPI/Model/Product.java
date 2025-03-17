package com.example.firstAPI.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Catagory catagory;

    public Product(){
        super();
    }
}
