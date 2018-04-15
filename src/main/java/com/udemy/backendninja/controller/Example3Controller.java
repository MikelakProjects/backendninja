package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	// Utilizamos el logging de Apache Commons
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEV = "result";
	
	/**
	 *  Forma 1 de redirección: este "mapping" gestionará las peticiones que se hagan a "/example3/"
	 *  Ojo, esta forma sólo funciona con "/example3/". Sin la barra final falla. 
	 * @return String
	 */
	// @GetMapping("/")
	public String redirect1() {
		// El framework se encarga de interpretar este String
		return "redirect:/example3/showform";
	}
	
	/**
	 * Otra forma de hacer la redirección
	 * Tampoco funciona sin la barra final
	 * @return RedirectView
	 */
	@GetMapping("/")
	public RedirectView redirect2() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("Method: 'showForm'  Params: '" + model + "'");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		LOGGER.info("Method: 'addPerson'  Params: '" + person + "'");
		ModelAndView mav = new ModelAndView(RESULT_VIEV);
		mav.addObject("person", person);
		// DEBUG sólo se mostrará si hemos arrancado en modo DEBUG
		LOGGER.debug("DEBUGGING");
		return mav;
	}
}
