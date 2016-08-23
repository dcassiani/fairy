package br.com.codeslingers.beans.content;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Model
@Entity
@Table(name="tb_img")
public class ImageBean  implements Serializable{

	//private Integer idImg;
	private String src;
	private String alt;
	private String title;
}
