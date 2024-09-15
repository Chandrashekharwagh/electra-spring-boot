package com.electra.domain;

import lombok.*;

import java.util.Objects;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Address {
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private long postalCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(country, address.country) &&
                Objects.equals(postalCode, address.postalCode);
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, country, postalCode);
    }
}



