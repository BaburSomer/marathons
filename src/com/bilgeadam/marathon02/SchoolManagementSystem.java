package com.bilgeadam.marathon02;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.bilgeadam.util.BAUtil;

public class SchoolManagementSystem {
	private static final int         EXIT = 99;
	private HashMap<Integer, String> menuItems;
	private List<Employee>           employees;

	public SchoolManagementSystem() {
		super();
		this.menuItems = new HashMap<>();
		this.employees = new LinkedList<>();
	}

	public static void main(String[] args) {
		BAUtil.header("Okul Yönetim Sistemi");
		SchoolManagementSystem school = new SchoolManagementSystem();
		school.menu();
		BAUtil.footer();
	}

	private void menu() {
		this.initMenuItems();

		boolean exit = false;
		while (!exit) {
			int sel = BAUtil.menu(menuItems);
			if (sel == SchoolManagementSystem.EXIT) {
				exit = BAUtil.wantToEnd("Gerçekten mi?", "Evet");
				continue;
			}
			try {
				this.processSelection(sel);
			}
			catch (UnknownPersonTypeException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	private void processSelection(int sel) throws UnknownPersonTypeException {
		switch (sel) {
			case 1:
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
//				this.employees.add((Employee) PersonFactory.create("çalışan"));
//				this.employees.add((Employee) PersonFactory.create("memur"));
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
				Teacher teacher = (Teacher) PersonFactory.create("öğretmen");
				teacher.setEndDate(LocalDate.of(2022, 5, 25));
				this.employees.add(teacher);
//				this.employees.add((Employee) PersonFactory.create("çalışan"));
//				this.employees.add((Employee) PersonFactory.create("memur"));
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
//				this.employees.add((Employee) PersonFactory.create("çalışan"));
//				this.employees.add((Employee) PersonFactory.create("memur"));
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
//				this.employees.add((Employee) PersonFactory.create("öğretmen"));
//				this.employees.add((Employee) PersonFactory.create("çalışan"));
//				this.employees.add((Employee) PersonFactory.create("memur"));
				teacher = (Teacher) PersonFactory.create("öğretmen");
				teacher.setStartDate(LocalDate.of(2019, 5, 25));
				this.employees.add(teacher);
				break;
			case 2:
				for (Employee employee : employees) {
					if (employee.getEndDate() == null)
						System.out.println(employee);
				}
				break;
			case 3:
				for (Employee employee : employees) {
					if (employee.getEndDate() != null)
						System.out.println(employee);
				}
				break;
			case 9:
				for (Employee employee : employees) {
					if (employee.getEndDate() == null)
						System.out.println(employee.getFirstName() + " " + employee.getLastName() + " : Başlangıç maaşı" + employee.getStartSalary()
											+ " Güncel Maaş: " + employee.calculateCurrentSalary());
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + sel);
		}
	}

	private void initMenuItems() {
		this.menuItems.put(1, "Yeni çalışan ekle");
		this.menuItems.put(2, "Çalışan listesi");
		this.menuItems.put(3, "Eski çalışanlar");
		this.menuItems.put(5, "Öğrenci atama");
		this.menuItems.put(4, "Yeni sınıf");
		this.menuItems.put(6, "Sınıf listesi");
		this.menuItems.put(7, "Öğrencinin sınıfları");
		this.menuItems.put(8, "Hediye Listesi");
		this.menuItems.put(9, "Maaş Listesi");
		this.menuItems.put(SchoolManagementSystem.EXIT, "Programı bitir");
	}
}
