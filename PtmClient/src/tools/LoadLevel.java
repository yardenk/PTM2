package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class LoadLevel {
	public static char[][] loadNewLevel(File f) throws FileNotFoundException{
		int rows = getRowNumber(f);
		int cols = getColNumber(f);
		
		
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = null ; 
		try {
			line = reader.readLine();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		char level[][] = new char[rows][cols]; 
		
		while (line != null) {
			
			for (int i=0;i<rows;i++) {
				for (int j = 0 ;j<cols; j++) {
					level[i][j] = line.charAt(j); 
				}
				System.out.println("");

				try {
					line = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return level; 
			
	}
		

	private static int getRowNumber(File file) throws FileNotFoundException
	{
	
			 BufferedReader reader = new BufferedReader(new FileReader(file));
			 int count = 0;
			 try {
				while (reader.readLine() != null) 
				 {
				   count++;
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return count;
		
	}
	private static int getColNumber(File file) throws FileNotFoundException
	{
	
			 BufferedReader reader = new BufferedReader(new FileReader(file));
			 try {
				String line = reader.readLine(); 
				if (line!=null)
					return line.length(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return 0;
		
	}
	
}
