package com.bilgeadam.marathon01;

import java.util.Scanner;

public class ShapeTest {
	private int numberOfShapes;

	public static void main(String[] args) {
		ShapeTest shapeTest = new ShapeTest();
		shapeTest.readInput();
		System.out.println("Bye...");
	}

	private void readInput() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print(
					"Lütfen hesaplamak istediğiniz şeklin (en fazla 4 kenar) kenar uzunluklarını giriniz (-1 ile çıkış): ");
			System.out.println();
			boolean exit       = false;
			int     numOfEdges = 0;
			int     a          = 0, b = 0, c = 0, d = 0;
			int     input      = 0;
			do {
				System.out.print("Lütfen " + (numOfEdges + 1) + ". kenar uzunluğunu giriniz (0 ile sonlandır): ");
				input = in.nextInt();
				if (input == -1) {
					exit = true;
					break;
				}
				switch (numOfEdges) {
					case 0:
						a = input;
						break;
					case 1:
						b = input;
						break;
					case 2:
						c = input;
						break;
					case 3:
						d = input;
						break;
				}
				numOfEdges++;

			} while (input != 0 && numOfEdges < 4);

			if (exit) {
				break;
			}
			if (numOfEdges == 0) {
				continue;
			}
			numberOfShapes++;
			Shape shape = new Shape();
			shape.setSideA(a);
			shape.setSideB(b);
			shape.setSideC(c);
			shape.setSideD(d);
			shape.setNumOfShape(numberOfShapes);
			if (!shape.isCorrectShape()) {
				System.err.println("İki kenarlı şekil olamaz!");
			}
			else {
				shape.showPerimeter();
				shape.showArea();
			}
		}
		in.close();
	}
}