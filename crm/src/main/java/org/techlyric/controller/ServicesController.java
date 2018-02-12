package org.techlyric.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.techlyric.api.Menu;

@Controller
@ControllerAdvice
public class ServicesController{
	
	@PersistenceUnit(unitName="public_unit")
	EntityManagerFactory emf;
	
	public ServicesController(){}
	private final static Logger LOGGER = Logger.getLogger(ServicesController.class.getName());
	
	@RequestMapping(value="/login.html") 
	ModelAndView secure_services(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/loginfail")
	public RedirectView security_check_failed(ModelMap model) {
		return new RedirectView("login.html");
	}

	@RequestMapping(value = "/static/services.html")
	public ModelAndView landing(HttpServletRequest request, HttpServletResponse response, Principal principal, ModelMap model) throws IOException, ServletException {
				
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
	        String parameterName = (String) enumeration.nextElement();
	        model.put(parameterName, request.getParameter(parameterName));
	    }
		EntityManager em = emf.createEntityManager();
		model.addAttribute("navList", new Menu(em) );
		
		LOGGER.info("landing on static service.");
		ModelAndView view = new ModelAndView("services", model);
		return view;
	}	
	
	@RequestMapping(value = "/static/files")
	public ModelAndView landingFiles(HttpServletRequest request, HttpServletResponse response, Principal principal, ModelMap model) throws IOException, ServletException {
				
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
	        String parameterName = (String) enumeration.nextElement();
	        model.put(parameterName, request.getParameter(parameterName));
	    }
		EntityManager em = emf.createEntityManager();
		model.addAttribute("navList", new Menu(em) );
		
		LOGGER.info("landing on static files.");
		ModelAndView view = new ModelAndView("services_files", model);
		return view;
	}	
	
	@RequestMapping(value = "/signout")
	public RedirectView logoff(HttpSession session, SessionStatus sessionStatus) {
		if( session != null )
		{
			sessionStatus.setComplete();
			session.getLastAccessedTime();
			session.invalidate();
		}
		return new RedirectView("/static/index.html", true);
	}
}