package com.jspring1.demo.repo;

import com.jspring1.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
//    public Post findByFirstName(String firstName);
//    public List<Post> findByLastName(String lastName);
}
