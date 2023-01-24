package com.vbelymenko.stock.quote.producer.publisher;

import com.vbelymenko.stock.quote.avro.StockQuote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockQuoteProducer {
    private final KafkaTemplate<String, StockQuote> kafkaTemplate;
    private static final String TOPIC_NAME = "stock-quotes";

    public void produce(StockQuote stockQuote) {
        log.info("Produce stock quote: {}, {}, {}", stockQuote.getSymbol(), stockQuote.getCurrency(), stockQuote.getTradeValue());
        kafkaTemplate.send(TOPIC_NAME, stockQuote.getSymbol(), stockQuote);
    }
}
