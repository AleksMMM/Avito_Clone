package com.example.letscode.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    protected Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

}
