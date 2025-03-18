package com.example.codewithmosh.repositories;

import com.example.codewithmosh.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
