/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		September 17th, 2019						**
** Class Name:	ArrayFillAD.java							**
** Description:	This program takes in 2 numbers from the 	**
**				user and will print out the numbers from	**
**				the lowest number to just before the highest**
**				number using a for loop. it'll then print 	**
**				out all of those numbers, with a comma in 	**
**				between.									**
**														    **
**************************************************************/
package package1;

import java.util.Scanner;

public class ArrayFillAD {

	public static void main(String[] args) {

		int numberOne 		= 0;								//Variable to hold the first number
		int numberTwo 		= 0;								//Variable to hold the second number
		int startingNumber 	= 0;								//Variable to hold the lowest number
		int endNumber 		= 0;								//Variable to hold the highest number
		int[] numberArray 	= new int[100];						//Array to hold all of the values


		Scanner scannerObj = new Scanner(System.in);			//Creates the scanner obj
		
		System.out.println("Please enter the first number: "); 	//Ask user to input the first number
		numberOne = Integer.parseInt(scannerObj.nextLine());	//Puts that number in numberOne var
		
		System.out.println("Please enter the second number: ");	//Ask user to input the second number
		numberTwo = Integer.parseInt(scannerObj.nextLine());	//Puts that number in numberTwo var
		
		
		if(numberOne < numberTwo) {								//Test to see what number is the lowest
			startingNumber = numberOne;							//Sets the lowest number to the starting number
			endNumber = numberTwo - 1;							//Sets the highest number to the ending number minus one
		}else {
			startingNumber = numberTwo;							//Sets the lowest number to the starting number
			endNumber = numberOne - 1;							//Sets the highest number to the ending number minus one
		}
		
		for(int x = startingNumber; x <=  endNumber; x++) {		//For loop to put all the number into the array
			numberArray[x-startingNumber] = x;					//Puts numbers in the array
			System.out.print(numberArray[x-startingNumber]);	//Prints out all the variables
			if(x != endNumber) {								//Test to see if its the last number, and if no, put a comma, but if the last number don't
				System.out.print(", ");
			}//End if()
		}//End for()
		scannerObj.close();										//Closes the scanner
	}//End main()
}//End ArrayFillAD()
