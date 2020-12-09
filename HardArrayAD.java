/*****************************************************************
**								**
** Name:	Abbie Dyck					**
** Date:	September 25th, 2019				**
** Class Name:	HardArrayAD.java				**
** Description:	This program will take a number from the  	**
**		user input, and print out every number from	**
**		0 to the number that was input in order		**
**		from the array using the second method.	 	**
**							    	**
******************************************************************/
package package1;

import java.util.Scanner;

public class HardArrayAD {

	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);					//Creates the scanner
		
		System.out.println("Please enter the number of terms: ");			//Ask user to input a number
		int termNum = scannerObj.nextInt();						//Makes term number equal to what the user input
		
		strangeSeries(termNum);								//Runs the method strangeSeries
		scannerObj.close();								//Closes the scanner
	}//End main()
	
	
	/*****************************************************************
	** Name:        strangeSeries()					**
	** Input:       int x (the number it needs to count to)		**
	** Output:      N/A				 		**
	** Description: This method will run a loop that will  		**
	**		print to the number that was input in	  	**
	**	        the pattren 1, 1, 2, 1, 2, 3, 1, 2, 3, 4 etc  	**
	******************************************************************/	
	public static void strangeSeries(int x) {						//Method strangeSeries that inputs one variable
		int[] seriesArray = new int[(x * (x + 1) /2)];					//Creates the array size
		
		for(int y = 1; y <= x; y++) {							//For loop to print numbers
			for(int i = 1; i <= y; i ++) {						//For loop to print numbers
				if(i == x) {							//if loop to test if i == x
					seriesArray[y] = i;					//Make the last array element x
					System.out.print(seriesArray[y] + "");			//Prints no comma because its the last element
				} else {							//Else (for the rest of the array)
					seriesArray[y] = i;					//Make the elements = i
					System.out.print(seriesArray[y] + ", ");		//Prints out a comma between the numbers
				}//End if()
			}//End for()
		}//End for()
	}//End strangeSeries()
}//End HardArrayAD()
