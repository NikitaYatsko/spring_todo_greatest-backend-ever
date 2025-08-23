package com.example.pizdaa.controller;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.model.PostModel;
import com.example.pizdaa.service.PostService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/posts")
public class PostController {

   private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{id}")
    public PostDTO getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostDTO savePost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Integer id) {
        postService.deletePost(id);
    }

    @PutMapping("{id}")
    public PostDTO updateTodo(@PathVariable Integer id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }
}
