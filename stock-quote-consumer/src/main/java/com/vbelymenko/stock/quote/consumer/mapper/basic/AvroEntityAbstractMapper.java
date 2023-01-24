package com.vbelymenko.stock.quote.consumer.mapper.basic;

public interface AvroEntityAbstractMapper<A, E> {
    A mapEntityToAvro(E entity);

    E mapAvroToEntity(A avro);
}
