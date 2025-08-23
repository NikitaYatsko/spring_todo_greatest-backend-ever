package com.example.pizdaa.service;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.model.PostModel;

import java.util.List;

public interface PostService {
 List<PostDTO> getAllPosts();
 PostDTO getPostById(Integer id);
 PostDTO savePost(PostDTO postDTO);
 void deletePost(Integer id);
 PostDTO updatePost(Integer id, PostDTO postDTO);
}
