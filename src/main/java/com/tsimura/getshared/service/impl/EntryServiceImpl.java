package com.tsimura.getshared.service.impl;

import com.tsimura.getshared.domain.Entry;
import com.tsimura.getshared.repository.EntryRepository;
import com.tsimura.getshared.service.EntryService;
import com.tsimura.getshared.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl extends AbstractService<Entry> implements EntryService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private EntryRepository dao;

    @Override
    protected PagingAndSortingRepository<Entry, Long> getDao() {
        return dao;
    }
}
