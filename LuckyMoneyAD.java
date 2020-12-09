/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		October 2nd, 2019							**
** Class Name:	LuckyMoneyAD.java							**
** Description: This program takes in the codes of bills	**
**				that are input by users, and prints if the	**
**				code is lucky or not lucky.					**
**														    **
**************************************************************/
package package1;

import java.util.Scanner;

public class LuckyMoneyAD {

	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);									//Creates the Scanner Object
		System.out.println("Please enter the number of codes you will be testing: ");	//Ask the user how many codes will be tested
		int serialNumber = Integer.parseInt(scannerObj.nextLine());						//Takes in the user input

		for (int x = 1; x <= serialNumber; x++) {										//For loop for the users to enter all the codes
			System.out.println("Please Enter Code " + x);								//ASk user to enter the codes
			System.out.println(CheckingTheSerialNumbers(scannerObj.nextLine()));		//Runs the method that will test if the codes are lucky or not lucky

		}//End for()
		scannerObj.close();																//Closes the Scanner Object
	}//End main()
	
/*********************************************************
** Name:        CheckingTheSerialNumbers()				**
** Input:       String nextLine 						**
** Output:     	String var (LUCKY or NOT LUCKY)		 	**
** Description: This method takes in the codes that are **
**				being tested and will output weather	**
**				they are lucky or not.					**
**********************************************************/	
	
	public static String CheckingTheSerialNumbers(String nextLine) {
		if (nextLine.length() % 3 != 0) {												//If the number of letters in the code is not divisible by 3, its is automatically not lucky
			return "THE BILL IS NOT LUCKY";												//Prints that the bill is not lucky
		}//End if()
		String test = Character.toString(nextLine.charAt(0)) + Character.toString(nextLine.charAt(1)) + Character.toString(nextLine.charAt(2));						//Makes a string variable called test to hold the first 3 values

		for (int x = 0; x < nextLine.length(); x += 3) {																											//For loop to run through the codes
			if (!test.equals(Character.toString(nextLine.charAt(x)) + Character.toString(nextLine.charAt(x + 1)) + Character.toString(nextLine.charAt(x + 2)))) {	//Test to see if the chars are not the same
				return "NOT LUCKY";																																	//Prints not lucky if true
			}//End if()
		}//End for()
		return "LUCKY";																																				//Prints lucky if the if fails
	}//End CheckingTheSerialNumbers
}//End LuckyMoneyAD
