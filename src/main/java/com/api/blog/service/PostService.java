package com.api.blog.service;

import java.util.List;
import java.util.UUID;

import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;

public interface PostService {

    PostResposta save(PostRequest postRequest);

    List<PostResposta> findAll();

    PostResposta findById(UUID id);
}
