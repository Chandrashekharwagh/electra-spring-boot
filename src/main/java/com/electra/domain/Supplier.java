package com.electra.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Supplier {
    private int id;
    private String name;
    private String contactInfo;
}
