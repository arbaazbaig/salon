package com.salon.salon.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.salon.expenses.domain.Expenses;
import com.salon.salon.expenses.domain.ExpensesRepository;

@RestController
public class ExpensesController {

	@Autowired
	public ExpensesRepository expensesRepository;

	@RequestMapping(value = "/viewExpenses", method = RequestMethod.GET)
	public @ResponseBody Iterable<Expenses> getAllExpenses() {
		return expensesRepository.findAll();

	}

	@RequestMapping(value = "/addExpenses", method = RequestMethod.POST)
	public ResponseEntity<Expenses> addExpenses(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("amount") String amount) {
		Expenses exp = new Expenses();
		exp.setTitle(title);
		exp.setDescription(description);
		exp.setAmount(amount);

		return new ResponseEntity<Expenses>(expensesRepository.save(exp), HttpStatus.OK);

	}
}
