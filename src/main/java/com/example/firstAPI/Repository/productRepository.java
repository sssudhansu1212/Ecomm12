package com.example.firstAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstAPI.Model.Product;

public interface productRepository extends JpaRepository<Product,Long>{

}
