package com.api.blog.mapper;

import org.springframework.stereotype.Component;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.request.comentarioresponseDto;
import com.api.blog.model.PostModel;
import com.api.blog.model.comentarioModel;

@Component
public class comentarioMapper {

	
	public comentarioModel toEntity(ComentarioRequestDto dto,PostModel entity) {
		if(dto == null) {
			return null;
		}
		return new comentarioModel(dto.comentario().toString(),entity);
	}
	
	public comentarioresponseDto toDto(comentarioModel entity){
		if (entity == null) {
			return null;
		}
		return new comentarioresponseDto(entity.getId(),entity.getData(),entity.getComentario());
	}
}