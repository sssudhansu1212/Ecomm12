package com.example.firstAPI.Service;

import java.util.List;

import com.example.firstAPI.Exceptions.ProductNotFoundException;
import com.example.firstAPI.Model.Product;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product)throws ProductNotFoundException;
    Boolean deleteProduct(Long id)throws ProductNotFoundException;
}
