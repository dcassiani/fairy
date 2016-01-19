package br.com.codeslingers.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class PeopleBean implements Serializable{
	private static final long serialVersionUID = 35128508375125660L;

	@Id
	@Column(name="idPerson")
	@GeneratedValue(strategy=GenerationType.AUTO)
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
