package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable pageable);

    @Query(value = "select c.id as id, c.address as address, c.date_of_birth as date_of_birth, c.email as email, " +
            "c.gender as gender, c.id_card as id_card, c.`name` as `name`, c.phone as phone, c.customer_type_id as customer_type_id " +
            "from customer as c " +
            "inner join contract ct on ct.customer_id = c.id " +
            "where ct.start_date > curdate() " +
            "and `name` like %?1% " +
            "and date_of_birth like %?2% " +
            "and customer_type_id like %?3% ", countQuery= "select count(*) from customer as c" , nativeQuery= true)
    Page<Customer> findCs(String name, String dateOfBirth, String customerType, Pageable pageable);

    @Query(value = "select * " +
            "from customer " +
            "where `name` like %?1% " +
            "and date_of_birth like %?2% " +
            "    and customer_type_id like %?3%", nativeQuery=true)
    Page<Customer> findSearch(String name, String dateOfBirth, String customerType, Pageable pageable);

}
