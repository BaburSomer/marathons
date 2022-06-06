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
			this.processSelection(sel);
		}
	}

	private void processSelection(int sel) {
		switch (sel) {
			case 1:
				Teacher t1 = new Teacher("babür", "somer", "male", true, LocalDate.of(1964, 11, 10), 12000,
						LocalDate.of(2021, 6, 15));
				this.employees.add(t1);
				this.employees.add(new Teacher("ayşe", "fatma", "4950", "female", false, LocalDate.of(1978, 10, 18), 12500,
						LocalDate.of(2021, 3, 15)));
				break;
			case 2:
				for (Employee employee : employees) {
					if (employee.getEndDate() == null)
						System.out.println(employee);
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
