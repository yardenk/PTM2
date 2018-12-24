package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

import com.sun.media.jfxmedia.effects.AudioEqualizer;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Theme {

	

	private Image varL = null; 
	private Image varJ = null; 
	private Image varF = null; 
	private Image var7 = null; 
	private Image varVert = null; 
	private Image varHora = null; 
	private Image start = null ; 
	private Image goal = null ; 
	//private String mediaUrl = null ; 
	


		public Theme(String themeType)  {
			try {
				varL = new Image (new FileInputStream("./src/resources/varL.png"));
				varJ = new Image (new FileInputStream("./src/resources/varJ.png"));
				var7 = new Image (new FileInputStream("./src/resources/var7.png"));
				varF = new Image (new FileInputStream("./src/resources/varF.png"));
				varVert = new Image (new FileInputStream("./src/resources/varVert.png"));
				varHora = new Image (new FileInputStream("./src/resources/varHora.png"));
				start = new Image (new FileInputStream("./src/resources/start.jpg"));
				goal = new Image(new FileInputStream("./src/resources/goal.gif"));


			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (themeType == "Dark") {
				
			//	InputStream is=new FileInputStream("./src/resources/Moon.mp3");
			//	AudioInputStream as=new AudioInputStream(is);
			//	AudioEqualizer.player.start(as);


			}
			else if (themeType == "Garden") {
				
			}
			
			
		}
		public Image getVarL() {
			return varL;
		}


		public void setVarL(Image varL) {
			this.varL = varL;
		}


		public Image getVarJ() {
			return varJ;
		}


		public void setVarJ(Image varJ) {
			this.varJ = varJ;
		}


		public Image getVarF() {
			return varF;
		}


		public void setVarF(Image varF) {
			this.varF = varF;
		}


		public Image getVar7() {
			return var7;
		}


		public void setVar7(Image var7) {
			this.var7 = var7;
		}


		public Image getVarVert() {
			return varVert;
		}


		public void setVarVert(Image varVert) {
			this.varVert = varVert;
		}


		public Image getVarHora() {
			return varHora;
		}


		public void setVarHora(Image varHora) {
			this.varHora = varHora;
		}


		public Image getStart() {
			return start;
		}


		public void setStart(Image start) {
			this.start = start;
		}


		public Image getGoal() {
			return goal;
		}


		public void setGoal(Image goal) {
			this.goal = goal;
		}

}
