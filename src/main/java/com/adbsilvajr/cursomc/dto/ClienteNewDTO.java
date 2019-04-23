package com.adbsilvajr.cursomc.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	private Integer cidadeId;

	private String telefone1;
	private String telefone2;
	private String telefone3;

	public ClienteNewDTO(String nome, String email, String cpfOuCnpj, Integer tipo, String logradouro, String numero,
			String complemento, String bairro, String cep, Integer cidadeId) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeId = cidadeId;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

}
