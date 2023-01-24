package com.vbelymenko.stock.quote.producer.util;

import com.vbelymenko.stock.quote.avro.StockQuote;
import lombok.Value;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomStockQuoteGenerator {

    private final List<Instrument> instruments;
    private static final String STOCK_EXCHANGE_NASDAQ = "NASDAQ";
    private static final String STOCK_EXCHANGE_AMSTERDAM = "AMS";

    private static final String CURRENCY_EURO = "EUR";
    private static final String CURRENCY_US_DOLLAR = "USD";

    public RandomStockQuoteGenerator() {
        instruments = Arrays.asList(new Instrument("AAPL", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
                new Instrument("AMZN", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
                new Instrument("GOOGL", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
                new Instrument("NFLX", STOCK_EXCHANGE_NASDAQ, CURRENCY_US_DOLLAR),
                new Instrument("INGA", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO),
                new Instrument("AD", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO),
                new Instrument("RDSA", STOCK_EXCHANGE_AMSTERDAM, CURRENCY_EURO));
    }

    public StockQuote generateRandomStockQuote() {
        Instrument randomInstrument = pickRandomInstrument();
        BigDecimal randomPrice = generateRandomPrice();
        return new StockQuote(randomInstrument.getSymbol(), randomInstrument.getExchange(), randomPrice.toPlainString(),
                randomInstrument.getCurrency(), Instant.now().toEpochMilli());
    }

    private BigDecimal generateRandomPrice() {
        double leftLimit = 1.000D;
        double rightLimit = 3000.000D;

        BigDecimal randomPrice = BigDecimal.valueOf(new RandomDataGenerator().nextUniform(leftLimit, rightLimit));
        randomPrice = randomPrice.setScale(3, RoundingMode.HALF_UP);
        return randomPrice;
    }

    private Instrument pickRandomInstrument() {
        int randomIndex = new Random().nextInt(instruments.size());
        return instruments.get(randomIndex);
    }

    @Value
    private static class Instrument {
        String symbol;
        String exchange;
        String currency;
    }
}
