package com.api.blog.service;

import java.util.List;
import java.util.UUID;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.request.comentarioresponseDto;
import com.api.blog.dto.response.PostResposta;

public interface PostService {
	
    List<PostResposta> findAll();
    PostResposta findById(UUID id);
    PostResposta createPost(PostRequest dto);
    comentarioresponseDto addComentario(UUID postId,ComentarioRequestDto dto);
    PostResposta save(PostRequest postRequest);




}