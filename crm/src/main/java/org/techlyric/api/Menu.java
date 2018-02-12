package org.techlyric.api;

import java.util.LinkedHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.techlyric.controller.ApplicationContextProvider;
import org.techlyric.repository.ShortListRepository;

public class Menu extends LinkedHashMap {

	protected Menu() {}
	
	public Menu(EntityManager em) {
		
		ShortListRepository shortListRepository = new JpaRepositoryFactory(em).getRepository(ShortListRepository.class);

		for (MenuItem menuItem : shortListRepository.findMenu()) {
			this.put(menuItem.getLabel(), menuItem);
		}
	}
}
