package com.jspring1.demo.controllers.api;

import com.jspring1.demo.model.Post;
import com.jspring1.demo.repo.PostRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PostApiController {

    @Autowired
    private PostRepository repository;

    @GetMapping(value = "api/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Post> postGet(@RequestParam(value="id", defaultValue = "", required = true) String id) {
        return repository.findById(id);
        // 200 Successful operation
        // 400 Invalid ID supplied
        // 404 Post no found
    }

    @PostMapping(value = "api/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postAdd(@RequestBody JSONObject body) {
        Post result = new Post();
        result.setTitle(body.get("title").toString());
        result.setAnons(body.get("anons").toString());
        result.setFull_text(body.get("full_text").toString());
        repository.save(result);
        return result;
        // 200
        //405 invalid input
    }

    @DeleteMapping("api/post")
    public String postDelete(@RequestParam(value="id", defaultValue = "", required = true) String id) {
        Post post = repository.findById(id).orElseThrow();
        repository.delete(post);
        return "Post was deleted";
        //200
        //400 Invalid ID supplied
        //405 Post not found
    }

    @PatchMapping(value = "api/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postPatch(@RequestBody JSONObject body, @RequestParam(value="id", defaultValue = "") String id) {
        Post result = new Post();
        result.setId(id);
        result.setTitle(body.get("title").toString());
        result.setAnons(body.get("anons").toString());
        result.setFull_text(body.get("full_text").toString());
        repository.save(result);
        return result;
        // 200
        // 400 Invalid ID supplied
        // 404 Post not found
        // 405 Validation exception
    }

    @GetMapping(value = "api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List postGetAll() {
        return repository.findAll();
        // 200
        // 404 Posts not found
    }

    @DeleteMapping("api/posts")
    public String postDeleteAll() {
        repository.deleteAll();
        return "All post was deleted";
        // 200
        // 404 Posts not found
    }
}
