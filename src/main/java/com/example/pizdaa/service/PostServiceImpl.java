package com.example.pizdaa.service;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.dto.mapping.PostMapping;
import com.example.pizdaa.exception.PostNotFoundException;
import com.example.pizdaa.model.PostModel;
import com.example.pizdaa.repository.PostRepository;
import jakarta.transaction.Transactional;
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


    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapping::toDTO)
                .toList();
    }


    @Override
    public PostDTO getPostById(Integer id) {
        PostModel post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id " + id));
        return postMapping.toDTO(post);
    }


    @Override
    public PostDTO savePost(PostDTO postDTO) {
        PostModel postModel = postMapping.toEntity(postDTO);
        PostModel savedPost = postRepository.save(postModel);
        return postMapping.toDTO(savedPost);
    }

    @Override
    public void deletePost(Integer id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException("Post not found with id " + id);
        }
        postRepository.deleteById(id);
    }

    @Transactional
    @Override
    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        PostModel existingPost = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id " + id));

        if (postDTO.getTitle() != null) existingPost.setTitle(postDTO.getTitle());
        if (postDTO.getContent() != null) existingPost.setContent(postDTO.getContent());

        PostModel updatedPost = postRepository.save(existingPost);
        return postMapping.toDTO(updatedPost);
    }
}
