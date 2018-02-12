package org.techlyric.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.techlyric.model.ShortList;
import org.techlyric.api.MenuItem;

@RepositoryDefinition(domainClass = ShortList.class, idClass = Long.class)
public interface ShortListRepository {
	@Query("SELECT new org.techlyric.api.MenuItem( shrt.slabel, count(shrt.id) as itemCount )\n"
			+"FROM ShortList shrt \n" 
			+"LEFT OUTER JOIN shrt.linkItems itm \n" 
			+"GROUP BY shrt.id")
	public List<MenuItem> findMenu();
}
