package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private int unit;

    @OneToMany(mappedBy = "book")
    private List<BookCode> bookCodes;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public List<BookCode> getBookCodes() {
        return bookCodes;
    }

    public void setBookCodes(List<BookCode> bookCodes) {
        this.bookCodes = bookCodes;
    }
}
