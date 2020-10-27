package com.spring.mongodb.springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "Review")
public class Review {
    private String userName;
    private int rating;
    private boolean approved;
}
