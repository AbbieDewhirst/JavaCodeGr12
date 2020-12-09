/*************************************************************
**					         	    **
** Name:	Abbie Dyck				    **
** Date:	January 7th, 2020			    **
** Class Name:	TowersOfHanoiLevel4FSEAD.java		    **
** Description:	This program takes in the number of disk    **
**		from the user, then will move them all from **
**		the left disk to the right disk (It starts  **
**		playing the Towers of Hanoi game).	    **
**							    **
**************************************************************/
package package1;

import java.util.*; 

public class TowersOfHanoiLevel4FSEAD {

	public static void main(String args[]) {
		
		Scanner scannerObj = new Scanner(System.in);					//ScannerObj to take in the number of disk

		System.out.println("Please enter the number of disk: ");			//Ask the user to enter the number is disk
		int numberOfDisk = scannerObj.nextInt();					//Makes numberOfDisk equal to what the user entered
		System.out.println(); 								//Prints a blank line
		
		movingTheDisk(numberOfDisk, '1', '3', '2');					//Calls movingTheDisk to play the game
		scannerObj.close();								//Closes scannerObj
	}//End main()

/*************************************************************************
** Name:        movingTheDisk()						**
** Input:       numberOfDisk	- Number of disk the game		**
**		                  is playing with			**
**		from 		- The peg the move is starting from	**
**		to 		- The peg the move is going to		**
**		aux 		- The peg not being used to move	**
**				  in that turn				**
** Output:      void							**
** Description: This method will play the Towers of Hanoi game by 	**
**		Calling itself recursively.				**
**************************************************************************/	
	static void movingTheDisk(int numberOfDisk, char from, char to, char aux) {
		if (numberOfDisk == 1) {							//If numberOfDisk is equal to 1
			System.out.println("1 to " + to);					//Print the move made
			return;									//Return
		}//End if()
		movingTheDisk(numberOfDisk - 1, from, aux, to);					//Calls movingTheDisk to make the next move
		
		System.out.println( numberOfDisk + " to " + to);				//Prints the move it just made
		
		movingTheDisk(numberOfDisk - 1, aux, to, from);					//Calls movingTheDisk to make the next move
	}//End movingTheDisk()
}//End TowersOfHanoiLevel4FSEAD()
