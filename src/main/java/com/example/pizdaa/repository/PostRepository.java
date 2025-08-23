package com.example.pizdaa.repository;

import com.example.pizdaa.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Integer> {
}
