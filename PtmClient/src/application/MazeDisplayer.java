package application;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class MazeDisplayer extends Canvas{
	
	char[][] mazeData ;
	int cCol,cRow; 
	Theme t ;  
	
	public int getcCol() {
		return cCol;
	}
	public int getcRow() {
		return cRow;
	}

	public void setCharacterPosition ( int row, int col) {
		cCol = col ; 
		cRow = row; 
		redraw();
	}
	

	public MazeDisplayer() {
		cCol = 0 ;
		cRow = 2; 
	}
	

	
	
	

	public void setMazeData(char[][] mazeData,Theme t) {
		this.mazeData = mazeData;
		this.t = t; 
		redraw();
	} 
	
	public void redraw() {
		if (mazeData!=null) {
			double W = getWidth(); 
			double H = getHeight();
			double w = W / mazeData[0].length;
			double h = H / mazeData.length; 
			
			GraphicsContext gc = getGraphicsContext2D(); 
			 
			gc.clearRect(0, 0, W, H);
			
			for(int i=0 ; i< mazeData.length ; i++) {
				for (int j=0 ; j<mazeData[i].length; j++) {
					
					if (mazeData[i][j] == 'J') {
						gc.drawImage(t.getVarJ(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == '|') {
						gc.drawImage(t.getVarVert(), j*w, i*h, w, h);
					}if (mazeData[i][j] == '-') {
						gc.drawImage(t.getVarHora(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == 'L') {
						gc.drawImage(t.getVarL(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == '7') {
						gc.drawImage(t.getVar7(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == 'F') {
						gc.drawImage(t.getVarF(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == 's') {
						gc.drawImage(t.getStart(), j*w, i*h, w, h);
					}
					if (mazeData[i][j] == 'g') {
						gc.drawImage(t.getGoal(), j*w, i*h, w, h);
					}
					
			
			}
			
		}
	}
	

 }
	

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public double minHeight(double width) {
		return 64;
	}

	@Override
	public double maxHeight(double width) {
		return 1000;
	}

	@Override
	public double prefHeight(double width) {
		return minHeight(width);
	}

	@Override
	public double minWidth(double height) {
		return 0;
	}

	@Override
	public double maxWidth(double height) {
		return 10000;
	}

	@Override
	public void resize(double width, double height) {
		super.setWidth(width);
		super.setHeight(height);
		this.cleanGame();
		this.redraw();
	}
	
	public void cleanGame() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, getWidth(), getHeight());
	}
	
	
	
} 
