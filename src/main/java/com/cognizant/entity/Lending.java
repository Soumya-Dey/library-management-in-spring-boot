package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lendings")
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date lendDate;
    private Date returnDate;
    @ManyToOne
    private User userFk;
    @ManyToOne
    private Book bookFk;
    private boolean accepted;

    public Lending() {
    }

    public Lending(Long id, Date lendDate, Date returnDate, User userFk, Book bookFk, boolean accepted) {
        super();
        this.id = id;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.userFk = userFk;
        this.bookFk = bookFk;
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", lendDate='" + lendDate + "'" +
                ", returnDate='" + returnDate + "'" +
                ", userFk='" + userFk + "'" +
                ", bookFk='" + bookFk + "'" +
                ", accepted='" + accepted + "'" +
                "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLendDate() {
        return this.lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getUserFk() {
        return this.userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    public Book getBookFk() {
        return this.bookFk;
    }

    public void setBookFk(Book bookFk) {
        this.bookFk = bookFk;
    }

    public boolean isAccepted() {
        return this.accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}
