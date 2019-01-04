package application;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.TimerTask;

import javax.swing.Timer;

import Model.PipeModel;

import javafx.stage.Window;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import View.PipeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainWindowController implements Initializable, Observer{



	char[][]mazeData = {
			{'s','F','F','J','L','L'},
			{'J','L','F','L','J','L'},
			{'J','L','F','F','F','L'},
			{'J','L','L','-','J','L'},
			{'J','L','J','F','L','L'},
			{'J','L','F','L','F','L'},
			{'J','L','J','F','L','L'},
			{'J','L','J','L','F','g'},
	};
	private PipeModel model = new PipeModel();
	private PipeView view = new PipeView();
	private int portAddr ; 
	private String hostAddr;

	@FXML
	MazeDisplayer mazeDisplayer ;
	Theme t = new Theme("Garden");
	//private LabelHandler label;

	@FXML


	public void theWallSong(){
		this.t = new Theme("Garden");
		setPipeGame(mazeData);

	}
	public void ECLIPSE(){
		this.t = new Theme("Dark");
		setPipeGame(this.mazeData);
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setPipeGame(mazeData);
		model.addObserver(this);
		view.addObserver(this);


	}

	private void setPipeGame(char [][] mazeData){
		view.setPipeGame(mazeData, mazeDisplayer, t);
	}


	@FXML
	private Button button ;
    @FXML
    private Label lable;

	@FXML

	public void handleButtonAction(){
		   
		   Stage window; 
		   Scene scene ; 
		   Button button; 
		   
		   
		   window = new Stage();
		   window.setTitle("Connection properties");
		   TextField host = new TextField();
		   TextField port = new TextField();
		   host.setPromptText("Enter your server address");
		   port.setPromptText("Enter your port number");

		   button = new Button("Submit");
		   
		   button.setOnAction(e-> {	
			   if (host != null)
				   hostAddr = host.getText();
			   if (port != null)
				   portAddr = Integer.parseInt(port.getText());
			   window.close();
		     }
		   );
		   VBox layout = new VBox(10); 
		   layout.setPadding(new Insets(20,20,20,20));
		   layout.getChildren().addAll(host,port,button);
		   
		   scene = new Scene(layout,300,250);
		   window.setScene(scene);
		   window.show();


	   }

	public void solve() {

    	model.solve(mazeData,hostAddr,portAddr);
	}


	public void checkCompletion() {
		Alert completionStatus;
		if (mazeDisplayer.isGoal()) {
			completionStatus = new Alert(AlertType.INFORMATION);
			completionStatus.setTitle("Completion Status");
			completionStatus.setHeaderText(null);
			completionStatus.getDialogPane().setPrefSize(300, 130);
			completionStatus.setContentText("Congratulations!\nYou successfully finished this stage." );
		} else {
			completionStatus = new Alert(AlertType.ERROR);
			completionStatus.setTitle("Completion Status");
			completionStatus.setHeaderText(null);
			completionStatus.getDialogPane().setPrefSize(300, 100);
			completionStatus.setContentText("Oh sorry,try again");
		}
		completionStatus.showAndWait();
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