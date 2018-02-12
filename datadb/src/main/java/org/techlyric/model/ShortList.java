package org.techlyric.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShortList implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	protected Long id;
	
	protected String slabel;

	@ElementCollection
	public List<LinkItem> linkItems=new ArrayList<LinkItem>();
	
	public ShortList() {}
	
	public ShortList(String lbl, Long id){
		this.id = id;
		this.slabel=lbl;
	}
	public List<LinkItem> getLinkItems() {
		return linkItems;
	}

	public void setLinkItems(List<LinkItem> itemList) {
		this.linkItems = itemList;
	}

	public void add(LinkItem item) {
		linkItems.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getSlabel() {
		return slabel;
	}
	public void setSlabel(String slabel) {
		this.slabel = slabel;
	}

}