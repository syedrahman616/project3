package com.plumber.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "plumber")
public class Plumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "plumber_id", nullable = false)
	private long plumberId;
	@Column(name = "skill_id", nullable = false)
	private long skillId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "postcode", nullable = false)
	private String postCode;
	@Column(name = "mobile", nullable = false)
	private String mobile;
	@Column(name = "availability", nullable = false)
	private boolean availability;
	@Column(name = "status", nullable = false)
	private boolean status;
	@Transient
	private String flag;
	@Transient
	private double skill;
	@Transient
	private String userEmail;
}
