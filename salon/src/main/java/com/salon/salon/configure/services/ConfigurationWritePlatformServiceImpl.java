package com.salon.salon.configure.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.salon.salon.configure.domain.Configure;
import com.salon.salon.configure.domain.ConfigureRepository;
import com.salon.salon.configure.domain.ListOfValue;

@Service
public class ConfigurationWritePlatformServiceImpl implements ConfigurationWritePlatformService {

	private final ConfigureRepository configureRepository;
	
	@Autowired
	public ConfigurationWritePlatformServiceImpl(final ConfigureRepository configureRepository) {
		this.configureRepository = configureRepository;
	}
	
	@Override
	public ResponseEntity<Configure> createConfiguration(String code, List<ListOfValue> value) {
		Configure c = Configure.createNew(code, value);
		configureRepository.save(c);
		return new ResponseEntity<Configure>(c, HttpStatus.OK);
	}
	
}
