package com.electra.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Customer {
    private long id;
    private String name;
    private String email;
    private Address address;
}
