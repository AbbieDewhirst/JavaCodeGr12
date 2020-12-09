/*************************************************************
**							    **
** Name:	Abbie Dyck				    **
** Date:	October 15th, 2019			    **
** Class Name:	BubSort.java				    **
** Description: This program takes a array of numbers from  **
**		file and then sort them either greatest to  **
**		least or vice versa, then prints to a file  **
**		called sorted.dat			    **
**							    **
**************************************************************/
package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BubSort {

	public static void main(String[] args) {
		try {
			String line = null;										//Variable line to read each line of data
			int sortArray[] = new int[500];									//sortArray with a max of 500 elements 
			int count = 0;											//Variable count to keep track of how many elements there are
			int order = 0;											//Variable order to keep track of what order the values will be sorted in

			BufferedReader bufferedObj = new BufferedReader(new FileReader("e:\\Sort.dat"));		//BufferedReader object
			PrintWriter printWriterObj = new PrintWriter("e:\\Sorted.dat");					//PrintWriter object

			while ((line = bufferedObj.readLine()) != null) {						//While loop to read all the data into the array
				sortArray[count] = Integer.parseInt(line.trim());					//Reads in
				count++;
			}//End while()
			
			sortArray = BubbleSort(sortArray, count, order);						//Runs the method called BubbleSort
			
			for(int x = 0; x < count; x++) {								//For loop to print array to new file
				printWriterObj.println(sortArray[x]);							//Prints to new file
			}//End for()
			
			bufferedObj.close();										//Closes bufferedReader
			printWriterObj.close();										//Closes printWriter
		} catch (IOException error) { 										//Catches any errors
			System.out.println("You have a error: " + error); 						//Prints out any errors that are caught
		}//End try and catch()
	}//End main()

	
/*****************************************************************
** Name:        BubbleSort()					**
** Input:       int sortArray[], int count, int direction	**
** Output:      int[]				 		**
** Description: This method will sort the values of the 	**
**		array then return the sorted array.		**
******************************************************************/	
	public static int[] BubbleSort(int sortArray[], int count, int direction) {
		int temp;												//Variable temp as a placeholder variable
		boolean swapped;											//Swapped variable to see if the array still needs to be swapped 
		for (int i = 0; i < count - 1; i++) {									//For loop to sort the numbers
			swapped = false;										//Set swapped variable to false
			for (int j = 0; j < count - i - 1; j++) {			
				if (sortArray[j] > sortArray[j + 1] && direction == 0) {				//Test to see which number is bigger
					temp = sortArray[j];								//Set temp equal to first element
					sortArray[j] = sortArray[j + 1];						//swap if necessary
					sortArray[j + 1] = temp;							//swap if necessary
					swapped = true;									//Set swapped variable to true
				}//End if()
				if(sortArray[j] < sortArray[j + 1] && direction == 1) {					//Test to see which number is smaller
					temp = sortArray[j];								//Set temp equal to first element
					sortArray[j] = sortArray[j + 1];						//swap if necessary
					sortArray[j + 1] = temp;							//swap if necessary
					swapped = true;									//Set swapped variable to true
				}//Ends if()
			}//End for()
			if (swapped == false) {										//If swapped variable is false
				break;											//Break the loops because the swapping is done
			}//End if()
		}//End for()
		return sortArray;											//Return the sortArray
	}//End BubbleSort()
}//End BubSort()
