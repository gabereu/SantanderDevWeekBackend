package com.project.bootcamp.repository;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dtos.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

//    @Query(
//            "SELECT * " +
//            "FROM Stock " +
//            "WHERE Stock.date = CURRENT_DATE"
//    )
    List<Stock> findByDate(LocalDate date);
}
