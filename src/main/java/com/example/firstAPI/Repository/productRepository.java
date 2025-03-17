package com.example.firstAPI.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.firstAPI.Model.Catagory;
import com.example.firstAPI.Model.Product;
import com.example.firstAPI.Projection.getProductElements;

public interface productRepository extends JpaRepository<Product,Long>{

    Optional<Product> getByid(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    List<Product> findByCatagory(Catagory c);

    @Query("Select p.id as id,p.title as title from Product p where id =:id")
    List<getProductElements> getAllDetailsFromProductHQL(@Param("id") Long id);

    @Query(value = "Select p.id as id,p.title as title from product p where p.id =:id and p.price >100",nativeQuery = true)
    List<getProductElements> getAllDetailsFromProductNativeSql(@Param("id") Long id);
}
