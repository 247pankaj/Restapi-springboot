package com.pankaj.restapidemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String studentno;
	private String studentname;
	private int studyyear;
	private String email;
	private String address;
	private String phoneno;
	private String createdOn;
	private String createdBy;
	private String modifiedOn;
	private String modifiedBy;
	private boolean isDeleted;

}
