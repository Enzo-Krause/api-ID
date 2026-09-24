package com.api.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.mapper.PoatMapper;
import com.api.blog.model.PostModel;
import com.api.blog.repository.PostRepository;

@Service
public class PostServerceImpl implements PostService {

    private final PostRepository postRepository;
    private final PoatMapper poatMapper;

    public PostServerceImpl(PostRepository postRepository, PoatMapper poatMapper) {
        this.postRepository = postRepository;
        this.poatMapper = poatMapper;
    }

    @Override
    public PostResposta save(PostRequest postRequest) {

        PostModel post = poatMapper.toEntity(postRequest);

        PostModel postSaved = postRepository.save(post);

        return poatMapper.toDto(postSaved);
    }

    @Override
    public List<PostResposta> findAll() {
        return postRepository.findAll()
                .stream()
                .map(poatMapper::toDto)
                .toList();
    }

    @Override
    public PostResposta findById(UUID id) {
        return postRepository.findById(id)
                .map(poatMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
    }
}
