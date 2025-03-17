package com.example.firstAPI.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstAPI.Model.Catagory;

public interface categoryRepository extends JpaRepository<Catagory,Long>{

    Catagory getByid(Long id);
    Optional<Catagory> findByname(String name);
    List<Catagory> findAll();
}
