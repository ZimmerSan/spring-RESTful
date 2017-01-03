package com.tsimura.getshared.service.common;

import java.io.Serializable;
import java.util.List;

public interface EntityOperations<T extends Serializable> {

    // read

    T findOne(final long id);

    List<T> findAll();

    // check

    boolean exists(final long id);

    // write

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);


}
