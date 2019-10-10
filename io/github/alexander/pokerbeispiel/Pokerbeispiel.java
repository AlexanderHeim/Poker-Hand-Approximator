package io.github.alexander.pokerbeispiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Pokerbeispiel {

	public static void main(String[] args) {
		ProbabilityCounter pc = new ProbabilityCounter(new Carddeck());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	System.out.print("How many shuffles:");
        	try {
            		int i = Integer.parseInt(br.readLine());
			pc.printProbabilities(i);
        	} catch(NumberFormatException | IOException nfe) {
            		System.err.println("Invalid Format!");
        	}
		
		
	}
}
