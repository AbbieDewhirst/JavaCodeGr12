/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		October 4th, 2019							**
** Class Name:	KeepTheDarnBall.java						**
** Description: This program takes in the player that   	**
**				scored, and will output how many possible	**
**				outcomes there are.         				**
**														    **
**************************************************************/
package package1;

import java.util.Scanner;

public class KeepTheDarnBall {

	public static void main(String[] args) {

		int playerNum;												//int player number to hold the player number of the one who scored the goal

		Scanner scannerObj = new Scanner(System.in); 				// Creates the scanner

		System.out.println("Please enter the player number: "); 	// Ask user to input the player number
		playerNum = scannerObj.nextInt();							//Makes player number equal to user input

		System.out.println(howManyOutcomes(playerNum));				//Runs the method that calculates the outcomes

		scannerObj.close();											//Closes the scanner
	}//End main()

	/*********************************************************
	** Name:        howManyOutcomes()						**
	** Input:       int playerNum	 						**
	** Output:     	int numberOfOutcomes            	 	**
	** Description: This method calculates how many outcomes**
	**				there are for the goal scored.      	**
	**********************************************************/	
	
	public static int howManyOutcomes(int playerNum) {
		int numberOfOutcomes = 0;									//Variable to hold the number of outcomes
		for (int x = 1; x <= playerNum - 3; x++) {					//For loop to calculate the outcomes
			for (int y = x + 1; y <= playerNum - 2; y++) {			//For loop to calculate the outcomes
				for (int z = y + 1; z <= playerNum - 1; z++) {		//For loop to calculate the outcomes
					numberOfOutcomes++;								//adds one to the number of outcomes
				}//End for()
			}//End for()
		}//End for()
		return numberOfOutcomes;									//Returns how many outcomes there are
	}//End howManyOutcomes()
}//End KeepTheDarnBall()