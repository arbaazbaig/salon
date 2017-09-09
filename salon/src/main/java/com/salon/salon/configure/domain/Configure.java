package com.salon.salon.configure.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salon_code")
public class Configure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code", unique = true)
	private String code;
	 
	@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
	private List<ListOfValue> listofvalues;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ListOfValue> getListofvalues() {
		return listofvalues;
	}

	public void setListofvalues(List<ListOfValue> listofvalues) {
		this.listofvalues = listofvalues;
	}
	
	

	
}

	
	
	
