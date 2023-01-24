package com.vbelymenko.stock.quote.consumer.mapper;

import com.vbelymenko.stock.quote.avro.StockQuote;
import com.vbelymenko.stock.quote.consumer.entity.StockQuoteEntity;
import com.vbelymenko.stock.quote.consumer.mapper.basic.AvroEntityAbstractMapper;
import com.vbelymenko.stock.quote.consumer.mapper.basic.ModelEntityAbstractMapper;
import com.vbelymenko.stock.quote.consumer.model.StockQuoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockQuoteMapper extends ModelEntityAbstractMapper<StockQuoteModel, StockQuoteEntity>,
        AvroEntityAbstractMapper<StockQuote, StockQuoteEntity> {
    StockQuoteModel mapEntityToModel(StockQuoteEntity entity);

    @Mapping(target = "id", ignore = true)
    StockQuoteEntity mapModelToEntity(StockQuoteModel model);
}
