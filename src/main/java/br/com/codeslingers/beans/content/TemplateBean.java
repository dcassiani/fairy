package br.com.codeslingers.beans.content;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Model
@Entity
@Table(name="tb_template")
public class TemplateBean  implements Serializable{
	private static final long serialVersionUID = 6522127951742557701L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTemplate;
	private String templateType;
	private char isPublished; // Y N,
	private Integer qtImg;
	private Integer qtText;
	private String layoutInclude;


	
	public Integer getIdTemplate() {
		return idTemplate;
	}
	public void setIdTemplate(Integer idTemplate) {
		this.idTemplate = idTemplate;
	}
	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public char getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(char isPublished) {
		this.isPublished = isPublished;
	}
	public Integer getQtImg() {
		return qtImg;
	}
	public void setQtImg(Integer qtImg) {
		this.qtImg = qtImg;
	}
	public Integer getQtText() {
		return qtText;
	}
	public void setQtText(Integer qtText) {
		this.qtText = qtText;
	}
	public String getLayoutInclude() {
		return layoutInclude;
	}
	public void setLayoutInclude(String layoutInclude) {
		this.layoutInclude = layoutInclude;
	}

}
