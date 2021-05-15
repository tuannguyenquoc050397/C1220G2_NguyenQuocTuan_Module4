package com.example.demo.service;

import com.example.demo.model.Bill;
import com.example.demo.model.ProductBill;

import java.util.List;

public interface ProductBillService {

    List<ProductBill> findByBill(Bill bill);
    List<ProductBill> findByBill_DateAndProductNameContainingAndProduct_ProductDetail_Cost(
            String date, String name, double cost);

}
