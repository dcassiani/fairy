package br.com.codeslingers.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.codeslingers.beans.enums.MemoryTypeEnum;

//@Entity
//@Table(name="tb_memory")
public class MemoryBean implements Serializable{
	private static final long serialVersionUID = 35128508375125660L;

//	@Id
//	@Column(name="idMemory")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMemory;
	
	private String title;
	
	private String description;
	
	private List<String> memoryURLPhotoList; //TODO: como obter do Instagram e Facebook?
	
	private MemoryTypeEnum memoryType;

	
	
	public Integer getIdMemory() {
		return idMemory;
	}

	public void setIdMemory(Integer idMemory) {
		this.idMemory = idMemory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getMemoryURLPhotoList() {
		return memoryURLPhotoList;
	}

	public void setMemoryURLPhotoList(List<String> memoryURLPhotoList) {
		this.memoryURLPhotoList = memoryURLPhotoList;
	}

	public MemoryTypeEnum getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(MemoryTypeEnum memoryType) {
		this.memoryType = memoryType;
	}
		
}
