package com.example.codewithmosh.repositories;

import com.example.codewithmosh.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
