package com.project.bootcamp.mapper;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dtos.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setId(stockDTO.getId())
                .setName(stockDTO.getName())
                .setDate(stockDTO.getDate())
                .setPrice(stockDTO.getPrice())
                .setVariation(stockDTO.getVariation());

        return stock;
    }

    public StockDTO toDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId())
                .setName(stock.getName())
                .setDate(stock.getDate())
                .setPrice(stock.getPrice())
                .setVariation(stock.getVariation());

        return stockDTO;
    }

    public List<StockDTO> toDTO(List<Stock> stocks) {
        return stocks.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
