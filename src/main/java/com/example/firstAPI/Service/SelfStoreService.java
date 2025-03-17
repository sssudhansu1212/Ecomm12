package com.example.firstAPI.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.firstAPI.Exceptions.ProductNotFoundException;
import com.example.firstAPI.Model.Catagory;
import com.example.firstAPI.Model.Product;
import com.example.firstAPI.Repository.categoryRepository;
import com.example.firstAPI.Repository.productRepository;


@Service("selfstoreservice")
public class SelfStoreService implements ProductService{

    private productRepository productrepository;
    private categoryRepository categoryrepository;
    
    public SelfStoreService(
        categoryRepository categoryrepository, 
        productRepository productrepository){
            this.categoryrepository = categoryrepository;
            this.productrepository = productrepository;
    }

    @Override
    public Product getProductById(Long id)throws ProductNotFoundException{
        Optional<Product> optionalProduct = productrepository.getByid(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+id+" could not be found");
        }
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
          Optional<Catagory> Optionalcatagory = categoryrepository.findByname(product.getCatagory().getName());
          
          if(Optionalcatagory.isPresent()){
            product.setCatagory(Optionalcatagory.get());
          }
          return productrepository.save(product);

    }

    @Override
    public List<Product> getAllProducts(){
        if(productrepository.findAll().isEmpty()){
            throw new RuntimeException("No product available");
        }
        return productrepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product)throws ProductNotFoundException {
        Optional<Product> optionalProduct = productrepository.getByid(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with this id "+id+" does not exsist");
        }

        Product productFromDb = optionalProduct.get();

        if(product.getCatagory() != null){
            product.getCatagory().setUpdatedAt(new Date(System.currentTimeMillis()));
            productFromDb.setCatagory(product.getCatagory());
        }
        if(product.getDescription() != null){
            productFromDb.setDescription(product.getDescription());
        }
        if(product.getTitle() != null){
            productFromDb.setTitle(product.getTitle());
        }
        if(product.getPrice() != 0.0){
            productFromDb.setPrice(product.getPrice());
        }
        if(product.getImageUrl() != null){
            productFromDb.setImageUrl(product.getImageUrl());
        }

        productFromDb.setUpdatedAt(new Date(System.currentTimeMillis()));
        productFromDb = productrepository.save(productFromDb);
        return productFromDb;
    }

    @Override
    public Boolean deleteProduct(Long id)throws ProductNotFoundException {
        Optional<Product> optionalproduct = productrepository.getByid(id);
        if(optionalproduct.isEmpty()){
            throw new ProductNotFoundException("Product with this id "+id+" does not exsist");
        }

        productrepository.deleteById(id);
        return true;
    }

    public List<Catagory> getProductFromCatagory(){
        List<Catagory> c= categoryrepository.findAll();
        // List<Product> p = null;
        // for(Catagory catagory : c){
        //     p = productrepository.findByCatagory(catagory);
        //     for(Product product : p){
        //         product.getTitle();
        //     }
        // }
        
        return c;
    }

}
