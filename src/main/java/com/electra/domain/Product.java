package com.electra.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    private int id;
    private String name;
    private String description;
    private Double price;
    private Long brandId;
}
