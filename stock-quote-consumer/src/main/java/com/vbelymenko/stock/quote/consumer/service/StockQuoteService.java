package com.vbelymenko.stock.quote.consumer.service;

import com.vbelymenko.stock.quote.consumer.mapper.StockQuoteMapper;
import com.vbelymenko.stock.quote.consumer.model.StockQuoteModel;
import com.vbelymenko.stock.quote.consumer.repository.StockQuoteRepository;
import com.vbelymenko.stock.quote.avro.StockQuote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockQuoteService {
    private final StockQuoteMapper stockQuoteMapper;
    private final StockQuoteRepository stockQuoteRepository;

    // index is position in list of consumed objects
//    @Transactional
//    public void save(StockQuoteModel stockQuoteModel, Integer partition, Long offset, Integer index) {
//        if (stockQuoteModel.getId() % 10 == 0) {
//            log.info("Failed consumed: {}, {}, {} {} from partition: {} offset: {}", stockQuoteModel.getId(), stockQuoteModel.getSymbol(), stockQuoteModel.getCurrency(),
//                    stockQuoteModel.getTradeValue(), partition, offset);
//            throw new BatchListenerFailedException("Listener failed on index:", index);
//        } else {
//            log.info("Consumed: {}, {}, {} {} from partition: {} offset: {}", stockQuoteModel.getId(), stockQuoteModel.getSymbol(), stockQuoteModel.getCurrency(),
//                    stockQuoteModel.getTradeValue(), partition, offset);
//            stockQuoteRepository.save(stockQuoteMapper.mapModelToEntity(stockQuoteModel));
//        }
//    }

    @Transactional
    public void saveAll(List<StockQuote> stockQuotes) {
        stockQuoteRepository.saveAll(stockQuotes.stream()
                .map(stockQuoteMapper::mapAvroToEntity)
                .toList());
    }

    @Transactional(readOnly = true)
    public List<StockQuoteModel> findAll() {
        return stockQuoteRepository.findAll().stream()
                .map(stockQuoteMapper::mapEntityToModel)
                .toList();
    }
}
