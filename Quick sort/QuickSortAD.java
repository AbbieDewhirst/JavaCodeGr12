/*************************************************************
**															**
** Name:		Abbie Dyck									**
** Date:		November 14th, 2019							**
** Class Name:	QuickSortAD.java							**
** Description: This program takes a array of numbers from  **
**				file and then sort them either greatest to  **
**				least or vice versa.  It will also do a    	**
**				bubble sort, insertion sort, shell sort,	**
**				and quick sort and print a zeroed array,	**
**				unsorted array, and the sorted array.		**
**				It will also ask for a number, and print    **
**				what element the number is in the array		**
**				for both a binary and linear search.		**
**														    **
**************************************************************/
package package1;

import java.io.*;
import java.util.*;

public class QuickSortAD {

	public static void main(String[] args) {
		try {
			String line 				= null;																				//Variable line to read each line of data
			
			int sortArray[] 			= new int[10000];																	//sortArray with a max of 10000 elements 
			int sortedArray[]			= new int[10000];																	//sortedArray with a max of 10000 elements
			
			int count 					= 0;																				//Variable count to keep track of how many elements there are
			int order 					= 0;																				//Variable order to keep track of what order the values will be sorted in
			int numToSearch 			= 0;																				//Variable numToSearch to keep track of the number the user wants to search for

			BufferedReader bufferedObj 	= new BufferedReader(new FileReader("e:\\rndnumbers.txt"));							//BufferedReader object
			Scanner scannerObj 		   	= new Scanner(System.in);															//ScannerObj
			
			System.out.println("Please enter the number to search for: "); 													//Ask user to input a number
			numToSearch = scannerObj.nextInt(); 																			//Reads in user input to numToSearch
			System.out.print("\n");																							//New line

			
			while ((line = bufferedObj.readLine()) != null) {																//While loop to read all the data into the array
				sortArray[count] = Integer.parseInt(line.trim());															//Reads in
				count++;
			}//End while()
			System.out.println("BUBBLE SORT:");																				//Bubble sort title
			zero(sortedArray, count);																						//Runs the zero method
			equal(sortArray, sortedArray, count);																			//Runs the equal method
			sortedArray = BubbleSort(sortedArray, count, order);															//Runs the method called BubbleSort
			System.out.print("\n");																							//New line
			
			System.out.println("SEARCHES:");																				//Title for the searches
			int linearResult = LinearSearchTechniques(sortedArray, count, numToSearch);										//Runs the linearSearch
			int binaryResult = BinarySearch(sortedArray, count, numToSearch);												//Runs the BinarySearch
			
			//Print for linear search
			if(linearResult == -1) {																						//If it returns -1
				System.out.println("The number " + numToSearch + " is not in the array. (Linear Search)");					//Print that the element is not in the array
			}else {																											//Else
				System.out.println("The number " + numToSearch + " is at element " + linearResult + ". (Linear Search)");	//Print where the element is in the array
			}//End if()
			
			//Print for binary search
			if(binaryResult == -1) {																						//If it returns -1
				System.out.println("The number " + numToSearch + " is not in the array. (Binary Search)");					//Print that the element is not in the array
			}else {																											//Else
				System.out.println("The number " + numToSearch + " is at element " + binaryResult + ". (Binary Search)");	//Print where the element is in the array
			}//End if()
			System.out.print("\n");																							//New line

			System.out.println("INSERTION SORT:");																			//Insertion sort title
			zero(sortedArray, count);																						//Runs the zero method
			equal(sortArray, sortedArray, count);																			//Runs the equal method
			sortedArray = InsertionSort(sortedArray, count, order);															//Runs the method called InsertionSort
			System.out.print("\n");																							//New line
			
			System.out.println("SHELL SORT:");																				//Shell sort title
			zero(sortedArray, count);																						//Runs the zero method
			equal(sortArray, sortedArray, count);																			//Runs the equal method
			sortedArray 	= ShellSortMethod(sortedArray, count, order);													//Runs the method called ShellSort
			System.out.print("\n");																							//New line

			System.out.println("QUICK SORT:");																				//Quick sort title
			zero(sortedArray, count);																						//Runs the zero method
			equal(sortArray, sortedArray, count);																			//Runs the equal method
			sortedArray	= quickSort(sortedArray, 0, count -1, count, order);												//Rund the method called quickSort
			
			bufferedObj.close();																							//Closes bufferedReader
			scannerObj.close();																								//Closes scannerObj
			
		} catch (IOException error) { 																						//Catches any errors
			System.out.println("You have a error: " + error); 																//Prints out any errors that are caught
		}//End try and catch()
	}//End main()

	
/*************************************************************
** Name:        BubbleSort()								**
** Input:       int sortArray[], int count, int direction	**
** Output:      int[]								 		**
** Description: This method will sort the values of the 	**
**		        array then return the sorted array.			**
**************************************************************/	
	public static int[] BubbleSort(int bubbleArray[], int count, int order) {
		long startTime = System.currentTimeMillis();													//Starts the timer
		int temp;																						//Variable temp as a placeholder variable
		boolean swapped;																				//Swapped variable to see if the array still needs to be swapped 
		for (int i = 0; i < count - 1; i++) {															//For loop to sort the numbers
			swapped = false;																			//Set swapped variable to false
			for (int j = 0; j < count - i - 1; j++) {			
				if (bubbleArray[j] > bubbleArray[j + 1] && order == 0) {								//Test to see which number is bigger
					temp = bubbleArray[j];																//Set temp equal to first element
					bubbleArray[j] = bubbleArray[j + 1];												//swap if necessary
					bubbleArray[j + 1] = temp;															//swap if necessary
					swapped = true;																		//Set swapped variable to true
				}//End if()
				if(bubbleArray[j] < bubbleArray[j + 1] && order == 1) {									//Test to see which number is smaller
					temp = bubbleArray[j];																//Set temp equal to first element
					bubbleArray[j] = bubbleArray[j + 1];												//swap if necessary
					bubbleArray[j + 1] = temp;															//swap if necessary
					swapped = true;																		//Set swapped variable to true
				}//Ends if()
			}//End for()
			if (swapped == false) {																		//If swapped variable is false
				break;																					//Break the loops because the swapping is done
			}//End if()
		}//End for()
		long endTime = System.currentTimeMillis();														//Gets the end time
		long totalTime = endTime - startTime;															//Finds the total time
		System.out.println("Bubble sort print:");														//Prints the title for the bubble sort
		print(bubbleArray, count);																		//Runs the print method to print the arrray
		System.out.println("The total time taken by BubbleSort is " + totalTime + " miliseconds");		//Prints the total time for the sort to run
		return bubbleArray;																				//Return the sortArray
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
	public static int[] InsertionSort(int insertionSort[], int count, int order) {
		long startTime = System.currentTimeMillis();														//Starts the timer
		if(order == 0) {																					//If order is 0
			for (int i = 1; i < count; i++) { 																//For loop to sort the data
				int key = insertionSort[i]; 																//int key to hold a element of the array
				int j = i - 1; 																				//switches the element
				while (j >= 0 && insertionSort[j] > key) { 													//While loop to sort through the whole array
					insertionSort[j + 1] = insertionSort[j]; 												//Sorts the array
					j = j - 1; 																				//Sorts the array
				}//End while()
				insertionSort[j + 1] = key; 																//Sorts the array
			}//End for()
		} else {																							//Else (its 1)
			for (int i = 1; i < count; i++) { 																//For loop to sort the data
				int key = insertionSort[i]; 																//int key to hold a element of the array
				int j = i - 1; 																				//switches the element
				while (j >= 0 && insertionSort[j] < key) { 													//While loop to sort through the whole array
					insertionSort[j + 1] = insertionSort[j]; 												//Sorts the array
					j = j - 1; 																				//Sorts the array
				}//End while()
				insertionSort[j + 1] = key; 																//Sorts the array
			}//End for()
		}//End if()
		long endTime = System.currentTimeMillis();															//Finds the end time
		long totalTime = endTime - startTime;																//Finds the total time taken
		System.out.println("Insertion Sort Print:");														//Prints that the print below is for the insertion sort
		print(insertionSort, count);																		//Prints the array out using the print method
		System.out.println("The total time taken by InsertionSort is " + totalTime + " miliseconds");		//Prints the time taken for the sort
        return insertionSort;																				//Returns the sorted array
	}//End InsertionSort()
	
/*************************************************************
** Name:        ShellSortMethod()							**
** Input:       int sortArray[], int count  				**
** Output:      int[]    							 		**
** Description: This method will sort the data, and print	**
**				the sorted array out.						**
**************************************************************/	
	public static int[] ShellSortMethod(int shellArray[], int count,int order) {
		long startTime = System.currentTimeMillis();														//Finds the start time
		if(order == 0) {																					//If order is 0
			for (int gap = count/2; gap > 0; gap /= 2){ 													//Finds the gap in the array
				for (int i = gap; i < count; i += 1){ 														//Counts one to the right of the gap
                	int temp = shellArray[i]; 																//Stored the element in a temp variable
                	int j; 																					//Local variable j for the for loop
                	for (j = i; j >= gap && shellArray[j - gap] > temp; j -= gap) { 						//Counts one to the left of the gap
                		shellArray[j] = shellArray[j - gap];												//Switches the elements
                	}//End for()
                	shellArray[j] = temp; 																	//Switches if necessary
            	}//End for()
        	}//End for()
		} else {																							//Else (order is 1)
			for (int gap = count/2; gap > 0; gap /= 2){ 													//Finds the gap in the array
				for (int i = gap; i < count; i += 1){ 														//Counts one to the right of the gap
                	int temp = shellArray[i]; 																//Stored the element in a temp variable
                	int j; 																					//Local variable j for the for loop
                	for (j = i; j >= gap && shellArray[j - gap] < temp; j -= gap) { 						//Counts one to the left of the gap
                		shellArray[j] = shellArray[j - gap];												//Switches the elements
                	}//End for()
                	shellArray[j] = temp; 																	//Switches if necessary
            	}//End for()
        	}//End for()	
		}//End if()
		long endTime = System.currentTimeMillis();															//Finds the end time
		long totalTime = endTime - startTime;																//Finds the total time
		System.out.println("Shell Sort Print:");															//Prints that the print below is for the insertion sort
		print(shellArray, count);																			//Prints out the array
		System.out.println("The total time taken by ShellSort is " + totalTime + " miliseconds");			//Prints out the total time taken
        return shellArray; 																					//Returns the array
    }//End ShellSortMethod	

/*************************************************************
** Name:        partition()									**
** Input:       int sortArray[], int count  				**
** Output:      int[]    							 		**
** Description: This method will sort the data, and print	**
**				the sorted array out.						**
**************************************************************/	
	public static int partition(int resetArray[], int low, int high, int order) {
		int pivot = resetArray[high];																		//Sets the pivot
		int i = (low - 1);																					//Sets i = low-1
		for(int j = low; j<= high - 1; j++) {																//For j<= high
			if(order == 0) {																				//If order is 0
				if(resetArray[j] <= pivot) {																//If the element is <= pivot
					i++;																					//i plus 1
					int temp = resetArray[i];																//Make the temp variable equal to the element[i]
					resetArray[i] = resetArray[j];															//Makes element[i] equal to element[j]
					resetArray[j] = temp;																	//Makes element[j] equal to the temp variable
				}//End if()
			} else {																						//Else (order is 1)
				if(resetArray[j] >= pivot) {																//If the element is >= pivot
					i++;																					//i plus 1
					int temp = resetArray[i];																//Make the temp variable equal to the element[i]
					resetArray[i] = resetArray[j];															//Makes element[i] equal to element[j]
					resetArray[j] = temp;																	//Makes element[j] equal to the temp variable
				}//End if()
			}//End if()
		}//End for()
		int temp = resetArray[i+1];																			//Make the temp variable equal to element[i + 1]
		resetArray[i+1] = resetArray[high];																	//Element[ i+1 ] equal top element[high]
		resetArray[high] = temp;																			//Element[high] equal to temp variable
		return i+1;	
	}//End partition()
	
/*****************************************************************************************
** Name:        quickSort()																**
** Input:       int quickArray[], int low, int high, int count, int order  				**
** Output:      int[]    							 									**
** Description: This method will sort the data, and print the sorted array out.			**
******************************************************************************************/	
	public static int [] quickSort(int quickArray[], int low, int high, int count, int order) {
		long startTime = System.currentTimeMillis();														//Start the timer
		int [] stack = new int[high - 1 + 1];																//Array stack equal to [high - 1 + 1]
		int top = -1;																						//Variable top equal to -1
		stack[++top] = low;																					//array[++top] equal to low variable
		stack[++top] = high;																				//array[++top] equal to high variable
		
		while(top >= 0) {																					//While top >= 0
			high = stack[top--];																			//Make high equal to array[top--]
			low = stack[top--];																				//Make low equal to array[top--]
			int p = partition(quickArray, low, high, order);												//Runs the partition method
			
			if(p - 1 > low) {																				//If p-1 is greater than low
				stack[++top] = low;																			//array[++top] equal to low variable																		
				stack[++top] = p - 1;																		//array[++top] equal to p - 1
			}//End if()
			if(p + 1 < high) {																				//If p-1 is greater than high
				stack[++top] = p + 1;																		//array[++top] equal to p + 1
				stack[++top] = high;																		//array[++top] equal to high variable
			}//End if()
		}//End while()
		long endTime = System.currentTimeMillis();															//Finds the end time
		long totalTime = endTime - startTime;																//Finds the total time
		System.out.println("Quick Sort Print:");															//Prints that the print below is for the insertion sort
		print(quickArray, count);																			//Runs the print method
		System.out.println("The total time taken by quickSort is " + totalTime + " miliseconds");			//Prints out the total time
		return quickArray;																					//Returns the array
	}//End quickSort()
	
/*************************************************************
** Name:        print()										**
** Input:       int[] arr, int count  						**
** Output:      void    							 		**
** Description: This method will print out the arrays.		**
**************************************************************/	
	public static void print (int[] arr, int count) {
		System.out.print("[");																				//Prints out a bracket
		for (int i = 0; i < count && i < 100; i++) {														//For loop to print out the first 100 elements
			System.out.print(arr[i]);																		//Prints out the elements
			if (i != count-1 && i != 99) {																	//For every element but the last
				System.out.print(",");																		//Print a ,
			}//End if()
		}//End for()
		System.out.print("]\n");																			//Print out a end bracket at the end of printing everything out
	}//End print()
	
/*************************************************************
** Name:        equal()										**
** Input:       int arr1[], int arr2[], int count  			**
** Output:      void    							 		**
** Description: This method will make arr1 equal to arr2	**
**************************************************************/	
	public static void equal(int arr1[], int arr2[], int count) {
		for(int x = 0; x < count; x++) {																	//For every element in the array
				arr2[x] = arr1[x];																			//Makes array 2 equal to array 1																	
			}//End while()
		System.out.println("Unsorted array:");																//Prints out the title for the unsorted array
			print(arr2, count);																				//Prints out the array
	}//End equal()
	
/*************************************************************
** Name:        zero()										**
** Input:       int arr[], int count		  				**
** Output:      void    							 		**
** Description: This method will zero out the array			**
**************************************************************/	
	public static void zero(int arr[], int count) {
		for(int x = 0; x < count; x++) {																	//For every element in the array
			arr[x] = 0;																						//Zero the array out
		}//End while()
		System.out.println("Zeroed array:");																//Print the title
		print(arr, count);																					//Print the zeroed array
	}//End zero()
}//End BubSort()
