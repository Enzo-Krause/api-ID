package com.api.blog.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record comentarioresponseDto(UUID id, LocalDate data,String comentario) {

}