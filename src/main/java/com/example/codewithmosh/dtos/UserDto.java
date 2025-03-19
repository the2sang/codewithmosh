package com.example.codewithmosh.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.codewithmosh.entities.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String name;
    String email;
    String password;
    List<AddressDto> addresses;

    /**
     * DTO for {@link com.example.codewithmosh.entities.Address}
     */
    @Value
    public static class AddressDto implements Serializable {
        Long id;
        String street;
        String city;
        String zip;
        String state;


    }
}