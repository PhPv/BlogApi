package com.jspring1.demo.controllers;


import com.jspring1.demo.model.MusicGroup;
import com.jspring1.demo.model.Post;
import com.jspring1.demo.repo.PostRepository;
import com.jspring1.demo.repo.MusiсGroupRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class apiController {

    @Autowired
    private PostRepository repository;
    @Autowired
    private MusiсGroupRepository repository2;

    @GetMapping(value = "api/post_get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Post> postGet(@RequestParam(value="id", defaultValue = "") String id) {
        return repository.findById(id);
    }

    @GetMapping(value = "api/group_get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MusicGroup> groupGet(@RequestParam(value="id", defaultValue = "") String id) {
        return repository2.findById(id);
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

    @RequestMapping(value = "api/group_add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupAdd(@RequestBody JSONObject body) {
        MusicGroup result = new MusicGroup();
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body. get("country").toString());
        repository2.save(result);
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
