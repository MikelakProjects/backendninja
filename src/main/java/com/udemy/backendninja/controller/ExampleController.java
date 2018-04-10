package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	/**
	 * Constante para la vista. Lo normal es tener una clase con las constantes de 
	 * todas las vistas, para que estén centralizadas, y además, si hay que modificar
	 * algún nombre de vista, sólo haya que hacerlo en un único lugar. 
	 */
	public static final String EXAMPLE_VIEW = "example";

	/**
	 * La anotación @GetMapping es hija de @RequestMapping, pero lleva ya implícito
	 * el método GET de petición.
	 * 
	 * Esta forma de devolver una vista (con un String), se utiliza cuando se van a hacer
	 * redirecciones, o cuando la vista utiliza pocas variables. 
	 * 
	 * Para manejar variables en la vista, nuestro método recibirá un objeto Model. Si estuviera
	 * vacío (si no enviamos nada), lo creará automáticamente. 
	 * @return {@link String}
	 */
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	/**
	 * Esta forma de devolver la vista (con un ModelAndView), se utiliza cuando se quiere
	 * devolver mayor cantidad de datos.
	 * @return {@link ModelAndView}
	 */
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Gathu", 15));
		people.add(new Person("Rovik", 1));
		people.add(new Person("John", 98));
		people.add(new Person("Arcangelo", 21));
		people.add(new Person("Zorrupio", 740));
		return people;
	}
}