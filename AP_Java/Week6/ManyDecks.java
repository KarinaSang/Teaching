package week6;

public class ManyDecks {
	private Deck[] allDecks;
	public static final int NUMDECKS = 3;
	
	
	/** constructor */
	public ManyDecks() {
		allDecks = new Deck[NUMDECKS];
	
		for (int i = 0; i < NUMDECKS; i++)
			allDecks[i] = new Deck(); // need to initialize every Deck
	}

	
	/** Shuffle the Decks. */
	public void shuffleAll() {
		for (Deck d : allDecks)
			d.shuffle(); // modifying each Deck using the mutator method shuffle
	}
	
	/** Write contents of all the Decks. */
	public void printDecks() {
		for (Deck d : allDecks)
			d.writeDeck();
	}
}
