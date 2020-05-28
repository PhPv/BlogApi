package com.jspring1.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserModel {

	@Size(min = 2, max = 30, message = "name")
	private String name;

	@Size(min = 6, max = 15, message = "password")
	private String password;






}
