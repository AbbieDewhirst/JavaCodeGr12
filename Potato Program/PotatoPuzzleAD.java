/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		September 16th, 2019						**
** Class Name:	PotatoPuzzleAD.java							**
** Description:	This program reads a file that has amount	**
**				of 1kilo, 5kilo, and amount of kilos needed.**
**				It then calculates how many 5kilo and 1kilo	**
**				bags are needed to complete the shipment,	**
**				or if the shipment cannot be completed		**
**														    **
**************************************************************/
package package1;

import java.io.*;

public class PotatoPuzzleAD {

	public static void main(String[] args) {
		String inputData 	= "";																//String variable for the file info
		int oneKilo 		= 0;																//Amount of 1 kilo bags you have
		int fiveKilo 		= 0;																//Amount of 5 kilo bags you have
		int totalShipment 	= 0;																//Total amount of pounds needed
		int numberOf1Kilo 	= 0;																//Variable for mod math
		int numberOf1Kilos 	= 0;																//Variable for other mod math
		int totFive 		= 0;																//Variable for division math
		int plusRemain 		= 0;																//Variable for more mod math
		int sub 			= 0;																//More math

		try {

			BufferedReader bufferedObj = new BufferedReader(new FileReader("/Volumes/MARIA/Potato.txt")); 	//Opens file

			inputData 		= bufferedObj.readLine(); 											// Reads in the first line of the file
			oneKilo 		= Integer.parseInt(inputData);										//Parses the string to int

			inputData 		= bufferedObj.readLine(); 											// Reads in the second line of the file
			fiveKilo 		= Integer.parseInt(inputData);										//Parses the string to int

			inputData 		= bufferedObj.readLine(); 											// Reads in the third line of the file
			totalShipment 	= Integer.parseInt(inputData);										//Parses the string to int

			numberOf1Kilo 	= totalShipment % (fiveKilo * 5);									//Math for test
			numberOf1Kilos 	= totalShipment % 5;												//Math for test
			totFive 		= totalShipment / 5;												//Math for test

			if (totalShipment - (fiveKilo * 5) == 0) {											//Test if you have the exact number of big bags for the question

				System.out.println("You will need 0 small bags");

			} else if (oneKilo < numberOf1Kilo) {												//Test to see if the equation cannot be completed

				System.out.println("You need -1 small bags");

			} else {

				if (totFive < fiveKilo) {														//Test to see if this is a "special case" (you have more big bags than you need, and need x amount of small bags)
					sub = totFive - totFive;
					plusRemain = sub * 5 + numberOf1Kilos;
					System.out.println("You need " + plusRemain + " small bags");

				} else {
					sub = totFive - fiveKilo;
					plusRemain = (sub * 5) + numberOf1Kilos;
					if (plusRemain > oneKilo) {													//Test to print if question cannot be done
						System.out.println("You need -1 small bags");
					} else {
						System.out.println("You need " + plusRemain + " small bags");
					}//End if()
				}//End if()
			}//End if()

			bufferedObj.close();
		} catch (IOException error) { 															// Catches any errors
			System.out.println("You have a error: " + error); 									// Prints out any errors that are caught
		}// End try and catch()
	}// End main()
}// End PotatoPuzzleAD()
