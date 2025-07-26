package com.roadmap.url_shortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "urls")
public class URL {
    @Id
    private String id;
    private String shortCode;
    private String longURL;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    private Long accessCount = 0L;
}
