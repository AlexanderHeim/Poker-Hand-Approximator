package io.github.alexander.pokerbeispiel;

import java.util.ArrayList;

public class Carddeck {

	private final int AMOUNTOFCARDS = 5;
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Carddeck() {
		reassembleDeck();
	}

	public void shuffle() {
		reassembleDeck();
	}

	public void addCard() {
		Card k = new Card();
		for (Card k1 : cards) {
			if (k.getNumber() == k1.getNumber() && k.getColor() == k1.getColor()) {
				addCard();
				return;
			}
		}
		cards.add(k);
	}

	public void reassembleDeck() {
		cards.clear();
		for (int i = 0; i < AMOUNTOFCARDS; i++) {
			addCard();
		}
	}

	public int getAmountOfPairs() {
		int[] amounts = new int[13];
		for (Card k : cards) {
			int number = k.getNumber();
			amounts[number - 1]++;
		}
		int pairs = 0;
		for (int i = 0; i < 13; i++) {
			if (amounts[i] >= 2) {
				pairs++;
			}
		}
		return pairs;
	}

	public boolean checkIfOnePair() {
		if (checkIfMultiple(2))
			return true;
		return false;
	}

	public boolean checkIfTwoPair() {
		if (getAmountOfPairs() == 2)
			return true;
		return false;
	}

	public boolean checkIfThreeOfAKind() {
		if (checkIfMultiple(3))
			return true;
		return false;
	}

	public boolean checkIfFourOfAKind() {
		if (checkIfMultiple(4))
			return true;
		return false;
	}

	public boolean checkIfFlush() {
		if (cards.get(0) != null)
			;
		Card c = cards.get(0);
		for (Card k : cards) {
			if (k.getColor() != c.getColor()) {
				return false;
			}
		}
		return true;
	}

	public boolean checkIfFullHouse() {
		int[] amounts = new int[13];
		for (Card k : cards) {
			int number = k.getNumber();
			amounts[number - 1]++;
		}
		boolean pair = false;
		boolean threepair = false;
		for (int i = 0; i < 13; i++) {
			if (amounts[i] == 2) {
				pair = true;
			}
			if (amounts[i] == 3) {
				threepair = true;
			}
		}
		if (pair && threepair)
			return true;
		return false;
	}

	public boolean checkIfMultiple(int amount) {
		for (Card k : cards) {
			int count = 1;
			for (Card c : cards) {
				if (k.equals(c))
					continue;
				if (k.getNumber() == c.getNumber()) {
					count++;
				}
			}
			if (count == amount) {
				return true;
			}
			count = 1;
		}
		return false;
	}

	public boolean checkIfStraight() {
		int max = getHighestCard();
		int count = 1;
		for (int i = 0; i < AMOUNTOFCARDS; i++) {
			for (Card k : cards) {
				if (k.getNumber() == max - 1) {
					max = k.getNumber();
					count++;
				}
			}
		}
		if (count >= AMOUNTOFCARDS)
			return true;
		return false;

	}

	public boolean checkIfStraightFlush() {
		if (this.checkIfFlush() && this.checkIfStraight()) {
			return true;
		}
		return false;
	}

	public int getHighestCard() {
		int value = 0;
		for (Card k : cards) {
			if (k.getNumber() > value) {
				value = k.getNumber();
			}
		}
		return value;
	}

	public boolean checkIfRoyalFlush() {
		if (getHighestCard() != 13)
			return false;
		if (!checkIfStraightFlush())
			return false;
		return true;
	}
	
	public void printCards() {
		for (Card k : cards) {
			System.out.println(
					"Card: Color: " + Integer.toString(k.getColor()) + "   Value: " + Integer.toString(k.getNumber()));
		}
	}
}
