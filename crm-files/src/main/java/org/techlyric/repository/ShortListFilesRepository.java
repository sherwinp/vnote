package org.techlyric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.techlyric.model.ShortList;
import org.techlyric.dto.MenuItem;

@RepositoryDefinition(domainClass = ShortList.class, idClass = Long.class)
public interface ShortListFilesRepository {
	@Query("SELECT new org.techlyric.dto.MenuItem( shrt.slabel, count(shrt.id) as itemCount )\n"
			+"FROM ShortList shrt \n" 
			+"LEFT OUTER JOIN shrt.linkItems itm \n" 
			+"GROUP BY shrt.id")
	public List<MenuItem> findMenu();
}
