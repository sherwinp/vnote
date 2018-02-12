package org.techlyric.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Embeddable
public class LinkItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772047830838542655L;

	protected String label;
	protected String uri;


	protected LinkItem() {}
	
	public LinkItem(String label, String uriString){
		this.label=label;
		this.uri = uriString;
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
}
