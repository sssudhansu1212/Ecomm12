package com.example.firstAPI.InheritanceMappingDemo.tableperclass;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="tbc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class user {
    @Id
    private Long id;
    private String email;
    private String name;
}
