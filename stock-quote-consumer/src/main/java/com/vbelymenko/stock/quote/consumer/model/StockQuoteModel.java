package com.vbelymenko.stock.quote.consumer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockQuoteModel {
    private Long id;
    private String symbol;
    private String exchange;
    private String currency;
    private String tradeValue;
    private Long tradeTime;
}
