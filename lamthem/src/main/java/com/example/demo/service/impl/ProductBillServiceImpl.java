package com.example.demo.service.impl;

import com.example.demo.model.Bill;
import com.example.demo.model.ProductBill;
import com.example.demo.repository.ProductBillRepository;
import com.example.demo.service.ProductBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBillServiceImpl implements ProductBillService {

    @Autowired
    ProductBillRepository productBillRepository;
    @Override
    public List<ProductBill> findByBill(Bill bill) {
        return productBillRepository.findByBill(bill);
    }

    @Override
    public List<ProductBill> findByBill_DateAndProductNameContainingAndProduct_ProductDetail_Cost(String date, String name, double cost) {
        return productBillRepository.findByBill_DateAndProductNameContainingAndProduct_ProductDetail_Cost(
                date,name,cost
        );
    }
}
