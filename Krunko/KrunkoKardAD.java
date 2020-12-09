/*****************************************************************
**								**
** Name:	Abbie Dyck					**
** Date:	December 16th, 2019				**
** Class Name:	KrunkoKardAD.java				**
** Description: This program reads in player one cards frpm	**
**		a file, and determins player two cards. It 	**
**		then will form the most ideal strategy to	**
**		play the game, and will play its cards		**
**		based off of that. It will print out the	**
**		cards that are left after each turn, and	**
**		Will print the number of games player one	**
**		won at the end of each game.			**
**								**
******************************************************************/
package package1;

import java.io.*;
import java.util.*;

public class KrunkoKardAD {

	static final char[] Colours = {'R','Y','G','B'};//Colours of the cards as a global variable
	
	public static void main(String[] args) {
		try {
			BufferedReader bufferedObj = new BufferedReader(new FileReader("/Volumes/ABBIE/krunkoInput.txt"));//Opens in the file
			String stringVar = bufferedObj.readLine();//Reads in the first line
			
			List<Integer> playerOne = new ArrayList<Integer>();//Player one list
			List<Integer> playerTwo = new ArrayList<Integer>();//Player two list
			int win = 1;//Win variable
			int totalScore = 0;//TotalScore variable
			int[] cards = new int [2];//Cards variable
			int[] position = new int [2];//Position variable
			
			while(!stringVar.contains("*")) {//While stringVar is not *
				String h[] = stringVar.split(" ", 10);//Splits the words at the spaces
				for (int x = 0; x < 10; x++) {//For loop
					for (int y = 0; y < 4; y++) {//For loop
						if (h[x].charAt(0) == Colours[y]) {//If loop to go through the colours
							playerOne.add(y*10 + Character.getNumericValue(h[x].charAt(1)));//Getting player one cards
						}//End if()
					}//End for()
				}//End for()
				win = 1;//Makes win equal to 1
				playerTwo = getPlayer2Deck(playerOne);//Goes to player2Deck method
				for(int x = 0; x < 10; x++) {//For loop
					printCards(playerOne,playerTwo);//Prints out the cards that were played
					if (win == 1) {//If win is 1
						position[0] = leadCard(playerOne,playerTwo);//Position equal to lead method
						cards[0] = playerOne.get(position[0]) % 10;//Cards equal to playerOne mod 10
						
						position[1] = defencePlay(playerTwo,playerOne,position[0]);//Position equal to defence method
						cards[1] = playerTwo.get(position[1]) % 10;//Cards equal to playerTwo mod 10
					
						System.out.print("P1 lead play: " + Colours[(int) Math.floor(playerOne.get(position[0])/10)] + playerOne.get(position[0]) % 10 +"   ");//Prints playerOne lead cards
						System.out.print("P2 defence play: " + Colours[(int) Math.floor(playerTwo.get(position[1])/10)] + playerTwo.get(position[1]) % 10 +"   ");//Prints out playerTwo def cards
					
					} else {
						position [1] = leadCard(playerTwo,playerOne);//Position equal to lead method
						cards[1] =  playerTwo.get(position[1]) % 10;//Cards equal to playerOne mod 10
						
						position [0] = defencePlay(playerOne,playerTwo, position[1]);//Position equal to defence method
						cards[0] = playerOne.get(position[0]) % 10;//Cards equal to playerTwo mod 10
						
						System.out.print("P2 lead play: " + Colours[(int) Math.floor(playerTwo.get(position[1])/10)] + playerTwo.get(position[1]) % 10 +"   ");//Prints playerTwo lead cards
						System.out.print("P1 defence play: " + Colours[(int) Math.floor(playerOne.get(position[0])/10)] + playerOne.get(position[0]) % 10 +"   ");//Prints out playerTwo def cards
					
					}//End else()
					System.out.println();//Prints a blank line
					
					if (win == 1) {//If win is one
						if (Math.floor(playerOne.get(position[0])/10) != Math.floor(playerTwo.get(position[1])/10)) {//And if the two arent eequal
							totalScore++;//Add one to score
						}else if (Math.floor(playerOne.get(position[0])/10) == Math.floor(playerTwo.get(position[1])/10) && cards[0] > cards[1]) {//Else if they are equal and cards[0] > cards[1]
							totalScore++;//Add one to score
						} else {//Else
							win = 2;//Make win equal to 2
						}//End else()
					} else {//Else
							if(cards[1] < cards[0] && Math.floor(playerOne.get(position[0])/10) == Math.floor(playerTwo.get(position[1])/10)) {
								totalScore++;//Add one to score
								win = 1;//Make win equal to one
						}
					}//End if()
					playerOne.remove(position[0]);//remove playerOne position[0]
					playerTwo.remove(position[1]);//remove playerTwo position[1]
				}//End for()
				System.out.println("The total score for this game is: " + totalScore);//Print the total score
				totalScore = 0;//Make totalScore equal to zero
				stringVar = bufferedObj.readLine();//Read the next line
			}//End while()
			bufferedObj.close();//Closes bufferedObj
		} catch (IOException error) {
			System.out.println("You have a error: " + error);//Prints out any errors that are caught
		}//End catch()
	}//close main()
	
	/*****************************************************************
	** Name:        leadCard()					**
	** Input:       List<Integer> turn, List<Integer> opp		**
	** Output:      y or x				 		**
	** Description: This method will find the best card to lead	**
	**		the game with.					**
	******************************************************************/	
	private static int leadCard(List<Integer> turn, List<Integer> opp) {
		int[][]colour  = new int [2][4];//Array for cards
		colour = getCard(colour, turn, opp);//runs the getCard method
		for(int x = 0; x <4; x++) {//For loop
			if(colour[1][x] == 0 && colour[0][x]>0) {//If
				for (int y = 0; y < turn.size(); y++) {//For
					if(Math.floor(turn.get(y)/10) == x) {//If
						return y;//Returns y
					}//Closes if()
				}//Close for()
			} //Close if()
		}//Close for()
		
		for (int x = 0; x < turn.size(); x++ ) {//For
			boolean test = true;//Bool test
			for (int y = 0; y < opp.size(); y++) {//For
				boolean match = (Math.floor(opp.get(y)/10) == Math.floor(turn.get(x)/10));//Match equal to Math.floor(opp.get(y)/10) == Math.floor(turn.get(x)/10)
				if (match && opp.get(y) % 10 > turn.get(x) % 10) {//If
					test = false;//Make test equal to false
				}//Close if()
			} //Close for()
			if (test) {//If true
				return x;//Return x
			}//Close if()
		}//close for()
		return losingTurn(turn, opp);//return losing method
	}//Close leadCard()

	/*****************************************************************
	** Name:        getPlayer2Deck()				**
	** Input:       List<Integer> a					**
	** Output:      h			 			**
	** Description: This method will find player two deck.		**
	******************************************************************/	
	private static List<Integer> getPlayer2Deck(List<Integer> a) {
		int[][] card = new int[4][5];//card array
		List <Integer> h = new ArrayList<Integer>();//List h
		for (int x = 0; x < 10; x++) {//For
			card[((int) Math.floor(a.get(x)/10))][(a.get(x) % 10 - 1)] = 1;
		} // close for
		for(int x = 0; x < 4; x ++) {//For
			for(int y = 0; y < 5; y++ ) {//For
				if (card[x][y] != 1) {//If
					h.add(x*10 + y + 1);//h.add x*10 + y + 1
				}//Close if()
			}//Close for()
		}//Close for()
		return h;//Returns h
	}//Close getPlayer2Deck()

	/*****************************************************************
	** Name:        getPlayergetCard2Deck()				**
	** Input:       int[][] i, List<Integer> ii, List<Integer> iii	**
	** Output:      i						**
	** Description: This method will get the cards.			**
	******************************************************************/	
	private static int[][] getCard(int[][] i, List<Integer> ii, List<Integer> iii) {
		for (int x = 0; x < ii.size(); x++) {//For loop
			i[0][(int) Math.floor(ii.get(x)/10) ]++;//Finds the floor for ii
			i[1][(int) Math.floor(iii.get(x)/10) ]++;//Finds teh floor for iii
		}//Close for()
		return i; //Returns i
	}//Close getCard()

	/*****************************************************************
	** Name:        losingTurn()					**
	** Input:       List<Integer> i, List<Integer> ii		**
	** Output:      choice			 			**
	** Description: This method play the most logical card on the	**
	**		players losing turn.				**
	******************************************************************/
	private static int losingTurn(List<Integer> i, List<Integer> ii) {
		int choice = -1;//Make choice equal to -1
		int decision = 0;//Decision equal to 0
		int s = 10;//Make s (small) equal to 10
		int large = -1;//make large equal tp -1
		int[][] handColour = new int[2][4];
		getCard(handColour, i, ii );
		
		for(int x =0; x < 4; x++) {//For
			if(handColour[0][x]>large) {//If
				large = handColour[0][x];//Make large equal to handColour[0][x]
				decision = x;//Decision equal to x
			} else if (handColour[0][x] == large){//Else
				if(handColour[1][decision] > handColour[1][x]) {//If
					decision = x;//Decision equal to x
				}//Close if()
			}//CLose if()
		}//Close for()
		for(int x = 0; x < i.size(); x++) {//For
			if(i.get(x) % 10 < s && Math.floor(i.get(x)/10) == decision) {//If
				s = i.get(x) % 10;//Make s equal to i.get(x) % 10
				choice = x;//Make choice equal to x
			}//Close if()
		}//Close for()
		return choice;//return choice
	}//Close losingTurn()

	/*****************************************************************
	** Name:        defencePlay()					**
	** Input:       List<Integer> a, List<Integer> b, int i		**
	** Output:      c						**
	** Description: This method play the most logical defense card	**
	**		on their turn.					**
	******************************************************************/
	private static int defencePlay(List<Integer> a, List<Integer> b, int i) {
		int c = -1;//C equal to -1
		int small = 10;//Small equal to 10
		for (int x = 0; x < a.size(); x++) {//For
			if(Math.floor(a.get(x)/10) == Math.floor(b.get(i)/10)) {//If
				if(a.get(x) % 10 > b.get(i) % 10) {//If
					c = x;//Make c equal to x
					for(int y = x; y < a.size(); y++) {//For
						if(Math.floor(a.get(y)/10) == Math.floor(b.get(i)/10)) {//For
							if(a.get(y) % 10 < a.get(c) % 10 && a.get(y) % 10 > b.get(i) % 10) {//If
								c = y;//Make c equal to y
							}//Close if()
						}//Close if()
					}//Close for()
					break;//Break
				} else {//Else
					if(a.get(x) % 10 < small) {//If
						small = a.get(x) % 10;//Make small equal to a.get(x) % 10
						c = x;//Make c equal to v
					}//Close if()
				}//Close if()
			}//Close if()
		}//Close for()
		if (c == -1) {//If c is equal to -1
			c = losingTurn(a, b);//Make c = losing turn method
		}//Close if()
		return c;//Return c
	}//Close defencePlay()
	
	/*****************************************************************
	** Name:        printCards()					**
	** Input:       List<Integer> P1, List<Integer> P2		**
	** Output:      void			 			**
	** Description: This method will print out the cards.		**
	******************************************************************/
	private static void printCards(List<Integer> P1, List<Integer> P2) {
		for (int y = 0; y < P1.size(); y++) {//For the size of p1 list
			System.out.print("" + Colours[(int) Math.floor(P1.get(y)/10)] + P1.get(y) % 10 +"   ");//Print the list
		}//Close for()
		System.out.println();//Blank line
		for (int y = 0; y < P2.size(); y++) {//For the size of p2 list
			System.out.print("" + Colours[(int) Math.floor(P2.get(y)/10)] + P2.get(y) % 10+ "   ");//Print the list
		}//Close for()
		System.out.println();//Blank line
	}//Close printCards()
}//End KrunkoKardAD
