package com.salon.salon.configure.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.salon.salon.configure.domain.Configure;
import com.salon.salon.configure.domain.ListOfValue;

public interface ConfigurationWritePlatformService {

	ResponseEntity<Configure> createConfiguration(String code, List<ListOfValue> value);

}
