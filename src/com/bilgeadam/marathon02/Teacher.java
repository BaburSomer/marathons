package com.bilgeadam.marathon02;

import java.time.LocalDate;

public class Teacher extends Employee {
	private static int ACT_NUMBER = 0;

	public Teacher(String firstName, String lastName, String gender, boolean married, LocalDate birthDate, double startSalary, LocalDate startDate) {
		super(firstName, lastName, gender, married, birthDate, startSalary, startDate);
	}

	public Teacher(String firstName, String middleName, String lastName, String gender, boolean married, LocalDate birthDate, double startSalary, LocalDate startDate) {
		super(firstName, middleName, lastName, gender, married, birthDate, startSalary, startDate);
	}
	
	@Override
	public String createIdNumber() {
		Teacher.ACT_NUMBER++;
		String numAsString = String.format("Ö-%03d", Teacher.ACT_NUMBER);
		return numAsString;
	}
}
