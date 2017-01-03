package com.tsimura.getshared.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GetMapping()
    public ResponseEntity<Void> home(UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/entries").build().toUri());
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
