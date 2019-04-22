package com.adbsilvajr.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.adbsilvajr.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer Id;

	@NotEmpty(message = "Campo Vazio")
	@Length(min = 5, max = 80, message = "min 5 e max 80!")
	private String nome;

	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria cat) {
		this.Id = cat.getId();
		this.nome = cat.getNome();
	}

	public Integer getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
