package io.github.alexander.pokerbeispiel;

public class Pokerbeispiel {

	public static void main(String[] args) {
		ProbabilityCounter pc = new ProbabilityCounter(new Carddeck());
		System.out.print("How many shuffles?");
		String input = System.console().readLine();
		pc.printProbabilities(10000000);
	}
}
