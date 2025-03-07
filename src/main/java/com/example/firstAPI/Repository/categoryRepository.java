package com.example.firstAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstAPI.Model.Catagory;

public interface categoryRepository extends JpaRepository<Catagory,Long>{

}
