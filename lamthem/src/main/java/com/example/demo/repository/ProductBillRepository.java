package com.example.demo.repository;

import com.example.demo.model.Bill;
import com.example.demo.model.CourseRatingKey;
import com.example.demo.model.ProductBill;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBillRepository extends JpaRepository<ProductBill, CourseRatingKey> {

    List<ProductBill> findByBill(Bill bill);

    List<ProductBill> findByBill_DateAndProductNameContainingAndProduct_ProductDetail_Cost(
            String date, String name, double cost);
}
