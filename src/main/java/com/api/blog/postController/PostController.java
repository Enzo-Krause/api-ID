package com.api.blog.postController;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.request.comentarioresponseDto;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {

	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<List<PostResposta>> getAllPost() {
		return ResponseEntity.ok(postService.findAll());
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostResposta> getPostById(@PathVariable UUID id) {
		return ResponseEntity.ok(postService.findById(id));
	}
	
	@PostMapping("/newpost")
	public ResponseEntity<PostResposta> createPost(@RequestBody @Valid PostRequest dto) {
		
		PostResposta created = postService.save(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PostMapping("/comentarios/{postId}")
	public ResponseEntity<comentarioresponseDto> createComentario(@PathVariable UUID postId,@RequestBody @Valid ComentarioRequestDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.addComentario(postId, dto));
	}
}