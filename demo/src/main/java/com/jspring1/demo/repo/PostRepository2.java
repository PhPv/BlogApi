package com.jspring1.demo.repo;

import com.jspring1.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository2 extends MongoRepository<Post, String> {
//    public Post findByFirstName(String firstName);
//    public List<Post> findByLastName(String lastName);
}
