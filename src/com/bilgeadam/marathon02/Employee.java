package com.bilgeadam.marathon02;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Employee extends Person {
	private String    idNumber;
	private LocalDate startDate;
	private LocalDate endDate;
	private double    startSalary;
	private String[]  telephoneNumbers;

	public Employee(String firstName, String lastName, String gender, boolean married, LocalDate birthDate, double startSalary, LocalDate startDate) {
		super(firstName, lastName, gender, married, birthDate);
		this.startDate   = startDate;
		this.startSalary = startSalary;
		this.endDate     = null;
		this.idNumber    = this.createIdNumber();
	}

	public Employee(String firstName, String middleName, String lastName, String gender, boolean married, LocalDate birthDate, double startSalary, LocalDate startDate) {
		super(firstName, middleName, lastName, gender, married, birthDate);
		this.startDate   = startDate;
		this.startSalary = startSalary;
		this.endDate     = null;
		this.idNumber    = this.createIdNumber();
	}

	public abstract String createIdNumber();

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public double getStartSalary() {
		return this.startSalary;
	}

	public String[] getTelephoneNumbers() {
		return this.telephoneNumbers;
	}

	public void setHomeTelephone(String telephone) {
		this.telephoneNumbers[Commons.HOME] = telephone;
	}

	public void setGSMTelephone(String telephone) {
		this.telephoneNumbers[Commons.GSM] = telephone;
	}

	@Override
	public String toString() {
		return "Employee [idNumber=" + this.idNumber + ", startDate=" + this.startDate + ", endDate=" + this.endDate
				+ ", startSalary=" + this.startSalary + ", telephoneNumbers=" + Arrays.toString(this.telephoneNumbers)
				+ ", toString()=" + super.toString() + "]";
	}

}
