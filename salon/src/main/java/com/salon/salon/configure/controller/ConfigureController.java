package com.salon.salon.configure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.salon.configure.data.ConfigurationData;
import com.salon.salon.configure.domain.Configure;
import com.salon.salon.configure.domain.ConfigureRepository;
import com.salon.salon.configure.services.ConfigurationWritePlatformService;

@RestController
public class ConfigureController {

	private final ConfigureRepository configureRepository;
	private final ConfigurationWritePlatformService configurationWritePlatformService;
	
	@Autowired
	public ConfigureController(final ConfigureRepository configureRepository,
			final ConfigurationWritePlatformService configurationWritePlatformService) {
		this.configureRepository = configureRepository;
		this.configurationWritePlatformService = configurationWritePlatformService;
	}

	@GetMapping(path = "/viewConfigure")
	public @ResponseBody Iterable<Configure> getAllUser() {

		return configureRepository.findAll();
	}

	@RequestMapping(value = "/addConfigure", method = RequestMethod.POST)
	public ResponseEntity<Configure> configured(@RequestBody ConfigurationData data) {
		return configurationWritePlatformService.createConfiguration(data.getCode(), data.getValue());
	}

}
