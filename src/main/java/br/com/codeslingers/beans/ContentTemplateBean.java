package br.com.codeslingers.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.codeslingers.beans.content.TemplateBean;

@Model
@Entity
@Table(name="tb_content")
public class ContentTemplateBean  implements Serializable{
	private static final long serialVersionUID = -3843913745588479802L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContent;
	
	@Column
	private char isPublished;
	
	@Column
	private String owner;
	
	@Column
	private String title;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idTemplate")
	private TemplateBean template;

	public Integer getIdContent() {
		return idContent;
	}

	public void setIdContent(Integer idContent) {
		this.idContent = idContent;
	}

	public char getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(char isPublished) {
		this.isPublished = isPublished;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TemplateBean getTemplate() {
		return template;
	}

	public void setTemplate(TemplateBean template) {
		this.template = template;
	}

}
