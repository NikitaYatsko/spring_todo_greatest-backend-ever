package com.example.pizdaa.controller;

import com.example.pizdaa.model.PostModel;
import com.example.pizdaa.service.PostService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostModel> getAllTodos() {
        return postService.getAllPosts();
    }

    @GetMapping("{id}")
    public PostModel getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostModel savePost(@RequestBody PostModel postModel) {
        return postService.savePost(postModel);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Integer id) {
        postService.deletePost(id);
    }

    @PutMapping("{id}")
    public PostModel updateTodo(@PathVariable Integer id, @RequestBody PostModel postModel) {
        return postService.updatePost(id, postModel);
    }
}
