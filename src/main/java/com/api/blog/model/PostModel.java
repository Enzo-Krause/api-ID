package com.api.blog.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_teble")
public class PostModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, length = 70)
	private String autor;

	@Column(nullable = false)
	private LocalDate data;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Lob
	@Column(columnDefinition = "TEXT", nullable = false)
	private String texto;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<comentarioModel> comentarios = new ArrayList<>();

	public PostModel() {
	}

	public PostModel(String autor, String titulo, String texto) {
		this.autor = autor;
		this.data = LocalDate.now();
		this.texto = texto;
		this.titulo = titulo;
	}

	public void adicionarComentario(comentarioModel comentario) {
		comentarios.add(comentario);
		comentario.setPost(this);

	}
	
	public void removerComentario(comentarioModel comentario) {
	
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<comentarioModel> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<comentarioModel> comentarios) {
		this.comentarios = comentarios;
	}
}