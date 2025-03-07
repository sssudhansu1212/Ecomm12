package com.example.firstAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.firstAPI.Exceptions.ProductNotFoundException;
import com.example.firstAPI.Model.Product;

@Service("selfstoreservice")
public class SelfStoreService implements ProductService{

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceProduct'");
    }

    @Override
    public Boolean deleteProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

}
