package com.example.firstAPI.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
