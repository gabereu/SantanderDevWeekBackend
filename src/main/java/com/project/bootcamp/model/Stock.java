package com.project.bootcamp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private Double price;

    @Column(name = "variation")
    private Double variation;

    public Long getId() {
        return id;
    }

    public Stock setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Stock setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Stock setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getVariation() {
        return variation;
    }

    public Stock setVariation(Double variation) {
        this.variation = variation;
        return this;
    }
}
