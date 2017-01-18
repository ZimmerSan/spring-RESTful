package com.tsimura.getshared.repository;


import com.tsimura.getshared.domain.Entry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {

    List<Entry> findByTitle(@Param("title") String title);

}
