package com.example.firstAPI.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstAPI.Model.Product;

public interface productRepository extends JpaRepository<Product,Long>{

    Optional<Product> getByid(Long id);
    List<Product> findAll();
    void deleteById(Long id);

}
