package com.example.pizdaa.service;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.dto.mapping.PostMapping;
import com.example.pizdaa.model.PostModel;
import com.example.pizdaa.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapping postMapping;

    public PostServiceImpl(PostRepository postRepository, PostMapping postMapping) {
        this.postRepository = postRepository;
        this.postMapping = postMapping;
    }

    // Получаем все посты в виде DTO
    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapping::toDTO)
                .toList();
    }

    // Получаем один пост по id в виде DTO
    @Override
    public PostDTO getPostById(Integer id) {
        PostModel post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id " + id));
        return postMapping.toDTO(post);
    }

    // Сохраняем новый пост, принимая DTO
    @Override
    public PostDTO savePost(PostDTO postDTO) {
        PostModel postModel = postMapping.toEntity(postDTO);
        PostModel savedPost = postRepository.save(postModel);
        return postMapping.toDTO(savedPost);
    }

    // Удаляем пост
    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    // Обновляем пост по id, принимая DTO
    @Override
    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        PostModel existingPost = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id " + id));

        if (postDTO.getTitle() != null) existingPost.setTitle(postDTO.getTitle());
        if (postDTO.getContent() != null) existingPost.setContent(postDTO.getContent());

        PostModel updatedPost = postRepository.save(existingPost);
        return postMapping.toDTO(updatedPost);
    }
}
