//package MadLibs;

import java.util.Random;
import java.util.Scanner;

public class Madlibs 
{
	//variables
		Scanner scanner = new Scanner(System.in);

		String story;
		String name;
		String adjective1;
		String adjective2;
		String noun1;
		String noun2;
		String noun3;
		String adverb;
		String randomNums;
		Random rand = new Random();

	//getters
		public String getStory()
		{
			return story;
		}

		public String getName()
		{
			return name;
		}

		public String getAdjective1()
		{
			return adjective1;
		}

		public String getAdjective2()
		{
			return adjective2;
		}

		public String getNoun1()
		{
			return noun1;
		}

		public String getNoun2()
		{
			return noun2;
		}

		public String getNoun3()
		{
			return noun3;
		}

		public String getAdverb()
		{
			return adverb;
		}

		public String getRandomNums()
		{
			return randomNums;
		}

	//setters
		public void setStory(String newStory)
		{
			this.story = newStory;
		}

		public void setName(String newName)
		{
			this.name = newName;
		}

		public void setAdjective1(String newAdjective1)
		{
			this.adjective1 = newAdjective1;
		}

		public void setAdjective2(String newAdjective2)
		{
			this.adjective2 = newAdjective2;
		}

		public void setNoun1(String newNoun1)
		{
			this.noun1 = newNoun1;
		}

		public void setNoun2(String newNoun2)
		{
			this.noun2 = newNoun2;
		}

		public void setNoun3(String newNoun3)
		{
			this.noun3 = newNoun3;
		}

		public void setAdverb(String newAdverb)
		{
			this.adverb = newAdverb;
		}

		public void setRandomNums()
		{
			int num = Math.abs(rand.nextInt()) % 100;
			int i = 0;

			int numberHolder[] = new int[3];

			while(i < numberHolder.length)
			{
				numberHolder[i] = num + i;
				i++;
			}

			randomNums = "not " + numberHolder[0] + ", not " + numberHolder[1] + ", but " + numberHolder[2];
		}

	//give instruvtions to the player
		public void printInstructions()
		{
			System.out.println("Welcome to the Madlibs game. Start typing your name.");
		}

	//get data input from the player
		public void enterName()
		{
			System.out.println("Give me your name");
			setName(scanner.nextLine());
		}

		public void enterNoun1()
		{
			System.out.println("Give me a noun");
			setNoun1(scanner.nextLine());
		}

		public void enterNoun2()
		{
			System.out.println("Give me a noun2");
			setNoun2(scanner.nextLine());
		}

		public void enterNoun3()
		{
			System.out.println("Give me a noun3");
			setNoun3(scanner.nextLine());
		}

		public void enterAdjective1()
		{
			System.out.println("Give me a adjective");
			setAdjective1(scanner.nextLine());
		}

		public void enterAdjective2()
		{
			System.out.println("Give me a adjective2");
			setAdjective2(scanner.nextLine());
		}

		public void enterAdverb()
		{
			System.out.println("Give me a adverb");
			setAdverb(scanner.nextLine());
		}

		public void play()
		{
			enterName();
			enterNoun1();
			enterAdjective1();
			enterAdjective2();
			enterNoun2();
			enterAdverb();
			enterNoun3();
			setRandomNums();

			putTogether();

			System.out.println(getStory());
		}
		
		public void putTogether()
		{
			String story = "Aman and " + getName() + " went to mumbai. We say a " + getNoun1() + " in a show at the Bollywood and ate a " + getAdjective1() +
			" feast for dinner. The next day, I ran " + getAdverb() + " to meet SRK in his " + getNoun2() + " and that night, I gazed at the " + 
		 	getRandomNums() + " " + getAdjective2() + " fireworks shooting from the " + getNoun3() + ".";

		 	setStory(story);
		}

	//man function
		public static void main(String [] args)
		{
			Madlibs game = new Madlibs();
			game.printInstructions();
			game.play();
		}
	}