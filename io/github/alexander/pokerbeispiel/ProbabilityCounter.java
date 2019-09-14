package io.github.alexander.pokerbeispiel;

public class ProbabilityCounter {

	private Carddeck deck;

	public ProbabilityCounter(Carddeck deck) {
		this.deck = deck;
	}

	public void printProbabilities(int times) {
		long start = System.currentTimeMillis();
		double timesPair = 0;
		double timesThreeOfAKind = 0;
		double timesFourOfAKind = 0;
		double timesTwoPair = 0;
		double timesFlush = 0;
		double timesStraightFlush = 0;
		double timesRoyalFlush = 0;
		double timesFullHouse = 0;
		double timesStraight = 0;
		double timesHighestCard = 0;

		for (int i = 0; i < times; i++) {
			deck.shuffle();
			if (deck.checkIfRoyalFlush()) {
				timesRoyalFlush++;
				continue;
			}
			if (deck.checkIfStraightFlush()) {
				timesStraightFlush++;
				continue;
			}
			if (deck.checkIfFourOfAKind()) {
				timesFourOfAKind++;
				continue;
			}
			if (deck.checkIfFullHouse()) {
				timesFullHouse++;
				continue;
			}
			if (deck.checkIfFlush()) {
				timesFlush++;
				continue;
			}
			if (deck.checkIfStraight()) {
				timesStraight++;
				continue;
			}
			if (deck.checkIfThreeOfAKind()) {
				timesThreeOfAKind++;
				continue;
			}
			if (deck.checkIfTwoPair()) {
				timesTwoPair++;
				continue;
			}
			if (deck.checkIfOnePair()) {
				timesPair++;
				continue;
			}
			timesHighestCard++;
		}
		System.out.printf("Probability of Royal Flush: %1.5f%%\n", timesRoyalFlush / times * 100);
		System.out.printf("Probability of Straight Flush: %1.5f%%\n", timesStraightFlush / times * 100);
		System.out.printf("Probability of Four Of A Kind: %1.4f%%\n", timesFourOfAKind / times * 100);
		System.out.printf("Probability of Full House: %1.4f%%\n", timesFullHouse / times * 100);
		System.out.printf("Probability of Flush: %1.3f%%\n", timesFlush / times * 100);
		System.out.printf("Probability of Straight: %1.3f%%\n", timesStraight / times * 100);
		System.out.printf("Probability of Three Of A Kind:%1.2f%%\n", timesThreeOfAKind / times * 100);
		System.out.printf("Probability of Two Pair: %1.2f%%\n", timesTwoPair / times * 100);
		System.out.printf("Probability of Pair: %1.2f%%\n", timesPair / times * 100);
		System.out.printf("Probability of High Card: %1.2f%%\n", timesHighestCard / times * 100);
		long elapsedSeconds = (System.currentTimeMillis()-start)/1000;
		System.out.println("It took " + Long.toString(elapsedSeconds) + " seconds to calculate.");
	}
}
