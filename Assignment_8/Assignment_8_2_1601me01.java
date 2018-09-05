import java.security.SecureRandom;

class Card
{
	private final String face;
	private final String suit;

	Card(String face, String suit)
	{
		this.face = face;
		this.suit = suit;
	}

}

class DeckOfCards
{
	int currentCard;
	final int NUMBER_OF_CARDS = 52;

	Card deck[];

	DeckOfCards()
	{
		deck = new Card[NUMBER_OF_CARDS];	

		for(int i=0; i<NUMBER_OF_CARDS; i++)
		{
			deck[i] = new Card("king", "hearts");
		}
	}

	void shuffle()
	{
		SecureRandom randomNumbers = new SecureRandom();
		int rand = randomNumbers.nextInt(10);
		System.out.println("Your current card is: " + Integer.toString(rand));
		this.currentCard = rand;
	}

	void dealCard()
	{

	}
}

public class Assignment_8_2_1601me01
{
	public static void main(String[] args) 
	{
		DeckOfCards obj = new DeckOfCards();
		obj.shuffle();


	}
}