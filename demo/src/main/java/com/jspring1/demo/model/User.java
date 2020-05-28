package com.jspring1.demo.model;

import com.jspring1.demo.repo.Role;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@ToString
@Data
@Document(collection = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String username;
    private Object password;
    private Role role;
    private boolean active;

    public static User build(Long id, String username, String password, Role role) {
        return builder().id(id).username(username).role(role)
                .password(new BCryptPasswordEncoder().encode(password)).build();
    }
    //разобраться
    /*@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) //fetch как загружаются данные
                                                                        // EAHER сразу выгружает все роли пользователя
                                                                        // Lazy Грузит только при обращении, для больших данных
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(String username, Object password) {
        this.username = username;
        this.password = password;
    }*/


}
