package com.bilgeadam.marathon02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public abstract class Employee extends Person {
	private String    idNumber;
	private LocalDate startDate;		// must
	private LocalDate endDate;			// sonradan belirlenebilir
	private double    startSalary;		// must	
	private String[]  telephoneNumbers;	// optional

	public Employee(String firstName, String lastName, double startSalary, LocalDate startDate) {
		super(firstName, lastName);
		this.startDate   = startDate;
		this.startSalary = startSalary;
		this.endDate     = null;
		this.idNumber    = this.createIdNumber();
	}

	public abstract String createIdNumber();
	public abstract double getIncreaseRate();
	
	public double calculateCurrentSalary() {
		LocalDate today = LocalDate.now();
		long workedMonths = ChronoUnit.MONTHS.between(this.getStartDate(), today);
		long numOf6Months = workedMonths / 6;
		double salary = this.getStartSalary();
		for (int i= 1; i<numOf6Months; i++) {
			salary = salary * (1 + this.getIncreaseRate());
		}
		return salary;
	}


	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setStartDate(LocalDate start) {
		this.startDate = start;
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
