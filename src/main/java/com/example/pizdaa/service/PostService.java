package com.example.pizdaa.service;

import com.example.pizdaa.model.PostModel;

import java.util.List;

public interface PostService {
 List<PostModel> getAllPosts();
 PostModel getPostById(Integer id);
 PostModel savePost(PostModel postModel);
 void deletePost(Integer id);
 PostModel updatePost(Integer id, PostModel postModel);
}
