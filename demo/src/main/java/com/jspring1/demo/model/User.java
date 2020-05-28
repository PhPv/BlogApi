package com.jspring1.demo.model;

import com.jspring1.demo.repo.Role;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@Builder
@Entity
@ToString
@Data
@Document(collection = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;
    private String username;
    private Object password;
    private Role role;

    public User() {}

    public User (String username, String password) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = Role.USER;
    }
}
