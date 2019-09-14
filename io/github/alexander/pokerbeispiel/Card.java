package io.github.alexander.pokerbeispiel;

import java.util.Random;

public class Card {

	private final int amountOfColors = 4;
	private final int amountOfCardNumbers = 13;

	private static Random r = new Random();
	private int cardNumber;
	private int color;

	public Card() {
		setRandomNumber();
	}

	public void setRandomNumber() {
		setNumber(r.nextInt(amountOfCardNumbers) + 1);
		setColor(r.nextInt(amountOfColors) + 1);
	}

	private void setNumber(int number) {
		if (number > 13 || number < 1)
			return;
		this.cardNumber = number;
	}

	private void setColor(int color) {
		if (color > 4 || color < 1)
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
