package com.roadmap.url_shortener.repository;

import com.roadmap.url_shortener.model.URL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Repository
public interface URLRepository extends MongoRepository<URL, String> {
    Optional<URL> findByShortCode(String shortCode);
}
