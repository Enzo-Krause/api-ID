package com.api.blog.dto.response;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.model.comentarioModel;

public interface ComentarioRepository extends JpaRepository<comentarioModel,UUID >{

}
