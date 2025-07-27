package com.roadmap.url_shortener.controller;

import com.roadmap.url_shortener.dto.URLdto;
import com.roadmap.url_shortener.model.URL;
import com.roadmap.url_shortener.repository.URLRepository;
import com.roadmap.url_shortener.util.ShortenURL;
import com.roadmap.url_shortener.util.URLWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("shorten")
public class URLController {

    @Autowired
    private URLRepository urlRepository;

    @PostMapping
    public ResponseEntity<?> createURL(@RequestBody URLdto urlDto) {
        URL myURL = new URL();
        LocalDateTime thisInstant = LocalDateTime.now();
        myURL.setCreatedAt(thisInstant);
        myURL.setUpdatedAt(thisInstant);
        myURL.setLongURL(urlDto.getUrl());
        String shortenedURL;
        do {
            shortenedURL = ShortenURL.encode(urlDto.getUrl());
        } while (urlRepository.findByShortCode(shortenedURL).isPresent());
        myURL.setShortCode(shortenedURL);
        urlRepository.save(myURL);
        return new ResponseEntity<>(myURL, HttpStatus.CREATED);
    }

    @GetMapping("{shortCode}")
    public ResponseEntity<?> getOriginalURL(@PathVariable String shortCode) {
        Optional<URL> myURL = urlRepository.findByShortCode(shortCode);
        if (myURL.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        myURL.get().setAccessCount(myURL.get().getAccessCount() + 1);
        urlRepository.save(myURL.get());
        return new ResponseEntity<>(myURL.get(), HttpStatus.OK);
    }

    @PutMapping("{shortCode}")
    public ResponseEntity<?> updateURL(@PathVariable String shortCode, @RequestBody URLdto urlDto) {
        Optional<URL> myURL = urlRepository.findByShortCode(shortCode);
        if (myURL.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        myURL.get().setLongURL(urlDto.getUrl());
        myURL.get().setUpdatedAt(LocalDateTime.now());
        urlRepository.save(myURL.get());
        return new ResponseEntity<>(myURL.get(), HttpStatus.OK);
    }

    @DeleteMapping("{shortCode}")
    public ResponseEntity<?> deleteURL(@PathVariable String shortCode) {
        Optional<URL> myURL = urlRepository.findByShortCode(shortCode);
        if (myURL.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        urlRepository.delete(myURL.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{shortCode}/stats")
    public ResponseEntity<?> getStatistics(@PathVariable String shortCode) {
        Optional<URL> myURL = urlRepository.findByShortCode(shortCode);
        if (myURL.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        URLWrapper urlWrapper = new URLWrapper(myURL.get());
        return new ResponseEntity<>(urlWrapper, HttpStatus.OK);
    }
}
