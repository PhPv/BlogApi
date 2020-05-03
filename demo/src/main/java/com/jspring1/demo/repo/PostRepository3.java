package com.jspring1.demo.repo;

import com.jspring1.demo.model.Post;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public class PostRepository3 implements MongoRepository<Post, String> {
    @Override
    public <S extends Post> S save(S s) {
        return null;
    }

    @Override
    public <S extends Post> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Post> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Iterable<Post> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Post> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Post> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Post> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Post> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Post> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Post> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Post> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Post> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Post> boolean exists(Example<S> example) {
        return false;
    }
//    public Post findByFirstName(String firstName);
//    public List<Post> findByLastName(String lastName);
}
