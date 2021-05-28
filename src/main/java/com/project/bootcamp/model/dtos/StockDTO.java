package com.project.bootcamp.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StockDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull()
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;

    public StockDTO(Long id, String name, Double price, LocalDate date, Double variation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.variation = variation;
    }

    public StockDTO() {

    }

    public Long getId() {
        return id;
    }

    public StockDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StockDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public StockDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public StockDTO setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Double getVariation() {
        return variation;
    }

    public StockDTO setVariation(Double variation) {
        this.variation = variation;
        return this;
    }
}
