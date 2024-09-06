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
    private int id;
    private int productId;
    private int customerId;
    private LocalDate orderDate;
}
