package main;

import model.Shape;
import model.Persegi;

public class Main {

	public Main() {
		Shape s = new Persegi(4);
		s.printPersegi();
	}

	public static void main(String[] args) {
		new Main();
	}

}
