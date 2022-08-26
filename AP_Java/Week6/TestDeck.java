package week6;

public class TestDeck {

	public static void main(String[] args) {
//		Deck d = new Deck();
//		d.writeDeck();
//		
//		d.shuffle();
//		d.writeDeck();
//		
//		d.shuffle();
//		d.writeDeck();
		
		
		ManyDecks d = new ManyDecks();
		d.printDecks();
		
		d.shuffleAll();
		d.printDecks();	
	}

}
