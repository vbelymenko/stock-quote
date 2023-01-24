package com.vbelymenko.stock.quote.consumer.mapper.basic;

public interface ModelEntityAbstractMapper<M, E> {
    M mapEntityToModel(E entity);

    E mapModelToEntity(M model);

}
