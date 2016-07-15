package br.com.codeslingers.beans;

import java.io.Serializable;
import java.util.List;

public class MenuLink  implements Serializable{
	private static final long serialVersionUID = -2497181922697208331L;

	private String label;
	private String val;
	private List<MenuLink> submenu; 
	private String icon;
	
	
	public MenuLink(String label, String val, String icon) {
		super();
		this.label = label;
		this.val = val;
		this.icon = icon;
	}
	
	
	public MenuLink(String label, String val, String icon, List<MenuLink> submenu) {
		super();
		this.label = label;
		this.val = val;
		this.submenu = submenu;
		this.icon = icon;
	}



	public MenuLink(String label, String val) {
		super();
		this.label = label;
		this.val = val;
	}

	public MenuLink(String label, List<MenuLink> submenu) {
		super();
		this.label = label;
		this.submenu = submenu;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public List<MenuLink> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<MenuLink> submenu) {
		this.submenu = submenu;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


}
