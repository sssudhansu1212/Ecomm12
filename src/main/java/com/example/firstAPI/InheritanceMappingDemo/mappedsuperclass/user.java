package com.example.firstAPI.InheritanceMappingDemo.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
//@Inheritance(Stratergy)
public class user {
    @Id
    private Long id;
    private String email;
    private String name;
}
