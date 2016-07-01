package br.com.launch.bean;

import java.io.Serializable;

public class PeopleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991981568811127204L;

	private String name;
	private Integer age;
	private String country;
	private String picturePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
}
