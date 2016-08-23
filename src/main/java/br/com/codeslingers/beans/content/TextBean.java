package br.com.codeslingers.beans.content;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Model
@Entity
@Table(name="tb_text")
public class TextBean  implements Serializable{

	//private Integer idText;
	private String title;
	private String description;
	private String text;
	
}
