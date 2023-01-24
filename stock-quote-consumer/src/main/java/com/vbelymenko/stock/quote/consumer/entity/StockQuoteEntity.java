package com.vbelymenko.stock.quote.consumer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "STOCK")
public class StockQuoteEntity {
    @Id
    @Column(name = "STOCK_SERIAL_NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_SEQ")
    @SequenceGenerator(name = "STOCK_SEQ", sequenceName = "STOCK_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "EXCHANGE")
    private String exchange;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "TRADE_VALUE")
    private String tradeValue;
    @Column(name = "TRADE_TIME")
    private Long tradeTime;
}
