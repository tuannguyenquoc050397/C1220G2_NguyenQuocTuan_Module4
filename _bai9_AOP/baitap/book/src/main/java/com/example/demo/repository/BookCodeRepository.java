package com.example.demo.repository;

import com.example.demo.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookCodeRepository extends JpaRepository<BookCode, Long> {

    Optional<BookCode> findByCode(Long code);

    void deleteByCode(Long code);


}
