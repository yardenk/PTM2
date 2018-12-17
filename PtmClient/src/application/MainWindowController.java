package application;

import java.io.File;
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
			{'J','L','F'},
			{'J','-','F'},
			{'|','L','F'},
			{'J','-','F'},

			
			
	}; 
	
//	int[][]mazeData ={
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{1,1,0,0,0,0,0,0,1,1,1,1,1,1,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{1,1,1,1,1,1,1,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,1,1,1,1,1,1,1,1,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{1,1,1,1,1,1,0,0,0,0,0,1,1,1,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//
//	};
	
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
				char [][] test = switchIT(mazeData,(int)Math.floor(me.getY()/h),(int)Math.floor(me.getX()/w));
				setPipeGame(test);
			}
		});
	}
	
	private char[][] switchIT (char[][] mazeDisplayer,int row, int col ) {
		
			char tmpChar = mazeDisplayer[row][col];
			
			switch(tmpChar) {
			case 'L':
				mazeDisplayer[row][col] = 'F';
				break;
			case 'J':
				mazeDisplayer[row][col] = 'L';
				break;
			case '7':
				mazeDisplayer[row][col] = 'J';
				break;
			case 'F':
				mazeDisplayer[row][col] = '7';
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
	public void openFile() {
		FileChooser fc= new FileChooser(); 
		fc.setTitle("open maze file");
		fc.setInitialDirectory(new File("./resources"));
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
