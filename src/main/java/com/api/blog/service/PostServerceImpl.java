package com.api.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;
import com.api.blog.PostService;
import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.mapper.PoatMapper;
import com.api.blog.repository.PostRepository;
import com.api.blog_api.model.PostModel;

public class PostServerceImpl implements PostService {
	private final PostRepository postRepository;
	private final PoatMapper PostMapper;
	public PostServerceImpl(PostRepository postRepository, PoatMapper PoatMapper) {
		this.postRepository = postRepository;
		this.PostMapper = PoatMapper;
	}
	@Override
	public List<PostResposta> findall() {
		List<PostModel> posts = postRepository.findAll();
		List<PostResposta> dtos = new ArrayList<>();
		for (PostModel post : posts) dtos.add(PostMapper.toDto(post));
		return dtos;
	}
	@Override
	@Transactional(readOnly = true)
	public PostResposta findByld(UUID id) {
		Optional<PostModel> optionalPost = postRepository.findById(id);
		if (optionalPost.isEmpty()) throw new RuntimeException("Post nao encontrado com o ID" + id);
		PostModel post = optionalPost.get();
		return PostMapper.toDto(post);
	}
	@Override
	public PostResposta createPoat(PostRequest dto) {
		PostModel post = PostMapper.toEntity(dto);
		PostModel saved = postRepository.save(post);
		return PostMapper.toDto(saved);
	}
}
