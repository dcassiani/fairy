package br.com.codeslingers.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="tb_pessoa")
public class PeopleBean implements Serializable{
	private static final long serialVersionUID = 35128508375125660L;

	@Id
	@GeneratedValue
	private Integer idPessoa;
	
	@Column(nullable = false)
	private String nome;
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
