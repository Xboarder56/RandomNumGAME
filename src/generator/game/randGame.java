/*
 * Garrett J. Beasley
 * 01/08/2015
 * randGame.java
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

/**This is the MAIN Class for the game to be launched from.
 * The game consists of 4 options for the user to select
 * Array, Coin, Color, Exit. 
 * Once the option is selected the user then completes the game
 * and will have a option to enter the game once again. 
 */
public class randGame 
{
	/*Variables for the program.*/
	private static int tails, heads;
	private static int[] Array;
	private static int loopCounter;
	
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
	
	/**
	 * Input One (when the user hits 1)
	 * @description When 1 is pressed the program will enter
	 * into the inputOne method and calculate the array based
	 * off the three input values passed in by the user. min/max/array length
	 * then will output them to the console.
	 */
	public static void inputOne()
	{
		/*Console Input taken from the user for the custom arrays*/
		Scanner console = new Scanner(System.in);
		System.out.println("How many elements do you want in your array?");
		int arrayElements = console.nextInt();
		console.nextLine(); //clears the prompt (to skip enter key)
		
		/*Console Input taken from the user for the custom arrays*/
		System.out.println("Min value?");
		int arrayMinValue= console.nextInt();
		console.nextLine(); //clears the prompt (to skip enter key)
		
		/*Console Input taken from the user for the custom arrays*/
		System.out.println("Max value?");
		int arrayMaxValue = console.nextInt();
		console.nextLine(); //clears the prompt (to skip enter key)
		
		/*Create a new Array called Array with
		 * the max array length based of user input into arrayElements*/
		Array = new int[arrayElements];
		
		/*Loop the array for (arrayElements) time*/
		for(int i=0; i<arrayElements; i++)
		{
			/*Array with values randomly based on the users min/max values*/
			Array[i] =  ((int) (Math.random( )*(arrayMaxValue))+arrayMinValue);
			
			/*Print the random array values out for the user to see*/
			System.out.print(Array[i]+" ");
			
			/*Used for closing the console
			 * If anyone sees this
			 * This is a bad method to use!
			 */
			loopCounter++;
		}
		
		/*Closes the console
		 * Has to be done this way
		 * or we get scanner util error*/
		if((loopCounter == arrayElements+1))
		{
			/*close the console*/
			console.close();
		}
	}
	
	/**
	 * Input Two (when the user hits 2)
	 * @description When 2 is pressed the program will enter
	 * into the inputTow method and calculate the flip of a coin
	 * off the input value the user enters in for how many times to flip
	 */
	public static void inputTwo()
	{
		/*Console Input taken from the user for the amount of flips*/
		Scanner console = new Scanner(System.in);
		System.out.println("How many coins do you want to flip? ");
		int coinAmount = console.nextInt();
		console.nextLine(); //clears the prompt (to skip enter key)
		
		/*Loop for the amount of flips the user specifies*/
		for(int i=0; i<=coinAmount; i++)
		{
			/*Coin only has 2 sides heads(0) tails(1)*/
			int randomValue = (int) (Math.random( )*(2));
			
			/*Check to see if coin is heads aka 0 */
			if(randomValue == 0)
			{
				/*Increases the heads number*/
				heads++;
			}
			
			/*Check to see if coin is tails aka 1 */
			else if(randomValue == 1)
			{
				/*Increases the tails number*/
				tails++;
			}
		}
		
		/*Prints to console what was generated*/
		System.out.println("You flipped "+ heads + " heads, " + tails +" tails");
		
		/*closes the scanner for the user*/
		console.close();
		
	}
	
	/**
	 * Input Three (when the user hits 3)
	 * @description When 3 is pressed the program will enter and
	 * start to calculate a random color and build the color
	 * under the variable named rand. 
	 */
	public static void inputThree()
	{
		/*Let the user know that we are generating a new color*/
		System.out.println("Generating a random color...");
		
		/*Color Randomizer to make it flash using the math.random class as the Random generator fails to work*/
		int RED = (int) (Math.random( )*256);
		int GREEN = (int)(Math.random( )*256);
		int BLUE= (int)(Math.random( )*256);
		
		/*Makes new color*/
		Color rand = new Color(RED,GREEN,BLUE);
		
		/*Print new color*/
		System.out.println(rand);
	}
	
	/**
	 * Input 4 (when the user hits 4)
	 * @description When 4 is pressed the program will enter
	 * into the inputFour method and tell the user goodbye
	 * then the system will exit the java machine.
	 */
	public static void inputFour()
	{
		/*Goodbye to the user and thank them*/
		System.out.println("Thanks for playing!!! :)");
		
		/*Close the java machine*/
		System.exit(0);
	}
	
	/** 
	 * This will read what the user inputs under the UI
	 * @description: This will read the users input from the UI then
	 * there selected decision will be placed into a variable between 1-4
	 * and compared to the programmed selections (Array, Coin, Color, Exit, Not valid)
	 */
	public static void inputReader()
	{
		/*Tell the user to pick a selection between 1-4*/
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter a selection: ");
		int selection = console.nextInt(); //clears the prompt (to skip enter key)
		console.nextLine();
		
		/*If user enters 1 enter this section*/
		if(selection == 1)
		{
			/*Go to 1 then loop the code after*/
			inputOne();
			inputReader();
		}
		
		/*If user enters 2 enter this section*/
		else if(selection == 2)
		{
			/*Go to 2 then loop the code after*/
			inputTwo();
			inputReader();
		}
		
		/*If user enters 3 enter this section*/
		else if(selection == 3)
		{
			/*Go to 3 then loop the code after*/
			inputThree();
			inputReader();
		}
		
		/*If user enters 4 enter this section*/
		else if(selection == 4)
		{
			/*Go to 4 then loop the code after*/
			inputFour();
			inputReader();
		}
		
		/*Anything else other then 1-4 will go down here*/ 
		else
		{
			/*Tell the user to please enter a number between 1-4 and loop the code*/
			System.out.println("Not a valid selection please enter a number between 1-4");
			inputReader();
		}
		/*Close the console*/
		console.close();
	}
}
