package com.jspring1.demo.repo;

import com.jspring1.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.OptionalInt;
//import org.springframework.data.mongodb.repository.MongoRepository;

/*public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}*/

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUsername(String username);
}