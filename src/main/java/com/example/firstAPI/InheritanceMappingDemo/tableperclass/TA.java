package com.example.firstAPI.InheritanceMappingDemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_TA")
public class TA extends user{
 private String avgRating;
}
