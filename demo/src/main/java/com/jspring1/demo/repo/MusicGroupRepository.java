package com.jspring1.demo.repo;

import com.jspring1.demo.model.MusicGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusiсGroupRepository extends MongoRepository<MusicGroup, String> {
}
