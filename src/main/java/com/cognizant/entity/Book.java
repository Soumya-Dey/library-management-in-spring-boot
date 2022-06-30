package com.cognizant.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String author;
    private String publishYear;
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookFk")
    @JsonIgnore
    private Set<Lending> lendings = new HashSet<>();

    public Book() {
    }

    public Book(Long id, String title, String description, String author, String publishYear, int stock,
            Set<Lending> lendings) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publishYear = publishYear;
        this.stock = stock;
        this.lendings = lendings;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", title='" + title + "'" +
                ", description='" + description + "'" +
                ", author='" + author + "'" +
                ", publishYear='" + publishYear + "'" +
                ", stock='" + stock + "'" +
                "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<Lending> getLendings() {
        return this.lendings;
    }

    public void setLendings(Set<Lending> lendings) {
        this.lendings = lendings;
    }
}
