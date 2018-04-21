package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Gathu", 15));
		people.add(new Person("Rovik", 1));
		people.add(new Person("John", 98));
		people.add(new Person("Arcangelo", 21));
		people.add(new Person("Zorrupio", 740));
		
		LOGGER.info("Hello from Service");
		
		return people;
	}
}
