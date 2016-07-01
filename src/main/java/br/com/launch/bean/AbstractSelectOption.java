package br.com.launch.bean;

import java.io.Serializable;

public class AbstractSelectOption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1700897074667564231L;
	private String label;
	private String value;
	public AbstractSelectOption(String label, String value) {
		super();
		this.label = label;
		this.value = value;
		this.selected = false;
	}
	public AbstractSelectOption(String value) {
		super();
		this.label = value;
		this.value = value;
		this.selected = false;
	}
	private boolean selected;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
