package com.jspring1.demo.controllers;


import com.jspring1.demo.model.Post;

import com.jspring1.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private PostRepository repository;

    @GetMapping("/")
    public String blogMain(Model model) {
        Iterable<Post> posts = repository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
    @GetMapping("/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/add")
        public String blogPostAdd(@RequestParam String title, @RequestParam String preview, @RequestParam String content, Model model) {
            Post post = new Post(title, preview, content);
            repository.save(post);
            return "redirect:/blog";
        }

    @GetMapping("/{id}")
    public String blogDetails(@PathVariable(value= "id") String id, Model model) {
        if(!repository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = repository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/{id}/edit")
    public String blogEdit(@PathVariable(value= "id") String id, Model model) {
        if(!repository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = repository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/{id}/edit")
    public String blogPostUpdate(@PathVariable(value= "id") String id, @RequestParam String title, @RequestParam String preview, @RequestParam String content, Model model) {
        Post post = repository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setPreview(preview);
        post.setContent(content);
        repository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/{id}/remove")
    public String blogPostDelete(@PathVariable(value= "id") String id, Model model) {
        Post post = repository.findById(id).orElseThrow();
        repository.delete(post);
        return "redirect:/blog";
    }
}
