package org.techlyric.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;

public class MenuItem {
	/**
	 * 
	 */
	String label = "";
	String uri = "";
	BigInteger itemCount = BigInteger.ZERO;
	protected MenuItem() {}
	
	public MenuItem(String label, String uri) {
		super();
		this.label = label;
		this.uri = uri;
	}

	public MenuItem(String label, BigInteger itemCount) {
		super();
		this.label = label;
		this.itemCount = itemCount;
	}

	public MenuItem(Object label, Object itemCount) {
		super();
		this.label = (String)label;
		this.itemCount = BigInteger.valueOf((Long) itemCount);
		
		this.uri = this.label.toLowerCase();
	}

	public MenuItem(Object[] items) {
		super();
		this.label = (String) items[0];
		this.itemCount = BigInteger.valueOf((Long) items[1]);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public BigInteger getItemCount() {
		return itemCount;
	}

	public void setItemCount(BigInteger subItemCount) {
		this.itemCount = subItemCount;
	}
	@Override
	public String toString() {
		
		return getLabel();
	}
}
