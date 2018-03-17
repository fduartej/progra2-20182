package edu.usmp.petshop.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


public class Person implements Serializable{

	
	private Integer id;
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	@NotNull
	@Size(min=2, max=50)
	private String address;
	@NotNull
	@Size(min=2, max=20)
	private String city;
	@NotNull
	@Min(9)
	private Integer phone;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
