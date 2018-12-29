package tools;

public class Rotate {
	
	public static char[][] switchIT (char[][] mazeDisplayer,int row, int col, int num ) {
		
		char tmpChar = mazeDisplayer[row][col];
		
		switch(tmpChar) {
		case 'L':
			if (num == 1) 
				mazeDisplayer[row][col] = 'F';
			else if (num == 2 )
				mazeDisplayer[row][col] = '7';
			else 
				mazeDisplayer[row][col] = 'J';
				
			break;
		case 'J':
			if (num == 1) 
				mazeDisplayer[row][col] = 'L';
			else if (num == 2 )
				mazeDisplayer[row][col] = 'F';
			else 
				mazeDisplayer[row][col] = '7';
			break;
		case '7':
			if (num == 1) 
				mazeDisplayer[row][col] = 'J';
			else if (num == 2 )
				mazeDisplayer[row][col] = 'L';
			else 
				mazeDisplayer[row][col] = 'F';
			break;
		case 'F':
			if (num == 1) 
				mazeDisplayer[row][col] = '7';
			else if (num == 2 )
				mazeDisplayer[row][col] = 'J';
			else 
				mazeDisplayer[row][col] = 'L';
			break;
		case '-':
			mazeDisplayer[row][col] = '|';
			break;
		case '|':
			mazeDisplayer[row][col] = '-';
			break;
		}
		
		return mazeDisplayer;
	}


}
