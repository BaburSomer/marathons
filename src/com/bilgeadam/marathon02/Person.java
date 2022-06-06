package com.bilgeadam.marathon02;

import java.time.LocalDate;

public abstract class Person {
	private String    firstName;
	private String    middleName;
	private String    lastName;
	private String    gender;
	private boolean   married;
	private LocalDate birthDate;
	
	public Person(String firstName, String lastName, String gender, boolean married, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.gender    = gender;
		this.married   = married;
		this.birthDate = birthDate;
	}

	public Person(String firstName, String middleName, String lastName, String gender, boolean married, LocalDate birthDate) {
		this(firstName, lastName, gender, married, birthDate);
		this.middleName = middleName;
	}
	
	@Override
	public String toString() {
		return "Person [Name=" + this.getFullName() + ", gender=" + this.gender
				+ ", married=" + this.married + ", birthDate=" + this.birthDate + "]";
	}

	private String getFullName() {
		return this.middleName == null ? this.firstName + " " + this.lastName : 
										 this.firstName + " " + this.middleName + " " + this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}
	
	public String getGender() {
		return this.gender;
	}

	public boolean isMarried() {
		return this.married;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}
}
