package com.example.firstAPI.InheritanceMappingDemo.singletable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("1")
public class TA extends user{
 private String avgRating;
}
