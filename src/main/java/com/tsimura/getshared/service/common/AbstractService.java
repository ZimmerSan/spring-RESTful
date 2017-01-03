package com.tsimura.getshared.service.common;

import com.google.common.collect.Lists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements EntityOperations<T> {

    @Override
    @Transactional(readOnly = true)
    public T findOne(long id) {
        return getDao().findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public boolean exists(long id){
        return getDao().exists(id);
    }

    @Override
    public T create(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().delete(entityId);
    }

    protected abstract CrudRepository<T, Long> getDao();
}
