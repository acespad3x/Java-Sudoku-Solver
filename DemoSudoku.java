//import java.io.*;                          

// 2D Arrays and string manipulation
// Below are some methods that can be used to implement 
// the Sudoku elimination method
// ---------------------------------------------------
 
public class DemoSudoku {
	public static int size = 9;					// size of board, i.e. 9 x 9
	String[][] board = new String[size][size];	// declares a 9 x 9 string array
	String stringWithAllDigits = "123456789";	// stores all 9 digits as a string
	String[][] tempA = new String[3][3];		// temporary array 2D stores 3by3Rigions

	public void initializeBoard()
	{	for (int r=0; r<size; r++)
		{	for (int c=0; c<size; c++)
			{	board[r][c] = stringWithAllDigits; // store all 9 digits in each square
			}
		}
		// Store single digits as given in board that must be solved
		//board 1
		/*board[0][1] = "6"; board[0][3] = "1"; board[0][5] = "4"; board[0][7] = "5"; board[1][2] = "8";
		board[1][3] = "3"; board[1][5] = "5"; board[1][6] = "6"; board[2][0] = "2"; board[2][8] = "1";
		board[3][0] = "8"; board[3][3] = "4"; board[3][5] = "7"; board[3][8] = "6"; board[4][2] = "6"; 
		board[4][6] = "3"; board[5][0] = "7"; board[5][3] = "9"; board[5][5] = "1"; board[5][8] = "4";
 		board[6][0] = "5"; board[6][8] = "2"; board[7][2] = "7"; board[7][3] = "2"; board[7][5] = "6"; 
		board[7][6] = "9"; board[8][1] = "4"; board[8][3] = "5"; board[8][5] = "8"; board[8][7] = "7";*/

		//board2
		board[0][0] = "7"; board[0][1] = "1"; board[1][2] = "9"; board[5][3] = "8"; board[7][5] = "4";
		board[1][0] = "8"; board[2][1] = "5"; board[2][2] = "2"; board[8][3] = "1"; board[8][5] = "3";
		board[3][0] = "5"; board[3][1] = "6"; board[4][2] = "1"; board[2][4] = "1"; board[3][6] = "8"; 
		board[0][5] = "8"; board[5][1] = "2"; board[5][2] = "3"; board[3][4] = "4"; board[4][6] = "7";
		board[3][5] = "1"; board[7][1] = "3"; board[1][3] = "2"; board[5][4] = "7"; board[6][6] = "1"; 
		board[7][0] = "1"; board[6][5] = "5"; board[2][3] = "4"; board[6][4] = "8"; board[7][6] = "9";
		board[1][7] = "1"; board[3][7] = "3"; board[5][7] = "4"; board[8][7] = "5"; board[8][8] = "4";
		board[7][8] = "8"; board[5][8] = "1"; board[1][8] = "5"; board[0][3] = "3"; board[6][7] = "7";
	
		
		//board3
		
		/*board[0][1] = "4";  board[0][5] = "5";  board[1][2] = "6";
		 board[1][5] = "1";  board[2][0] = "1"; board[2][2] = "3";
		 board[3][3] = "3"; board[3][5] = "2";  board[4][0] = "3"; 
		board[4][3] = "1"; board[5][0] = "6"; board[5][4] = "2"; */
		
	//	/*board[0][0] = "6";*/ board[0][1] = "2";/*board[0][2] = "4"; board[0][3] = "5"; board[0][4] = "8"; board[0][5] = "5"; board[0][6] = "5"; board[0][7] = "5"; board[0][8] = "4";*/
	//	board[1][0] = "9";/* board[1][1] = "1"; board[1][2] = "4";*/ board[1][3] = "3";/* board[1][4] = "8"; board[1][5] = "5"; board[1][6] = "5"; board[1][7] = "5"; board[1][8] = "4";*/
	//	board[2][0] = "5"; board[2][1] = "6"; /*board[2][2] = "4";*/ board[2][3] = "1"; board[2][4] = "9";/* board[2][5] = "5";*/ board[2][6] = "7";/* board[2][7] = "5";*/ board[2][8] = "8";
	//	board[3][0] = "7"; /*board[3][1] = "1";*/ /*board[3][2] = "4";*/ board[3][3] = "2"; board[3][4] = "3";/* board[3][5] = "5"; board[3][6] = "5";*/ board[3][7] = "1";/* board[3][8] = "4";*/
	//	board[4][0] = "4"; /*board[4][1] = "1";*/ /*board[4][2] = "4";*/ board[4][3] = "7";/* board[4][4] = "8";*/ board[4][5] = "8";/* board[4][6] = "5"; board[4][7] = "5";*/ board[4][8] = "9";
	//	/*board[5][0] = "6";*/board[5][1] = "5"; /*board[5][2] = "4";*/ /*board[5][3] = "5";*/ board[5][4] = "4"; board[5][5] = "1";/* board[5][6] = "5"; board[5][7] = "5";*/ board[5][8] = "7";
	//	board[6][0] = "8"; /*board[6][1] = "1";*/ board[6][2] = "7";/* board[6][3] = "5";8*/ board[6][4] = "1"; board[6][5] = "3";/* board[6][6] = "5";*/ board[6][7] = "6"; board[6][8] = "2";
	//	/*board[7][0] = "6"; board[7][1] = "1"; board[7][2] = "4"; board[7][3] = "5"; board[7][4] = "8";*/ board[7][5] = "4";/* board[7][6] = "5"; board[7][7] = "5";*/ board[7][8] = "5";
	//	/*board[8][0] = "6"; board[8][1] = "1"; board[8][2] = "4"; board[8][3] = "5"; board[8][4] = "8"; board[8][5] = "5"; board[8][6] = "5";*/ board[8][7] = "4";/* board[8][8] = "4";*/
		
	
	}

	// Accessors
	// ---------
	public String[] getRow(int r)	    // retrieves row r from 2D-array
	{	String[] arr = new String[size];
		for (int col = 0;  col < size; col++)
			arr[col] = board[r][col];
		return arr;
	} 

	public String[] getColumn(int c)	// retrieves column c from 2D-array
	{	String[] arr = new String[size];
		for (int row = 0;  row < size; row++)
			arr[row] = board[row][c];
		return arr;
	} 

	public String[][] get3by3Region(int r, int c)	// retrieves 3x3 grid that contains element arr[r][c]
	{	String[][] arr = new String[3][3];        // and stores it in a 2D array
		int topRow = 3 * (r / 3);		// determines the top row of the 3x3 region
		int leftCol = 3 * ( c / 3);		// determines the left most column of the 3x3 region
		
		for (int row = topRow, row2 = 0;  row < topRow+3; row++,row2++){
			for (int col = leftCol, col2 = 0;  col < leftCol+3; col++,col2++){
				arr[row2][col2] = board[row][col];
			}
		}
		return arr;
	} 
	
	
	public void set3by3Region(int r, int c)
	{	String[][] arr = tempA;
		int topRow = 3 * (r / 3);		
		int leftCol = 3 * ( c / 3);		
		for (int row = topRow, row2 = 0;  row < topRow+3; row++,row2++){
			for (int col = leftCol, col2 = 0;  col < leftCol+3; col++,col2++){
				board[row][col] = arr[row2][col2];
			}
		}
	} 
	
	
	public void removeFrom3by3Region(int rows, int columns){
		int row = rows, col = columns;
		String tempArr[][];
			tempArr = get3by3Region(row, col);
			System.out.printf("Removing Occurances in 3by3 grid at location row: %d and col: %d\n", row , col);
			for(int r = 0; r < tempArr.length; r++){
				for(int c = 0; c < tempArr.length; c++){
					if(tempArr[r][c].length() == 1){
						String dgt = tempArr[r][c];
						for(int r2 = 0; r2 < tempArr.length; r2++){
							for(int c2 = 0; c2 < tempArr[r2].length; c2++){
								String astring = removeDigitFromStringOfLength2orMore(dgt, tempArr[r2][c2]);
								tempArr[r2][c2] = astring;
								tempA = tempArr;
								set3by3Region(row,col);
							}
						}
					}
				}
			}
			
	}
	
	public void do3by3Regions(){
        removeFrom3by3Region(0,0);
        removeFrom3by3Region(0,3);
        removeFrom3by3Region(0,6);
        removeFrom3by3Region(3,0);
        removeFrom3by3Region(3,3);
        removeFrom3by3Region(3,6);
        removeFrom3by3Region(6,0);
        removeFrom3by3Region(6,3);
        removeFrom3by3Region(6,6);
	}
	
	public void doTry(int n){
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board.length; col++){
				if(board[row][0].length() == 2 ){
					if(n == 1){
						board[row][0] = board[row][0].substring(n);
					}else if(n == 0){
						board[row][0] = board[row][0].substring(0,1);
					}
				}
			}
		}
	}
	
	public boolean doCheck(){
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board.length; col++){
				if(board[row][col].length() > 1){
					return true;
				}
			}
		}
		return false;
	}
	// ------------------------------------------------

	// Mutators
	// --------

	public void setRow(int r, String[] arr)	    // stores string array arr back in row r of 2D-array board
	{	for (int col = 0;  col < arr.length; col++)
			board[r][col] = arr[col];		
	} 

	public void setColumn(int c, String[] arr)	// stores string array arr in column c of 2D-array board
	{	for (int row = 0;  row < arr.length; row++)
			board[row][c] = arr[row];		
	} 

	// ------------------------------------------------

	public void removeDigitFromRowR(String dgt, int r)	// removes the string dgt (of length 1) from all
	{	String[] tmpArr;								// string entries (of length 2 and longer) in row r
		tmpArr = getRow(r);								// copies row r from board to tmpArr
		for (int c=0; c<tmpArr.length; c++)
		{	String aStrng = tmpArr[c];		// copies string at index c from string array tmpArr
			tmpArr[c] = removeDigitFromStringOfLength2orMore(dgt, aStrng);
		} 
		setRow(r, tmpArr);                  // stores array tmpArr in row r of 2D-array board
	}

	public void removeDigitFromColumnC(String dgt, int c) // removes the string dgt (of length 1) from 
	{	String[] tmpArr;								// all string entries (of length 2 and longer) in column c
		tmpArr = getColumn(c);							// copies column c from board to tmpArr		
		for (int r=0; r<tmpArr.length; r++)
		{	String aStrng = tmpArr[r];		// copies string at index r from string array tmpArr 	 
			tmpArr[r] = removeDigitFromStringOfLength2orMore(dgt, aStrng); 
		} 
		setColumn(c, tmpArr);				// stores array tmpArr in column c of 2D-array board
	}

	public String removeDigitFromStringOfLength2orMore(String dgtStrng, String strng) // removes the string dgtStrng from String strng
	{	String aStrng = strng;							
		int indx = aStrng.indexOf(dgtStrng);	   // finds index of where digit (dgtStrng) occurs in string aStrng
		if ((indx >= 0) && (aStrng.length() >= 2)) // if digit occcurs and more than 2 digits in string then 
			aStrng = aStrng.substring(0,indx) + aStrng.substring(indx+1); // remove dgtStrng from aStrng			
		return aStrng;
	}

	public String constructLineNo(int lineNo, String strng)	// places the digits in a square in its correct position for printing
	{ 	String template = "123456789";		// e.g. "23" is stored as " 23" while "46" is stored as "4 6" and "78 as "78 "
		String line = "";					// initialize to null string
		String aBlank = " ";				// stores a space
		int strt = 3 * lineNo - 3;			// strt indicates the starting position of the 3 digit substring to be extracted from "123456789"
		for (int i = strt; i< strt+3; i++)	// for the first line "123" is used, "456" for the 2nd line and "789" for the third line
		{	String digt = template.substring(i,i+1);
			if (strng.indexOf(digt) != -1)	// display digt if it appears in string strng else do not display
				line = line + " " + digt;	// since digt is present in cell add it to the line to be displayed
			else
				line = line + " " + aBlank;	// else add a space 
		}
		return line;
	}

	public void displayBoard()				// displays contents of each cell of the board across three lines
	{										// as  123
											//     456
											//     789
		System.out.println("\t\t\t\t-------------------- TOP ------------------");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int r=0; r<size; r++)					
		{	
			String line1 = "\t\t| ";
			String line2 = "\t\t| ";
			String line3 = "\t\t| ";

			for (int c=0; c<size; c++)
			{	 line1 = line1 + constructLineNo(1, board[r][c])  + " |";
				 line2 = line2 + constructLineNo(2, board[r][c])  + " |";
				 line3 = line3 + constructLineNo(3, board[r][c])  + " |";
				 if (( c == 2) || ( c == 5))	// signals end of last column on 3x3 region
				 {	line1 = line1 + "| ";			
				 	line2 = line2 + "| ";	
				 	line3 = line3 + "| ";
				 }
			}
			System.out.println(line1);
			System.out.println(line2);
			System.out.println(line3);
			if (( r == 2) || ( r == 5))	 //  indicates the last row of a 3x3 region
				System.out.println("==========================================================================================================");
			else
				System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		System.out.println("\t\t\t\t----------------- BOTTOM  ----------------\n");
		System.out.println();
	}
	

	public void run(){	
		initializeBoard();
		displayBoard();
		int counter = 0;
		do{
		for(int row = 0 ; row < board.length; row++){
			for(int column = 0 ; column < board[row].length; column++){
				if(board[row][column].length() == 1){
					String digit = board[row][column];
					removeDigitFromRowR(digit, row);
					System.out.println("Removed "+board[row][column]+" from all other squares in ROW "+(row+1)+" of the board");
					removeDigitFromColumnC(digit, column);
					System.out.println("Removed "+board[row][column]+" from all other squares in COLUMN "+(column+1)+" of the board\n");
					
				}
			}
		}
		do3by3Regions();
		System.out.println("\n");
		counter++;
		}while(counter < size);
		
		
		do{
		for(int row = 0 ; row < board.length; row++){
			for(int column = 0 ; column < board[row].length; column++){
				if(board[row][column].length() == 1){
					String digit = board[row][column];
					removeDigitFromRowR(digit, row);
					System.out.println("Removed "+board[row][column]+" from all other squares in ROW "+(row+1)+" of the board");
					removeDigitFromColumnC(digit, column);
					System.out.println("Removed "+board[row][column]+" from all other squares in COLUMN "+(column+1)+" of the board\n");
					
				}
			}
			displayBoard();
			break;
		}
		do3by3Regions();
		System.out.println("\n");
		if(doCheck() == true ){
			doTry(1);
		}else{
			doTry(0);
		}
		}while(doCheck() == true);
		displayBoard();
	}

	public static void main(String args[])
    {
		DemoSudoku testerObjct = new DemoSudoku();	
		testerObjct.run();    
		 
    }
}

