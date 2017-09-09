package com.salon.salon.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.salon.sales.Sales;
import com.salon.salon.sales.SalesRepository;

@RestController
public class SalesController {

	@Autowired
	public SalesRepository salesRepository;

	@RequestMapping(value = "/viewSales", method = RequestMethod.GET)
	public @ResponseBody Iterable<Sales> getAllSales() {
		return salesRepository.findAll();

	}

	@RequestMapping(value = "/addSales", method = RequestMethod.POST)
	public ResponseEntity<Sales> soldUpdate(@RequestParam("item") String item, @RequestParam("quantity") int quantity,
			@RequestParam("price") int price, @RequestParam("total") int total,
			@RequestParam("paymenttype") String paymenttype) {
		Sales s = new Sales();
		s.setItem(item);
		s.setQuantity(quantity);
		s.setPrice(price);
		s.setTotal(total);
		s.setPaymenttype(paymenttype);
		return new ResponseEntity<Sales>(salesRepository.save(s), HttpStatus.OK);
	}

}
