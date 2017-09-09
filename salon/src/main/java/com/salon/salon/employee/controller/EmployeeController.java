package com.salon.salon.employee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.salon.employee.domain.Employee;
import com.salon.salon.employee.domain.EmployeeRepository;

@RestController
public class EmployeeController {

	private final EmployeeRepository empRepository;

	@Autowired
	public EmployeeController(final EmployeeRepository empRepository) {
		this.empRepository = empRepository;

	}

	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public @ResponseBody Iterable<Employee> getAllEmployee() {
		return empRepository.findAll();

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("phone") Integer phone,
			@RequestParam("address") String address, @RequestParam("dob") long dob, @RequestParam("email") String email,
			@RequestParam("level") String level) {

		Employee e = new Employee();
		e.setFirstName(firstname);
		e.setLastName(lastname);
		e.setAddress(address);
		e.setDob(new Date(dob));
		e.setPhone(phone);
		e.setEmail(email);
		e.setLevel(level);
		return new ResponseEntity<Employee>(empRepository.save(e), HttpStatus.OK);

	}
}