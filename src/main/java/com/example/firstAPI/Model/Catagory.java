package com.example.firstAPI.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Catagory extends BaseModel{
    private String name;
}
