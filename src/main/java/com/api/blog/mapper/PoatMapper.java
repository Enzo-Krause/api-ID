package com.api.blog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.request.comentarioresponseDto;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.model.PostModel;
import com.api.blog.model.comentarioModel;

@Component
public class PoatMapper {

    private final comentarioMapper comentarioMapper;

    public PoatMapper(comentarioMapper comentarioMapper) {
        this.comentarioMapper = comentarioMapper;
    }

    public PostModel toEntity(PostRequest dto) {
        if (dto == null) {
            return null;
        }

        return new PostModel(
            dto.autor(),
            dto.titulo(),
            dto.texto()
        );
    }

    public PostResposta toDto(PostModel entity) {
        if (entity == null) {
            return null;
        }

        List<comentarioresponseDto> comentariosDto = new ArrayList<>();

        if (entity.getComentarios() != null) {
            for (comentarioModel comentario : entity.getComentarios()) {
                comentarioresponseDto dto = comentarioMapper.toDto(comentario);
                comentariosDto.add(dto);
            }
        }

        return new PostResposta(
            entity.getId(),
            entity.getAutor(),
            entity.getData(),
            entity.getTitulo(),
            entity.getTexto(),
            comentariosDto
        );
    }
}