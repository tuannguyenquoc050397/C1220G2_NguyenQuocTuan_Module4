package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);

    @Query(value = "select * " +
            "from product " +
            "where `name` like %?1% " +
            "and  ( ?2 IS NULL  OR cost = ?2 ) " +
            "    and category_id like %?3%", nativeQuery=true)
    Page<Product> findSearch(String name, Integer cost, String category, Pageable pageable);

//    @Query(value = "select * from product " +
//            "order by cost ", nativeQuery=true)
//    Page<Product> sortByCost(Pageable pageable);


}
