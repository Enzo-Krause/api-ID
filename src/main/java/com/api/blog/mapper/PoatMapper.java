package com.api.blog.mapper;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;
import com.api.blog.model.PostModel;

@Component
public class PoatMapper {

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

        return new PostResposta(
                entity.getId(),
                entity.getAutor(),
                entity.getData(),
                entity.getTitulo(),
                entity.getTexto()
        );
    }
}
