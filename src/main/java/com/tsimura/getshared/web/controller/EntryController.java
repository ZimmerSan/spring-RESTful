package com.tsimura.getshared.web.controller;

import com.tsimura.getshared.domain.Entry;
import com.tsimura.getshared.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
class EntryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntryController.class);

    @Autowired
    private EntryService entryService;

    @GetMapping()
    public ResponseEntity<List<Entry>> findAll() {
        LOGGER.debug("GetAllEntries");
        List<Entry> entries = entryService.findAll();
        if (entries.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> findOne(@PathVariable("id") Integer id) {
        LOGGER.debug("retrieving Entry with id = {}", id);

        Entry entry = entryService.findOne(id);
        if (entry == null) {
            LOGGER.warn("Entry with id = {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Entry entry, UriComponentsBuilder ucBuilder) {
        LOGGER.debug("creating entry = {}", entry);

        if (entryService.exists(entry.getId())) {
            LOGGER.warn("entry {} already exist", entry);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        entryService.create(entry);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/entries/{id}").buildAndExpand(entry.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entry> update(@PathVariable("id") Integer id, @RequestBody Entry entry){
        LOGGER.debug("Updating Entry {}", id);

        Entry currentEntry = entryService.findOne(id);
        if (currentEntry == null) {
            LOGGER.warn("Entry with id = {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentEntry.setTitle(entry.getTitle());
        currentEntry.setModified(new Date());

        entryService.update(currentEntry);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entry> delete(@PathVariable("id") Integer id) {
        LOGGER.debug("Fetching and deleting Entry with id = {}", id);

        Entry entry = entryService.findOne(id);
        if (entry == null) {
            LOGGER.warn("Entry with id = {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        entryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
