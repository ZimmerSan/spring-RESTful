package com.tsimura.getshared.dao;


import com.tsimura.getshared.domain.Entry;
import org.springframework.data.repository.CrudRepository;


public interface EntryDAO extends CrudRepository<Entry, Long>{

}
