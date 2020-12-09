/*****************************************************************
**								**
** Name:	Abbie Dyck					**
** Date:	October 18th, 2019				**
** Class Name:	LabTest.java					**
** Description: This program takes in the number of sides   	**
**		for 2 dice, then will tell the user how many	**
**		possibilities there are to get the sum of 	**
**		10.             			       	**
**							   	**
******************************************************************/
package package1;

import java.util.*;

public class LabTest {

	public static void main(String[] args) {
		int numOfSidesM = 0;										//Variable numOfSidesM to hold how many sides the dice m has
		int numOfSidesN = 0;										//Variable numOfSidesN to hold how many sides the dice n has
		int results 	= 0;										//Variable results to hold how many possible results there are that add to 10
		
		Scanner scannerObj = new Scanner(System.in);							//Creates a scanner object

		System.out.println("Enter m: ");								//Asks user to enter the number of sides dice "m" has
		numOfSidesM = scannerObj.nextInt();								//Makes numOfSidesM equal to the users input
		
		System.out.println("Enter n: ");								//Asks user to enter the number of sides dice "n" has
		numOfSidesN = scannerObj.nextInt();								//Makes numOfSidesN equal to the users input
		
		for(int m = 1; m <= numOfSidesM; m++) {								//For loop to sort through the possible values of dice m
			for(int n = 1; n <= numOfSidesN; n++) {							//For loop to sort through the possible values of dice n
				if((m + n) == 10) {								//If statement to test if m + n is equal to 10
					results += 1;								//If true, add one to results
				}//End if()
			}//End for()
		}//End for()
		
		if(results == 1) {										//If statement to see if results is equal to 1
			System.out.println("There is 1 way to get the sum 10.");				//If true print statement with "way"
		} else {											//Else
			System.out.println("There are " + results + " ways to get the sum 10.");		//Print "ways"
		}//End if()
		scannerObj.close();										//Closes the scanner object.
	}//End main()
}//End LabTest()
