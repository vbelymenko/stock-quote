package com.vbelymenko.stock.quote.consumer.repository;

import com.vbelymenko.stock.quote.consumer.entity.StockQuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockQuoteRepository extends JpaRepository<StockQuoteEntity, Long> {
}