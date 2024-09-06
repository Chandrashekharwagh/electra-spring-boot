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
    private int id;
    private Double amount;
    private LocalDate paymentDate;
    private Long customerId;
    private Long orderId;
}
