package com.example.firstAPI.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String imageUrl;
    private Catagory catagory;
}
