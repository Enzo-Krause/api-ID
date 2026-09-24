package com.api.blog.utils;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.service.PostService;

import jakarta.annotation.PostConstruct;

@Component
public class DataUtil {

    private final PostService postService;

    public DataUtil(PostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void savePosts() {

        PostRequest post1 = new PostRequest(
                "neymar",
                "Docker",
                "Docker é muito bom"
        );

        PostRequest post2 = new PostRequest(
                "Goku",
                "API REST",
                "API REST com Spring Boot"
        );

        PostResposta postSaved = postService.save(post1);
        System.out.println(postSaved.id());

        PostResposta postSaved2 = postService.save(post2);
        System.out.println(postSaved2.id());
    }
}
