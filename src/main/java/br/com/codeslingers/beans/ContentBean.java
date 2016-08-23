package br.com.codeslingers.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.codeslingers.beans.content.MetaContent;
import br.com.codeslingers.beans.content.TemplateBean;

@Model
@Entity
@Table(name="tb_content")
public class ContentBean  implements Serializable{

	private Integer idContent;
	private char isPublished;
	private String owner;
	private String title;

	private TemplateBean template;
	
	private List<MetaContent> listMetaContent;
}
