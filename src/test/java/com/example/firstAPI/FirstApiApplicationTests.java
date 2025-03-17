package com.example.firstAPI;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstAPI.Model.Catagory;
import com.example.firstAPI.Model.Product;
import com.example.firstAPI.Projection.getProductElements;
import com.example.firstAPI.Repository.productRepository;
import com.example.firstAPI.Service.SelfStoreService;

@SpringBootTest
class FirstApiApplicationTests {

	private productRepository productrepository;
	private SelfStoreService selfStoreService;

	@Autowired
	public FirstApiApplicationTests(productRepository productrepository,SelfStoreService selfStoreService){
		this.productrepository = productrepository;
		this.selfStoreService = selfStoreService;
	}

	@Test
	void contextLoads() {
		List<getProductElements> product = productrepository.getAllDetailsFromProductHQL(1L);

		for(getProductElements element : product){
			System.out.println(element.getId());
			System.out.println(element.getTitle());
		}

		List<getProductElements> product1 = productrepository.getAllDetailsFromProductNativeSql(1L);
	
		for(getProductElements element : product1){
			System.out.println(element.getId());
			System.out.println(element.getTitle());
		}

		List<Catagory> c = selfStoreService.getProductFromCatagory();

		List<Product> p = null;
			for(Catagory catagory : c){
				p = productrepository.findByCatagory(catagory);
				for(Product product2 : p){
					System.out.println(product2.getTitle());
				}
			}
	}

}
