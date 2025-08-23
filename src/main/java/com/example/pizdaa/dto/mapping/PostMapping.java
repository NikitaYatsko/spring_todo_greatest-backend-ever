package com.example.pizdaa.dto.mapping;

import com.example.pizdaa.dto.PostDTO;
import com.example.pizdaa.model.PostModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PostMapping {
    PostDTO toDTO (PostModel post);
    PostModel toEntity(PostDTO postDTO);
}
