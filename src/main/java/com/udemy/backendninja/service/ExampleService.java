package com.udemy.backendninja.service;

import java.util.List;
import com.udemy.backendninja.model.Person;

public interface ExampleService {

	// En el curso pone "abstract" y "public" pero creo que no es necesario, pues un método definido en una interfaz ya incluye esos
	// modificadores por defecto
	List<Person> getListPeople();
}
