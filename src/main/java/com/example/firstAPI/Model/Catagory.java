package com.example.firstAPI.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Catagory extends BaseModel{
    @OneToMany(mappedBy = "catagory", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Product> product;
    private String name;

    public Catagory(){
        super();
    }
}
