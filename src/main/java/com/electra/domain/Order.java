package com.electra.domain;


import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {
    private long id;
    private Product product;
    private Customer customer;
    private Supplier supplier;
    private LocalDate orderDate;
}
