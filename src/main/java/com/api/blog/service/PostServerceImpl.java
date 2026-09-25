package com.api.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.request.comentarioresponseDto;
import com.api.blog.dto.response.ComentarioRepository;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.mapper.PoatMapper;
import com.api.blog.mapper.comentarioMapper;
import com.api.blog.model.PostModel;
import com.api.blog.model.comentarioModel;
import com.api.blog.repository.PostRepository;

@Service
public class PostServerceImpl implements PostService {

    private final PostRepository postRepository;
    private final PoatMapper poatMapper;
    private final comentarioMapper comentarioMapper;
    private final ComentarioRepository ComentarioRepository;

    public PostServerceImpl(
            PostRepository postRepository,
            PoatMapper poatMapper,
            ComentarioRepository ComentarioRepository,
            comentarioMapper comentarioMapper) {

        this.postRepository = postRepository;
        this.poatMapper = poatMapper;
        this.ComentarioRepository = ComentarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    @Override
    public PostResposta save(PostRequest postRequest) {

        PostModel post = poatMapper.toEntity(postRequest);

        PostModel postSaved = postRepository.save(post);

        return poatMapper.toDto(postSaved);
    }

    @Override
    public PostResposta createPost(PostRequest dto) {
        return save(dto);
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

    @Override
    public comentarioresponseDto addComentario(
            UUID postId,
            ComentarioRequestDto dto) {

        Optional<PostModel> optionalPost =
                postRepository.findById(postId);

        PostModel post = optionalPost.get();

        comentarioModel comentario =
                new comentarioModel(dto.comentario(), post);

        post.adicionarComentario(comentario);

        comentarioModel saved =
                ComentarioRepository.save(comentario);

        return comentarioMapper.toDto(saved);
    }
}