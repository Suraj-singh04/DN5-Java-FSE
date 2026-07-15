package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByCode(String code);

    List<Stock> findByTradeDate(LocalDate tradeDate);

    List<Stock> findByClosePriceGreaterThan(BigDecimal price);

    List<Stock> findTop3ByOrderByVolumeDesc();

}