package com.vbelymenko.stock.quote.consumer.controller;

import com.vbelymenko.stock.quote.consumer.model.StockQuoteModel;
import com.vbelymenko.stock.quote.consumer.service.StockQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StockQuoteController {
    private final StockQuoteService stockQuoteService;

    @GetMapping("/stocks")
    public ResponseEntity<List<StockQuoteModel>> get() {
        return ResponseEntity.ok(stockQuoteService.findAll());
    }
}
