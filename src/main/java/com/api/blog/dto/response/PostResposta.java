package com.api.blog.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.api.blog.dto.request.comentarioresponseDto;

public record PostResposta(UUID id, String autor, LocalDate data, String titulo, String texto ,List<comentarioresponseDto> comentario) {}