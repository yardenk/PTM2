package application;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import Model.PipeModel;
import View.PipeView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import tools.LoadLevel;
import tools.Rotate;
import tools.SaveLevel;

public class MainWindowController implements Initializable, Observer{
	char[][]mazeData = {
			{'s','L','F'},
			{'J','L','F'},
			{'g','L','F'},
	}; 
	private PipeModel model = new PipeModel(); 
	private PipeView view = new PipeView();

	@FXML
	MazeDisplayer mazeDisplayer ; 
	Theme t = new Theme("Dark");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setPipeGame(mazeData);	
		model.addObserver(this);
		view.addObserver(this);
		
	}
	
	
	
	private void setPipeGame(char [][] mazeData){
		view.setPipeGame(mazeData, mazeDisplayer, t);
	}
	
	

	public void solve() {
		model.solve(mazeData);
	}


	public void saveLevel() {
		
		model.saveLevel(mazeData);
		
	}
	public void loadLevel() {
		model.loadLevel();

	}



	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == model) {
			this.mazeData = (char[][]) arg1; 
			setPipeGame(this.mazeData); 
		}

		
	}
	
	
}
