package org.techlyric.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.techlyric.api.Menu;
import org.techlyric.dto.MenuItem;
import org.techlyric.repository.ShortListFilesRepository;


@Controller
@ControllerAdvice
public class FilesController{
	
	@PersistenceUnit(unitName="public_unit")
	EntityManagerFactory emf;
	
	public FilesController(){}
	private final static Logger LOGGER = Logger.getLogger(FilesController.class.getName());	
	
	@RequestMapping(value = "/static/files")
	public ModelAndView landingFiles(HttpServletRequest request, HttpServletResponse response, Principal principal, ModelMap model) throws IOException, ServletException {
				
		Enumeration enumeration = request.getParameterNames(); 
		while(enumeration.hasMoreElements()){
	        String parameterName = (String) enumeration.nextElement();
	        model.put(parameterName, request.getParameter(parameterName));
	    }
		JpaRepositoryFactory jpaRepository = new JpaRepositoryFactory(emf.createEntityManager());
		
		model.addAttribute("navList", new Menu( jpaRepository.getRepository(ShortListFilesRepository.class).findMenu() ));
		
		LOGGER.info("landing on static files.");
		ModelAndView view = new ModelAndView("services_files", model);
		return view;
	}	
	
}