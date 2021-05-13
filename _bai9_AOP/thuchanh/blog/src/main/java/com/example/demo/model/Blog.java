package com.example.demo.model;


import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String content;

    private String dayPost;

    public String getDayPost() {
        return dayPost;
    }

    public void setDayPost(String dayPost) {
        this.dayPost = dayPost;
    }

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Blog() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
