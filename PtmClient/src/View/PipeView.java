package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Observable;

import application.MazeDisplayer;
import application.Theme;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import tools.Rotate;

public class PipeView extends Observable {
	
	public void setPipeGame(char [][] mazeData,MazeDisplayer mazeDisplayer,Theme t){
		//set data
		mazeDisplayer.setMazeData(mazeData,t);
		
		//set event listener (mouse event listener)
		mazeDisplayer.setOnMouseClicked(new EventHandler<Event>() {

			Socket s=null;
			PrintWriter out=null;
			BufferedReader in=null;
			@Override
			public void handle(Event event) {
				MouseEvent me = (MouseEvent) event;
				double w = mazeDisplayer.getWidth() / mazeData[0].length; 
				double h = mazeDisplayer.getHeight() / mazeData.length; 
				char [][] test = Rotate.switchIT(mazeData,(int)Math.floor(me.getY()/h),(int)Math.floor(me.getX()/w),1);
				setPipeGame(test,mazeDisplayer,t);
			
			}
			
		
			
		});
	}

}
