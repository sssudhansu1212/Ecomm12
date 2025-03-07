package com.example.firstAPI.InheritanceMappingDemo.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "userType",
    discriminatorType = DiscriminatorType.INTEGER
)

@DiscriminatorValue("0")
public class user {
    @Id
    private Long id;
    private String email;
    private String name;
}
