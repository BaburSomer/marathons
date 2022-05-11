package com.bilgeadam.marathon01;

public class Shape {
	private int sideA;
	private int sideB;
	private int sideC;
	private int sideD;
	private int numOfShape;

	public boolean isCorrectShape() {
		return sideC != 0;
	}

	private int calcPerimeter() {
		return this.sideA + this.sideB + this.sideC + this.sideD;
	}

	private int calcArea() {
		if (this.sideD == 0) { // triangle ==> a + b + c = 2u ==> √(u(u-a)(u-b)(u-c))
			int u = this.calcPerimeter() / 2;
			double sqrt = Math.sqrt(u * (u - this.sideA) * (u - this.sideB) * (u - this.sideC));
			return (int)sqrt;
		}
		else {		// basit hesaplama için sideA = sideB ve sideC = sideD olarak alınmıştır
			return this.sideA * this.sideC;
		}
	}
	
	public void showPerimeter() {
		System.out.println(this.numOfShape + ". şeklin çevresi: " + this.calcPerimeter());
	}

	public void showArea() {
		System.out.println(this.numOfShape + ". şeklin alanı: " + this.calcArea());
	}
	
	public void setSideA(int sideA) {
		this.sideA = sideA;
	}

	public void setSideB(int sideB) {
		this.sideB = sideB;
	}

	public void setSideC(int sideC) {
		this.sideC = sideC;
	}

	public void setSideD(int sideD) {
		this.sideD = sideD;
	}

	public void setNumOfShape(int numOfShape) {
		this.numOfShape = numOfShape;
	}
	
	
}
