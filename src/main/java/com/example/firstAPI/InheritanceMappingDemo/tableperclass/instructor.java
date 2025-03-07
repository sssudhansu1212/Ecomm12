package com.example.firstAPI.InheritanceMappingDemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class instructor extends user{
    private String favStudent;
}
