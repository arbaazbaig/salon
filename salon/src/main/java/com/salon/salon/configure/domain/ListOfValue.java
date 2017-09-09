package com.salon.salon.configure.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "salon_values")
public class ListOfValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String value;
    @ManyToOne
	@JoinColumn(name = "configure_id")
	private Configure configure;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Configure getConfigure() {
		return configure;
	}
	public void setConfigure(Configure configure) {
		this.configure = configure;
	}

	
}