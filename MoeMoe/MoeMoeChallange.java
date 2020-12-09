/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		September 27th, 2019						**
** Class Name:	MoeMoeChallange.java						**
** Description:	This program takens in a amount of time from**
**				the scanner, then creates a amount of moes, **
**				moeMoes, and bigMoes based off of the time	**
**				that was input, then prints out the result	**
**				or if the shipment cannot be completed		**
**														    **
**************************************************************/
package package1;

import java.util.Scanner;

public class MoeMoeChallange {

	public static void main(String[] args) {
		int timeSec		   = 0;															//Sets the timeSec to 0
		Scanner scannerObj = new Scanner(System.in); 									// Creates the scanner

		System.out.println("Please enter the time (in seconds): "); 					// Ask user to input a number
		timeSec = scannerObj.nextInt(); 												// Makes timesec equal to what the user input

		System.out.println(moeMoeChallenge(timeSec));									//Runs the moeMoeChallenge() method with the param timeSec and prints out the result

		scannerObj.close();																//Closes the scanner
	}//End main()
	
/*********************************************************
** Name:        moeMoeChallenge()						**
** Input:       int x (time it needs to run for)		**
** Output:      N/A									 	**
** Description: This method will run a loop the correct **
**		        number of times to produce the right	**
**		        amount of moes, bigMoes, and moeMoes	**
**********************************************************/	

	public static String moeMoeChallenge(int x) {
		int[] moeArray = { 1, 0, 0 };													//Creates a array to hold the number of moes, bigMoes, and moeMoes
		int time = x;																	//Makes the variable time equal to x

		forLoop: for (int y = 1; y <= x; y++) {											//For loop to run the if loops

			if (y == 4) {																//If loop to check if y is equal to 4
				moeArray[1] = moeArray[0];												//makes the number of moeMoes equal to the number of moes
				moeArray[0] = 0;														//Makes the number of moes equal to 0

			} else if (y == 13) {														//If loop to check if y is equal to 13
				moeArray[2] = moeArray[1];												//Makes the number of bigMoes equal to moeMoes
				moeArray[1] = 0;														//Makes the number of moeMoes equal to 0

			} else if (y == 33) {														//If loop to check if y is equal to 33
				moeArray[0] = moeArray[2] * 2;											//Makes the number of moes equal to two times the number of bigMoes 
				moeArray[2] = 0;														//Makes the number of bigMoes equal to 0
				time -= 33;																//Time sub 33 (time taken so far)
				y = 1;																	//Makes y equal to 1
				x -= 33;																//X sub 33 (time taken so far)
			}//End if()

			if (time < 0) {																//if time is less than 0 (we are now done)
				break forLoop;															//Break out of the for loop
			}//End if()
		}//End for()
		
		return moeArray[0] + " " + moeArray[1] + " " + moeArray[2] + " ";	//Print out the number of moes, moeMoes, and bigMoes
	
	}//End moeMoeChallenge()
}//End MoeMoeChallange()
