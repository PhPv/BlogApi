package com.jspring1.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Setter
@Getter
@ToString
@Document(collection = "sequence")
public class Sequence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private long seq;

}
