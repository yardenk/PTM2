package application;

import java.awt.Button;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import Model.PipeModel;
import View.PipeView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainWindowController implements Initializable, Observer{

	char[][]mazeData = {
			{'s','F','F','J','L'},
			{'J','L','F','L','J'},
			{'J','L','F','F','F'},
			{'J','L','L','-','J'},
			{'J','L','J','F','L'},
			{'J','L','F','L','g'},
	};
	private PipeModel model = new PipeModel();
	private PipeView view = new PipeView();

	@FXML
	MazeDisplayer mazeDisplayer ;
	Theme t = new Theme("Dark");

    public void Dark(){

	Media musicFile=new Media("file:///C:/Users/ehatchuel/Desktop/PtmClient/src/resources/ecl.mp3");
	MediaPlayer mediaPlayer = new MediaPlayer(musicFile);
	mediaPlayer.setAutoPlay(true);
	t.SetDark();
	mazeDisplayer.redraw();
     }


	public void Garden() {

		Media musicFile=new Media("file:///C:/Users/ehatchuel/Desktop/PtmClient/src/resources/mus.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(musicFile);
		mediaPlayer.setAutoPlay(true);
		t.SetGarden();
		mazeDisplayer.redraw();

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



	public void save(int port , String Host){
		if(port==6300&& Host=="127.0.0.1"  ){

			solve();

		}

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
