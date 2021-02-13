package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<User, Integer> {
}
