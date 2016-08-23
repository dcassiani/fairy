package br.com.codeslingers.beans.content;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Model
@Entity
@Table(name="tb_template")
public class TemplateBean  implements Serializable{
	
	private Integer idTemplate;
	private String templateType;
	private char isPublished; // Y N,
	private Integer qtImg;
	private Integer qtText;
	private String layoutInclude;
}
