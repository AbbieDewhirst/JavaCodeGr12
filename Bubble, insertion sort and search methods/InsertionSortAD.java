/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		November 1st, 2019							**
** Class Name:	InsertionSort.java							**
** Description: This program takes a array of numbers from  **
**				file and then sort them either greatest to  **
**				least or vice versa, then prints to a file 	**
**				called sorted.dat. It will also do a    	**
**				insertion sort, and print the sorted array.	**
**				It will also ask for a number, and print    **
**				what element the number is in the array.	**
**														    **
**************************************************************/
package package1;


import java.io.*;
import java.util.*;

public class InsertionSortAD {

	public static void main(String[] args) {
		try {
			String line = null;																			//Variable line to read each line of data
			int sortArray[] = new int[5000];															//sortArray with a max of 500 elements 
			int insertonSortArray[] = new int[5000];
			int count = 0;																				//Variable count to keep track of how many elements there are
			int order = 0;																				//Variable order to keep track of what order the values will be sorted in
			int numToSearch = 0;
			
			BufferedReader bufferedObj = new BufferedReader(new FileReader("e:\\Sort.dat"));			//BufferedReader object
			PrintWriter printWriterObj = new PrintWriter("e:\\Sorted.dat");								//PrintWriter object
			Scanner scannerObj 		   = new Scanner(System.in);
			
			System.out.println("Please enter the number to search for: "); 								// Ask user to input a number
			numToSearch = scannerObj.nextInt(); 	
			
			while ((line = bufferedObj.readLine()) != null) {											//While loop to read all the data into the array
				sortArray[count] = Integer.parseInt(line.trim());										//Reads in
				count++;
			}//End while()
			
			sortArray = BubbleSort(sortArray, count, order);											//Runs the method called BubbleSort
			insertonSortArray = InsertionSort(sortArray, count);										//Runs the method called InsertionSort
			
			System.out.println("Insertion Sort Print:");												//Prints that the print below is for the insertion sort
			for(int x = 0; x < count; x++) {															//For loop to print array to new file
				System.out.println(insertonSortArray[x]);												//Prints the insertions sort array
				printWriterObj.println(sortArray[x]);													//Prints to new file
			}//End for()
			
			int linearResult = LinearSearchTechniques(sortArray, count, numToSearch);
			int binaryResult = BinarySearch(sortArray, count, numToSearch);
			
			//Print for linear search
			if(linearResult == -1) {
				System.out.println("The number " + numToSearch + " is not in the array. (Linear Search)");
			}else {
				System.out.println("The number " + numToSearch + " is at element " + linearResult + ". (Linear Search)");
			}//End if()
			
			//Print for binary search
			if(binaryResult == -1) {
				System.out.println("The number " + numToSearch + " is not in the array. (Binary Search)");
			}else {
				System.out.println("The number " + numToSearch + " is at element " + binaryResult + ". (Binary Search)");
			}//End if()
			
			bufferedObj.close();																		//Closes bufferedReader
			printWriterObj.close();																		//Closes printWriter
			scannerObj.close();
		} catch (IOException error) { 																	//Catches any errors
			System.out.println("You have a error: " + error); 											//Prints out any errors that are caught
		}//End try and catch()
	}//End main()

	
/*************************************************************
** Name:        BubbleSort()								**
** Input:       int sortArray[], int count, int direction	**
** Output:      int[]								 		**
** Description: This method will sort the values of the 	**
**		        array then return the sorted array.			**
**************************************************************/	
	public static int[] BubbleSort(int sortArray[], int count, int direction) {
		int temp;																						//Variable temp as a placeholder variable
		boolean swapped;																				//Swapped variable to see if the array still needs to be swapped 
		for (int i = 0; i < count - 1; i++) {															//For loop to sort the numbers
			swapped = false;																			//Set swapped variable to false
			for (int j = 0; j < count - i - 1; j++) {			
				if (sortArray[j] > sortArray[j + 1] && direction == 0) {								//Test to see which number is bigger
					temp = sortArray[j];																//Set temp equal to first element
					sortArray[j] = sortArray[j + 1];													//swap if necessary
					sortArray[j + 1] = temp;															//swap if necessary
					swapped = true;																		//Set swapped variable to true
				}//End if()
				if(sortArray[j] < sortArray[j + 1] && direction == 1) {									//Test to see which number is smaller
					temp = sortArray[j];																//Set temp equal to first element
					sortArray[j] = sortArray[j + 1];													//swap if necessary
					sortArray[j + 1] = temp;															//swap if necessary
					swapped = true;																		//Set swapped variable to true
				}//Ends if()
			}//End for()
			if (swapped == false) {																		//If swapped variable is false
				break;																					//Break the loops because the swapping is done
			}//End if()
		}//End for()
		return sortArray;																				//Return the sortArray
	}//End BubbleSort()
	
	
/*************************************************************
** Name:        LinearSearchTechniques()					**
** Input:       int sortArray[], int numOfEle, int findVal	**
** Output:      int    								 		**
** Description: This method will find the number in the  	**
**		        array and return the element number, or		**
**				return -1 if the number is not in the array.**
**************************************************************/	
	public static int LinearSearchTechniques(int sortArray[], int numOfEle, int findVal) {
		
		int n = sortArray.length; 																		//N is the array length									
	    for(int i = 0; i < n; i++){ 																	//For loop to find the number
	        if(sortArray[i] == findVal) {																//If the number is equal to the number you were looking for
	            return i; 																				//Return with the element number
	        }//End if() 
	    }//End for()
	    return -1; 																						//Return -1 (the number isnt in the array)
	}//End LinearSearchTechniques()
	
/*************************************************************
** Name:        BinarySearch()								**
** Input:       int sortArray[], int a, int b				**
** Output:      int    								 		**
** Description: This method will find the number in the  	**
**		        array and return the element number, or		**
**				return -1 if the number is not in the array.**
**************************************************************/	
	public static int BinarySearch(int sortArray[], int a, int b) {
		int min = 0;																					//Sets the min num to 0
		int max = a;																					//Sets the max equal to the numbers in the array
		while(min + 1 < max) {																			//Test to see which number is lower
			int test = (min + max)/2;																	//Makes test equal to the middle of the array
			if(sortArray[test] > b) {																	//If that number is less than the num you want to find
				max = test;																				//Make max equal to the test num
			}else {																						//Else
				min = test;																				//Make min equal to the text
			}//End if()
		}//End while()
		if(sortArray[min] == b) {																		//If min is equal to the number you were looking for
			return min;																					//Return that element number
		}else {																							//Else
			return -1;																					//Return -1 (its not in the array)
		}//End if()
	}//End BinarySearch()	
	
/*************************************************************
** Name:        InsertionSort()								**
** Input:       int sortArray[], int count  				**
** Output:      int[]    							 		**
** Description: This method will sort the data, and print	**
**				the sorted array out.						**
**************************************************************/	
	public static int[] InsertionSort(int sortArray[], int count) {
        for (int i = 1; i < count; i++) { 																//For loop to sort the data
            int key = sortArray[i]; 																	//int key to hold a element of the array
            int j = i - 1; 																				//switches the element
            while (j >= 0 && sortArray[j] > key) { 														//While loop to sort through the whole array
            	sortArray[j + 1] = sortArray[j]; 														//Sorts the array
                j = j - 1; 																				//Sorts the array
            }//End while()
            sortArray[j + 1] = key; 																	//Sorts the array
        }//End for()
        return sortArray;																				//Returns the sorted array
	}//End InsertionSort()		
}//End InsertionSortAD()
