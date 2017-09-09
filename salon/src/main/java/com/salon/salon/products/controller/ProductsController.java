package com.salon.salon.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.salon.products.Products;
import com.salon.salon.products.ProductsRepository;

@RestController
public class ProductsController {

	private final ProductsRepository productsRepository;

	@Autowired
	public ProductsController(final ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
	public @ResponseBody Iterable<Products> getAllProducts() {
		return productsRepository.findAll();

	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<Products> addProducts(@RequestParam("type") String type,
			@RequestParam("quantity") Integer quantity, @RequestParam("price") Integer price,
			@RequestParam("description") String description) {

		Products pro = new Products();
		pro.setType(type);
		pro.setQuantity(quantity);
		pro.setPrice(price);
		pro.setDescription(description);

		return new ResponseEntity<Products>(productsRepository.save(pro), HttpStatus.OK);

	}

}
