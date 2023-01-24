package com.vbelymenko.stock.quote.producer.scheduler;

import com.vbelymenko.stock.quote.producer.publisher.StockQuoteProducer;
import com.vbelymenko.stock.quote.producer.util.RandomStockQuoteGenerator;
import com.vbelymenko.stock.quote.avro.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomStockQuoteProducer {

    private final StockQuoteProducer stockQuoteProducer;
    private final RandomStockQuoteGenerator stockQuoteGenerator;

    @Scheduled(fixedRateString = "${stockQuote.producer.rateInMs}")
    public void produceRandomStockQuote() {
        StockQuote stockQuote = stockQuoteGenerator.generateRandomStockQuote();
        stockQuoteProducer.produce(stockQuote);
    }
}
