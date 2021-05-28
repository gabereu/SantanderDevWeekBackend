package com.project.bootcamp.service;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.exceptions.NotFoundException;
import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dtos.StockDTO;
import com.project.bootcamp.repository.IStockRepository;
import com.project.bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private IStockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;

    @Transactional
    public StockDTO save(StockDTO stockDTO) {
        Optional<Stock> optionalStock = stockRepository.findByNameAndDate(stockDTO.getName(), stockDTO.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = stockMapper.toEntity(stockDTO);
        stock = stockRepository.save(stock);
        return stockMapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO stockDTO) {
        if (stockDTO.getId() == null){
            throw new BusinessException(MessageUtils.UPDATE_STOCK_REQUIRE_ID);
        }

        Optional<Stock> optionalStock = stockRepository.findByNameAndDate(stockDTO.getName(), stockDTO.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = stockMapper.toEntity(stockDTO);
        stock = stockRepository.save(stock);
        return stockMapper.toDTO(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> stocks = stockRepository.findAll();

        return  stockMapper.toDTO(stocks);

    }

    @Transactional(readOnly = true)
    public StockDTO findByID(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if (!stock.isPresent()){
            throw new BusinessException(MessageUtils.RESOURCE_NOT_FOUND);
        }

        return stockRepository.findById(id).map(stockMapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO stockDTO = this.findByID(id);
        stockRepository.deleteById(stockDTO.getId());
        return  stockDTO;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return stockMapper.toDTO(stockRepository.findByDate(LocalDate.now()));
    }
}
