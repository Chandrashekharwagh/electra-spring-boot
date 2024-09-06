package com.electra.domain;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Brand {
    private int id;
    private String name;
    private String description;
}
