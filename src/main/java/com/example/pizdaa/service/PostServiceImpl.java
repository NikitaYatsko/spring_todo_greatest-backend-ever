package com.example.pizdaa.service;

import com.example.pizdaa.model.PostModel;
import com.example.pizdaa.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostModel getPostById(Integer id) {
        return postRepository.getReferenceById(id);
    }

    @Override
    public PostModel savePost(PostModel postModel) {
        if (postModel.getId() != null) {
            throw new IllegalArgumentException("Error while saving post");
        }
        return postRepository.save(postModel);
    }


    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostModel updatePost(Integer id, PostModel postModel) {
        PostModel existingPostModel = getPostById(id);

        if (postModel.getTitle() != null) {
            existingPostModel.setTitle(postModel.getTitle());
        }
        if (postModel.getContent() != null) {
            existingPostModel.setContent(postModel.getContent());
        }

        existingPostModel.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(existingPostModel);
    }



}
