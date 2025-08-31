package com.example.pizdaa.controller;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.savePost(postDTO));
    }
    @PostMapping("/batch")
    public ResponseEntity<List<PostDTO>> createPosts(@RequestBody List<PostDTO> posts) {
        posts.forEach(postService::savePost);
        return ResponseEntity.ok(posts);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Integer id, @RequestBody PostDTO postDTO) {
        PostDTO updatedPostDTO = postService.updatePost(id, postDTO);
        URI location = URI.create("/posts/" + id);
        return ResponseEntity.created(location).body(updatedPostDTO);
    }


}
