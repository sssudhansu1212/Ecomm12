package com.example.firstAPI.InheritanceMappingDemo.mappedsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mc_instructor")
public class instructor extends user{
    private String favStudent;
}
