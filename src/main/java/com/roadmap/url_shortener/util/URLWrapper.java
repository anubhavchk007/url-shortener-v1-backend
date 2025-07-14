package com.roadmap.url_shortener.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roadmap.url_shortener.model.URL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class URLWrapper {
    private String id;
    private String shortCode;
    private String longURL;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long accessCount;

    public URLWrapper(URL url) {
        this.id = url.getId();
        this.shortCode = url.getShortCode();
        this.longURL = url.getLongURL();
        this.createdAt = url.getCreatedAt();
        this.updatedAt = url.getUpdatedAt();
        this.accessCount = url.getAccessCount();
    }
}
