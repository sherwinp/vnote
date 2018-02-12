package org.techlyric.test;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.techlyric.model.LinkItem;
import org.techlyric.model.ShortList;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring-context.xml"})
public class ShortTest{
	@Autowired 
	@PersistenceUnit(unitName = "public_unit")
	EntityManagerFactory emf;
	
	public void storeTest1() {
		

	}
	@Test
	public void storeTest2() {
		
		EntityManager em = emf.createEntityManager();
				
		em.getTransaction().begin();
		em.merge(new ShortList("Files",10L));
		em.merge(new ShortList("Users",20L));
		em.merge(new ShortList("Clients",30L));
		em.merge(new ShortList("About",40L));

		em.getTransaction().commit();
	}
	@Test
	public void storeTest3() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		ShortList shortList = em.find(ShortList.class, 20L);
		if(shortList!=null)
		shortList.linkItems.forEach(item->{
			if("Joe".equals(item.getLabel())){ 
				em.clear();
				return; 
			}
		});
		LinkItem item = new LinkItem("Joe", "joe");
		shortList.linkItems.add(item);
		item = new LinkItem("Mary", "mary");
		shortList.linkItems.add(item);
		em.merge(shortList);
		em.getTransaction().commit();
	}
	@Test
	public void storeTest4() {
		EntityManager em = emf.createEntityManager();
		TRepository shortListRepository = new JpaRepositoryFactory(em).getRepository(TRepository.class);		
		shortListRepository.menu();
		
	}
	interface TRepository extends CrudRepository<ShortList, Long>{
		@Query("SELECT new HashMap( shrt.slabel, count(shrt.id) as itemCount ) \n"
				+"FROM ShortList shrt \n" 
				+"LEFT OUTER JOIN shrt.linkItems itm \n" 
				+"GROUP BY shrt.id")
		public List<Map<String, Long>> menu();
	}
}