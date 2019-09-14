package io.github.alexander.pokerbeispiel;

import java.util.Random;

public class Card {

	private final int AMOUNTOFCOLORS = 4;
	private final int AMOUNTOFCARDNUMBERS = 13;

	private static Random r = new Random();
	private int cardNumber;
	private int color;

	public Card() {
		setRandomNumber();
	}

	public void setRandomNumber() {
		setNumber(r.nextInt(AMOUNTOFCARDNUMBERS) + 1);
		setColor(r.nextInt(AMOUNTOFCOLORS) + 1);
	}

	private void setNumber(int number) {
		if (number > AMOUNTOFCARDNUMBERS || number < 1)
			return;
		this.cardNumber = number;
	}

	private void setColor(int color) {
		if (color > AMOUNTOFCOLORS || color < 1)
			return;
		this.color = color;
	}

	public int getNumber() {
		return this.cardNumber;
	}

	public int getColor() {
		return this.color;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Card) {
			Card k = (Card) obj;
			if (k.getNumber() == this.getNumber() && k.getColor() == this.getColor()) {
				return true;
			}
		}

		return false;
	}
}
