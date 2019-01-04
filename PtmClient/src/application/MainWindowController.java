package application;

import java.awt.Button;
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


import View.PipeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
//		setLableStepsHandler();
//		setLabelHandler();
//		this.statistics = new Statistics();
//		this.statistics.setLevel(mazeData);
//		this.statistics.setStepsNumber(0);

	}

//
//	public void setLableStepsHandler() {
//		this.stepsLabel=new LabelStepsHandler(lblSteps);
//
//	}
//
//	public void setLabelHandler() {
//		this.label=new LabelHandler(lbl);
//	}
	private void setPipeGame(char [][] mazeData){
		view.setPipeGame(mazeData, mazeDisplayer, t);
	}


	@FXML
	private Button button ;
    @FXML
    private Label lable;

	@FXML

   public void handleButtonAction(){
    try{


    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
    	Parent root= (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Connect to server");
    	stage.setScene(new Scene(root));
    	stage.show();
    }catch(Exception e)
    {
    	System.out.println("can load");
    }
	}


	public void solve() {

    	model.solve(mazeData);
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
