package com.example.firstAPI.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstAPI.Exceptions.ProductNotFoundException;
import com.example.firstAPI.Model.Product;
import com.example.firstAPI.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
       return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
        
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        return  new ResponseEntity<>(productService.createProduct(product),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
       return new ResponseEntity<>(productService.replaceProduct(id, product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable Long id){
        boolean val = productService.deleteProduct(id);
        if(val){
            Map<String,String> response = new HashMap<>();
            response.put("status","Success");
            response.put("message","Product with id " +id +" has been deleted");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }


}
