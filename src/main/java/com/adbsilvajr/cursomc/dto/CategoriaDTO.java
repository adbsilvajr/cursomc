package com.adbsilvajr.cursomc.dto;

import java.io.Serializable;

import com.adbsilvajr.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer Id;
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
