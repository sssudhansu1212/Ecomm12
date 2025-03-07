package com.example.firstAPI.InheritanceMappingDemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class user {
    @Id
    private Long Id;
    private String email;
    private String name;
}
