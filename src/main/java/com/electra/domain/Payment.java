package com.electra.domain;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment{
    private long id;
    private Double amount;
    private LocalDate paymentDate;
    private Customer customer;
    private Order order;
}
