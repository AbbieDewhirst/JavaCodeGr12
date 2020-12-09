/*****************************************************************
**								**
** Name:	Abbie Dyck					**
** Date:	September 11th, 2019				**
** Class Name:	Assignment1.java				**
** Description:	Takes in a file name which is input by the	**
**		user and puts it in a var called fileName.	**
**		It then finds that file, and reads in the 	**
**		first line with a buffered reader. It then	**
**		prints out the first line in the file and 	**
**		closes both the scanner and the buffered	**
**		reader.						**
**							   	**
******************************************************************/
package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		String fileName = "";											//Creates a variable called fileName to hold the file name
		String fileInfo = "";											//Creates a variable called fileInfo to hold the first line of the file
		
		try {
			
			Scanner scannerObj = new Scanner(System.in);							//Creates a Scanner object
			
			System.out.println("Enter file name: ");							//Ask user to input the file name
			
			fileName = scannerObj.nextLine();								//Reads in user input
			
			BufferedReader bufferedObj = new BufferedReader(new FileReader(fileName));			//Creates a buffered reader to read in the file which the user input

			fileInfo = bufferedObj.readLine();								//Reads in the first line of the file
			
			System.out.println(fileInfo);									//Prints out the first line of the file
			
			scannerObj.close();										//Close the scannerObj
			bufferedObj.close();										//Close the bufferedObj
		} catch (IOException error) {										//Catches any errors
			System.out.println("You have a error: " + error);						//Prints out any errors that are caught
		} // End try and catch()
	}// End main()
}//End Assignment1
