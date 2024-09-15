package com.electra.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode


public class Address {
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private long postalCode;
}



