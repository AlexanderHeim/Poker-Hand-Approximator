package io.github.alexander.pokerbeispiel;

public class Pokerbeispiel {

	public static void main(String[] args) {
		ProbabilityCounter pc = new ProbabilityCounter(new Carddeck());
		pc.printProbabilities(10000000);
	}
}