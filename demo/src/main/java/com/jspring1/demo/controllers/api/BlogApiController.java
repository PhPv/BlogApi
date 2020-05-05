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
public class BlogApiController {

    @Autowired
    private PostRepository repository;

    @GetMapping(value = "api/post_get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Post> postGet(@RequestParam(value="id", defaultValue = "") String id) {
        return repository.findById(id);
    }

    @DeleteMapping("api/post_del")
    public String postDelete(@RequestParam(value="id", defaultValue = "") String id) {
        Post post = repository.findById(id).orElseThrow();
        repository.delete(post);
        return "Post was deleted";
    }

    @DeleteMapping("api/post_del_all")
    public String postDeleteAll() {
        repository.deleteAll();
        return "All post was deleted";
    }

    @RequestMapping(value = "api/post_add", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postAdd(@RequestBody JSONObject body) {
        Post result = new Post();
        result.setTitle(body.get("title").toString());
        result.setAnons(body.get("anons").toString());
        result.setFull_text(body.get("full_text").toString());
        repository.save(result);
        return result;
    }

    @RequestMapping(value = "api/post_patch", method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Post postPatch(@RequestBody JSONObject body, @RequestParam(value="id", defaultValue = "") String id) {
        Post result = new Post();
        result.setId(id);
        result.setTitle(body.get("title").toString());
        result.setAnons(body.get("anons").toString());
        result.setFull_text(body.get("full_text").toString());
        repository.save(result);
        return result;
    }

    @RequestMapping(value = "api/post_get_all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List postGetAll() {
        return repository.findAll();

    }
}
