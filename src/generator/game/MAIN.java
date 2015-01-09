/*
 * Garrett J. Beasley
 * 01/08/2015
 * MAIN.java
 * 
 */

/**
 * @author Garrett J. Beasley
 * @date 01/08/2015
 * @description The program is a simple game that will allow
 * the user to build there own array, flip a coin, create a color
 * all based of the java util scanner and the random generator from the math class.
 */

/*Package for the project (generator.game)*/
package generator.game;

/*Imports for the project*/
import java.util.Scanner;
import java.awt.Color;

/**This is the MAIN Class for the game to be launched from
 */
public class MAIN 
{
	/*Variables for the program.*/
	public static int tails, heads;
	static int[] Array;
	static int loopCounter;
	
	public static void main(String[] args)
	{
		/*Calling the methods into the main method to be run.*/
		intro();
		inputReader();
	}
	
	/**Intro UI for the game
	 * @description This basically is the console ui for the game allowing
	 * the user to select 1-4 and then the program will enter into that mode.
	 *  */
	public static void intro()
	{
		/*User input and selections for the user*/
		System.out.println("Welcome to the Random Generation Game!");
		System.out.println("Choose an option below: ");
		System.out.println("1: Generate a random array of numbers!");
		System.out.println("2: Flip a coin!");
		System.out.println("3: Create a random color!");
		System.out.println("4: Exit!");
	}
	
	public static void inputOne()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("How many elements do you want in your array?");
		int arrayElements = console.nextInt();
		console.nextLine();
		System.out.println("Min value?");
		int arrayMinValue= console.nextInt();
		console.nextLine();
		System.out.println("Max value?");
		int arrayMaxValue = console.nextInt();
		console.nextLine();
		
		Array = new int[arrayElements];
		
		for(int i=0; i<arrayElements; i++)
		{
			Array[i] =  ((int) (Math.random( )*(arrayMaxValue))+arrayMinValue);
			System.out.print(Array[i]+" ");
			loopCounter++;
		}
		
		/*Closes the console
		 * Has to be done this way
		 * or we get scanner util error*/
		if((loopCounter == arrayElements+1))
		{
			console.close();
		}
	}
	
	public static void inputTwo()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("How many coins do you want to flip? ");
		int coinAmount = console.nextInt();
		console.nextLine();
		
		for(int i=0; i<=coinAmount; i++)
		{
			int randomValue = (int) (Math.random( )*(2));
			
			if(randomValue == 0)
			{
				heads++;
			}
			else if(randomValue == 1)
			{
				tails++;
			}
		}
		
		System.out.println("You flipped "+ heads + " heads, " + tails +" tails");
		console.close();
		
	}
	
	public static void inputThree()
	{
		System.out.println("Generating a random color...");
		/*Color Randomizer to make it flash using the math.random class as the Random generator fails to work*/
		int RED = (int) (Math.random( )*256);
		int GREEN = (int)(Math.random( )*256);
		int BLUE= (int)(Math.random( )*256);
		
		/*Makes new color*/
		Color rand = new Color(RED,GREEN,BLUE);
		System.out.println(rand);
	}
	
	public static void inputFour()
	{
		System.out.println("Thanks for playing!!! :)");
		System.exit(0);
	}
	
	/** 
	 * @description: This will read the users input from the UI then
	 * there selected decision will be placed into a variable between 1-4
	 * and compared to the programmed selections (Array, Coin, Color, Exit, Not valid)
	 */
	public static void inputReader()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter a selection: ");
		int selection = console.nextInt();
		console.nextLine();
		if(selection == 1)
		{
			inputOne();
			inputReader();
		}
		else if(selection == 2)
		{
			inputTwo();
			inputReader();
		}
		else if(selection == 3)
		{
			inputThree();
			inputReader();
		}
		else if(selection == 4)
		{
			inputFour();
			inputReader();
		}
		else
		{
			System.out.println("Not a valid selection please enter a number between 1-4");
			inputReader();
		}
		/*Close the console*/
		console.close();
	}
}
