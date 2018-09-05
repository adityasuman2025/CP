import java.util.*;
import java.security.SecureRandom;

class Card
{
    private final String face,suit;
    Card(String f, String s)
    {
        face = f;
        suit  = s;
    }

    void display()
    {
        System.out.println(face + " of " + suit);
    }
}

class DeckOfCards{
    static final int NUMBER_OF_CARDS = 52;
    Card [] deck = new Card[NUMBER_OF_CARDS];
    int currentCard;   

    static String suitTypes[]  = {"Clubs","Spades","Hearts","Diamonds" };
    static String faceTypes[]  = {"Ace","2","3","4","5","6","7","8","9","10","King","Queen","Jack" };

    DeckOfCards()
    {
        currentCard = NUMBER_OF_CARDS -1;
        int a;
        for(int i = 0;i<4;i++)
        {
            for(int j = 0;j<13;j++)
            {
                a  = 13*i+j;
                deck[a] = new Card(faceTypes[12-j] , suitTypes[i]);
            }
        }
    }
    
    void shuffle()
    {
        SecureRandom rand = new SecureRandom();
        int a;
        Card c;
        for(int i = 0;i <=currentCard ; i++)
        {
            a = rand.nextInt(currentCard+1);
            c = deck[i];
            deck[i] = deck[a];
            deck[a] = c;
        }
    }
    
    void dealCard(int n)
    {
        if(currentCard < 0) 
        {
        	System.out.println("No cards left in deck. Create new deck.");
        	return;
        }

        if(currentCard+1 < n ) 
        {
        	System.out.println("Not enough cards. Can deal only "+ (currentCard+1) +" cards."); 
        	return;
        }

        for(int i = 0; i<n; i++)
        {
            deck[currentCard].display();
            currentCard--;
        }
    }
    
}


public class Assignment_8_2_1601me01
{
	public static Scanner sc = new Scanner(System.in);        
    public static void main(String[] args)
    {
        char c = 'y';
        DeckOfCards d = new DeckOfCards();

        while (true)
        {
            System.out.print("Choices:  \n1. Create Deck \n2. shuffle Deck \n3. Deal Cards \n4. quit \nEnter your Choice: ");
            int ch = sc.nextInt();
            
            if(ch == 1)
            {
                d = new DeckOfCards();
            }
            else if (ch == 2)
            {
                d.shuffle();
            }
            else if (ch == 3)
            {
                System.out.print("Enter the number of cards to deal: ");
                int no = sc.nextInt();
                d.dealCard(no);
            }
            else if (ch == 4)
            {
                break;
            }
        }
    }
}
