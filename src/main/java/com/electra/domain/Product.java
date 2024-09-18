package com.electra.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    private long id;
    private String name;
    private String description;
    private Double price;
    private Brand brand;
}
