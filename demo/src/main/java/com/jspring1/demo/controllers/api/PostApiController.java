package com.jspring1.demo.controllers.api;

import com.jspring1.demo.exceptions.*;
import com.jspring1.demo.model.Post;
import com.jspring1.demo.repo.PostRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("api")
public class PostApiController {

    @Autowired
    private PostRepository repository;

    @GetMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Post> postGet(@RequestParam(value="id", defaultValue = "", required = true) String id) throws Exception400, Exception404{
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        return repository.findById(id);
        // 401 Unauthorized
    }


    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postAdd(@RequestBody JSONObject body) throws Exception405 {
        if (
        body.get("title").toString().isEmpty() ||
        body.get("preview").toString().isEmpty() ||
        body.get("content").toString().isEmpty())
        {
            throw new Exception405();
        }
        Post result = new Post();
        result.setTitle(body.get("title").toString());
        result.setPreview(body.get("preview").toString());
        result.setContent(body.get("content").toString());
        repository.save(result);
        return result;
        // 401 Unauthorized
    }

    @DeleteMapping("/post")
    public String postDelete(@RequestParam(value="id", defaultValue = "", required = true) String id) throws Exception400, Exception404 {
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        Post post = repository.findById(id).orElseThrow();
        repository.delete(post);
        return "Post was deleted";
        // 401 Unauthorized
        // 418 Unauthorized admin
    }

    @PutMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postPatch(@RequestBody JSONObject body, @RequestParam(value="id", defaultValue = "") String id) throws Exception400, Exception404{
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        Post result = new Post();
        result.setId(id);
        result.setTitle(body.get("title").toString());
        result.setPreview(body.get("preview").toString());
        result.setContent(body.get("content").toString());
        repository.save(result);
        return result;
        // 401 Unauthorized
    }

    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List postGetAll() throws Exception404{
        if (repository.findAll().isEmpty()) {
            throw new Exception404();
        }
        return repository.findAll();
    }

    @DeleteMapping("/posts")
    public String postDeleteAll() throws Exception404{
        if (repository.findAll().isEmpty()) {
            throw new Exception404();
        }
        repository.deleteAll();
        return "All post was deleted";
        // 401 Unauthorized
        // 418 Unauthorized admin
    }

}
