package com.vbelymenko.stock.quote.consumer.receiver;

import com.vbelymenko.stock.quote.consumer.service.StockQuoteService;
import com.vbelymenko.stock.quote.avro.StockQuote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

;import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockQuoteReceiver {
    private static final String TOPIC_NAME = "stock-quotes";
    private final StockQuoteService stockQuoteService;

//    @KafkaListener(topics = TOPIC_NAME)
//    public void receiveBatch(List<StockQuoteModel> stockQuoteModels,
//                             @Header(RECEIVED_PARTITION) List<Integer> partitions,
//                             @Header(OFFSET) List<Long> offsets) {
//        log.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
//        log.info("Starting the process to receive batch messages");
//        for (int i = 0; i < stockQuoteModels.size(); i++) {
//            stockQuoteService.save(stockQuoteModels.get(i), partitions.get(i), offsets.get(i), i);
//        }
//        log.info("all the batch messages are consumed");
//    }

    @KafkaListener(topics = TOPIC_NAME)
    public void receiveBatch(List<StockQuote> stockQuoteModels) {
        stockQuoteService.saveAll(stockQuoteModels);
    }

//    @KafkaListener(topics = TOPIC_NAME)
//    public void receiveBatch(StockQuote stockQuoteModel) {
//        log.info("Consumed: {}, {} {}", stockQuoteModel.getSymbol(), stockQuoteModel.getCurrency(),
//                stockQuoteModel.getTradeValue());
//    }

}
