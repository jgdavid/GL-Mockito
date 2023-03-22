package com.qa.mock;

import java.time.LocalDate;
import java.time.Month;

public class Demo {

	public static void main(String[] args) {
		LocalDate.of(1994, Month.APRIL, 4);
		Simulator sim = new Simulator();

		System.out.println(RPS.valueOf("ROCK"));
		for (int i = 0; i < 100; i++)
			System.out.println(sim.playRPS(RPS.SCISSORS));
	}

}
