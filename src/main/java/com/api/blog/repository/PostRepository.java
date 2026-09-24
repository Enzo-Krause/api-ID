package com.api.blog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.model.PostModel;

public interface PostRepository extends JpaRepository<PostModel, UUID> {

}
