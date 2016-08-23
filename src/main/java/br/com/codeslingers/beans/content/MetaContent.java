package br.com.codeslingers.beans.content;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Model
@Entity
@Table(name="tb_meta_content")
public class MetaContent  implements Serializable{

	//private Integer idMeta;
	//private Integer idContent;
	private ImageBean img;
	private TextBean text;
	private Integer layoutPosition;
}
