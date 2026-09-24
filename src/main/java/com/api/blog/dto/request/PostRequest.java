package com.api.blog.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequest(

		@NotBlank(message = "o autor é obrigatorio") @Size(max = 70, message = "o autor deve ter no maximo 70 letras") String autor,

		@NotBlank(message = "o tiulo é obrigatorio") @Size(max = 100, message = "o titulo deve ter no maximo 100 letras") String titulo,

		@NotBlank(message = "o texto é obrigatorio") String texto) {

}
