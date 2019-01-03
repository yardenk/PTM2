package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.scene.image.Image;

public class Theme {



	private Image varL = null;
	private Image varJ = null;
	private Image varF = null;
	private Image var7 = null;
	private Image varVert = null;
	private Image varHora = null;
	private Image start = null ;
	private Image goal = null ;
	private Image backg= null;
	private Image im= null;

	public void SetDark()
	{
		try {
			backg= new Image(new FileInputStream("C:/Users/ehatchuel/Desktop/PtmClient/src/resources/eclipse.jpg"));
			start = new Image (new FileInputStream("./src/resources/start.png"));
			goal = new Image (new FileInputStream("./src/resources/goal.png"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SetGarden()
	{
		try {
			backg= new Image(new FileInputStream("C:/Users/ehatchuel/Desktop/PtmClient/src/resources/pane.jpg"));
			goal = new Image (new FileInputStream("./src/resources/goal2.png"));
			start = new Image (new FileInputStream("./src/resources/start2.png"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


		public Theme(String themeType){
		if(themeType == "Garden"){//wall
			try {
				varL = new Image (new FileInputStream("./src/resources/varL.png"));
				varJ = new Image (new FileInputStream("./src/resources/varJ.png"));
				var7 = new Image (new FileInputStream("./src/resources/var7.png"));
				varF = new Image (new FileInputStream("./src/resources/varF.png"));
				varVert = new Image (new FileInputStream("./src/resources/varVert.png"));
				varHora = new Image (new FileInputStream("./src/resources/varHora.png"));
				goal = new Image (new FileInputStream("./src/resources/goal2.png"));
				start = new Image (new FileInputStream("./src/resources/start2.png"));
				backg= new Image(new FileInputStream("C:/Users/ehatchuel/Desktop/PtmClient/src/resources/pane.jpg"));


			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		else if(themeType=="Dark"){//eclipse
			try{


			varL = new Image (new FileInputStream("./src/resources/varL.png"));
			varJ = new Image (new FileInputStream("./src/resources/varJ.png"));
			var7 = new Image (new FileInputStream("./src/resources/var7.png"));
			varF = new Image (new FileInputStream("./src/resources/varF.png"));
			varVert = new Image (new FileInputStream("./src/resources/varVert.png"));
			varHora = new Image (new FileInputStream("./src/resources/varHora.png"));
			start = new Image (new FileInputStream("./src/resources/start.png"));
			goal = new Image (new FileInputStream("./src/resources/goal.png"));
			backg= new Image(new FileInputStream("C:/Users/ehatchuel/Desktop/PtmClient/src/resources/eclipse.jpg"));

		}	 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		public Image getbackg(){
			return backg;
		}

		public void setbackg(Image backg) {
			this.backg = backg;
		}




}
