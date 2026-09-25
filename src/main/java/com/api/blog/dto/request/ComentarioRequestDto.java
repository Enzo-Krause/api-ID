package com.api.blog.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ComentarioRequestDto(@NotBlank(message = "o comentario nao pode ser vazio") String comentario) {

}