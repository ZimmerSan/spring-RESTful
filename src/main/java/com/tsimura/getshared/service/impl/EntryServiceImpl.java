package com.tsimura.getshared.service.impl;

import com.tsimura.getshared.dao.EntryDAO;
import com.tsimura.getshared.domain.Entry;
import com.tsimura.getshared.service.EntryService;
import com.tsimura.getshared.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl extends AbstractService<Entry> implements EntryService {

    @Autowired
    private EntryDAO dao;

    @Override
    protected CrudRepository<Entry, Long> getDao() {
        return dao;
    }
}
