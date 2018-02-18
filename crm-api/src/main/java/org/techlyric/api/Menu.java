package org.techlyric.api;

import java.util.LinkedHashMap;
import java.util.List;

import org.techlyric.dto.MenuItem;

public class Menu extends LinkedHashMap<String, MenuItem> {
	private static final long serialVersionUID = -8134131042904406954L;

	public Menu(List<MenuItem> list) {
		for ( MenuItem menuItem : list ) { 
			this.put( menuItem.getLabel(), menuItem );
		}
	}
}
