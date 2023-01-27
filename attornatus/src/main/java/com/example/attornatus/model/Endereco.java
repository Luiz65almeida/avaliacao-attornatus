package com.example.attornatus.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "TB_ENDERECOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Endereco  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	
	private Integer cep;
	
	private Integer numero;
	
	private String cidade;

	private Boolean isPrincipal;
	


	
	@ManyToOne
	
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa; 

	public Endereco () {
		
	}
	
	public Endereco(String logradouro, Integer cep, Integer numero, String cidade, Boolean isPrincipal, Pessoa pessoa) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.isPrincipal = isPrincipal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Boolean getIsPrincipal() {
		return isPrincipal;
	}


	public void setIsprincipal(Boolean isprincipal) {
		this.isPrincipal = isprincipal;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}





	
}