package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable{
	char[][]mazeData = {
			{'s','L','F'},
			{'J','L','F'},
			{'g','L','F'},
		

			
			
	}; 

	
	@FXML
	MazeDisplayer mazeDisplayer ; 
	Theme t = new Theme("Dark");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setPipeGame(mazeData);	
	}
	
	private void setPipeGame(char [][] mazeData){

		//set data
		mazeDisplayer.setMazeData(mazeData,t);
		
		//set event listener (mouse event listener)
		mazeDisplayer.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				MouseEvent me = (MouseEvent) event;
				double w = mazeDisplayer.getWidth() / mazeData[0].length; 
				double h = mazeDisplayer.getHeight() / mazeData.length; 
				char [][] test = switchIT(mazeData,(int)Math.floor(me.getY()/h),(int)Math.floor(me.getX()/w),1);
				setPipeGame(test);
			}
		});
	}
	
	private char[][] switchIT (char[][] mazeDisplayer,int row, int col, int num ) {
		
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

	
	
	
	public void start() {
		System.out.println("Start");
	}
	public void solve() {
		Socket s=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try{
			s=new Socket("127.0.0.1",6400);
			s.setSoTimeout(3000);
			out=new PrintWriter(s.getOutputStream());
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			String problem = new String();
			for (int i = 0 ; i < mazeData.length; i++) {
				for (int j = 0 ; j < mazeData[0].length; j++) {
					problem = problem + mazeData[i][j];
				}
				out.println(problem);
				problem="";
			}
			
			out.println("done");
			System.out.println("inaalllll");
			out.flush();
			
			String line=in.readLine();
			while (line!=null) {
				String[] test = line.split(",");
				char [][] temp = switchIT(mazeData,Integer.parseInt(test[0]),Integer.parseInt(test[1]),Integer.parseInt(test[2]));
				setPipeGame(temp);
			    line=in.readLine();

			}
			
			
		}catch(SocketTimeoutException e){
			System.out.println("Your Server takes over 3 seconds to answer");
		}catch(IOException e){
			System.out.println("Your Server ran into some IOException");
		}finally{
			try {
				in.close();
				out.close();
				s.close();
			} catch (IOException e) {
				System.out.println("Your Server ran into some IOException");
			}
		}
	}


	
	public void openFile() {
		FileChooser fc= new FileChooser(); 
		fc.setTitle("open maze file");
		fc.setInitialDirectory(new File("./src/resources"));
		FileChooser.ExtensionFilter xmlExtensionFilter =
		            new FileChooser.ExtensionFilter(
		                    "XML files (.xml)", "*.jpg");
		fc.getExtensionFilters().add(xmlExtensionFilter);
		fc.setSelectedExtensionFilter(xmlExtensionFilter);

		File chosen = fc.showOpenDialog(null);
		if (chosen!=null){
			System.out.println(chosen.getName());
		}

	}
	
	
}
