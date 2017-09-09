package com.salon.salon.configure.data;

import java.util.List;

import com.salon.salon.configure.domain.ListOfValue;

public class ConfigurationData {
	private String code;
	private List<ListOfValue> value;
	
	public ConfigurationData() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List getValue() {
		return value;
	}

	public void setValue(List value) {
		this.value = value;
	}
}
