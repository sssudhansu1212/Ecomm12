package com.example.firstAPI.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import com.example.firstAPI.DTO.FakeStoreProductDTO;
import com.example.firstAPI.Exceptions.ProductNotFoundException;
import com.example.firstAPI.Model.Catagory;
import com.example.firstAPI.Model.Product;

@Service("fakestoreservice")
public class FakeStoreService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    FakeStoreService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Product convertFakeStoreProductToProduct(FakeStoreProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setCatagory(new Catagory());
        //product.getCatagory().setId(1L);
        product.getCatagory().setName(productDTO.getCategory());

        return product;
    }

    public FakeStoreProductDTO convertProductToFakeStoreProductDTO(Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setCategory(product.getCatagory().getName());
        return fakeStoreProductDTO;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        
        String url = "https://fakestoreapi.com/products/{id}";
        FakeStoreProductDTO productDTO = restTemplate.getForObject(url,FakeStoreProductDTO.class,id);

        if(productDTO == null){
            throw new ProductNotFoundException(" This product is not available with us");
        }
        return convertFakeStoreProductToProduct(productDTO);
    }

    public Product createProduct(Product product){

        FakeStoreProductDTO fakeStoreProductDTO = convertProductToFakeStoreProductDTO(product);
        String url = "https://fakestoreapi.com/products";

        FakeStoreProductDTO productDTO = restTemplate.postForObject(url,fakeStoreProductDTO,FakeStoreProductDTO.class);

        return convertFakeStoreProductToProduct(productDTO);

    }

    public List<Product> getAllProducts(){

        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject(url, FakeStoreProductDTO[].class);

        List<Product> product = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOs){
            product.add(convertFakeStoreProductToProduct(fakeStoreProductDTO));
        }

        return product;
    }

    public Product replaceProduct(Long id,Product product)throws ProductNotFoundException{

        String  url = "https://fakestoreapi.com/products/{id}";

        FakeStoreProductDTO fakeStoreProductDTOInput = convertProductToFakeStoreProductDTO(product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTOInput, FakeStoreProductDTO.class);

		HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());

		FakeStoreProductDTO fakeStoreProductDTO = restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, id);

        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException("Product with this id "+id+" doesnt exsists");
        }

        return convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }

    public Boolean deleteProduct(Long id)throws ProductNotFoundException{
        String url = "https://fakestoreapi.in/api/products/{id}";
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(url, FakeStoreProductDTO.class,id);

        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException("Product with this id "+id+" doesnt exsists");
        }
        restTemplate.delete(url,id);
        return true;
    }

}
