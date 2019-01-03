package application;

import java.awt.Point;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

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

	//Check if the board is in Goal state (Possible path from s to g). Using recIsGoal().
		public boolean isGoal()
		{
			int i=0;
			int j=0;
			outerLoop:
			for (i=0; i<getHeight(); i++) {
				for (j=0; i<getWidth(); j++) {
					if (mazeData[i][j] == 's')
					{
						break outerLoop;
					}
				}
			}
			Point start = new Point(i,j);
			boolean[][] visited = new boolean[(int) getHeight()][(int) getWidth()];
			return recIsGoal(visited,start);
		}
		//Recurse check for isGoal() (Dynamic Algorithm).
		private boolean recIsGoal(boolean[][] visited,Point p)
		{
			if(mazeData[p.x][p.y] == 'g') { return true; }
			visited[p.x][p.y] = true;
			boolean flag = false;
			if(mazeData[p.x][p.y] == '|') {
				p.x++;
				if ((p.x < getHeight())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'J')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x-=2;
				if ((p.x >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == '7')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x++;
			}
			else if(mazeData[p.x][p.y] == '-')
			{
				p.y++;
				if ((p.y < getWidth())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'J')||(mazeData[p.x][p.y] == '7')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y-=2;
				if ((p.y >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y++;
			}
			else if(mazeData[p.x][p.y] == 'L')
			{
				p.x--;
				if ((p.x >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == '7')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x++;
				p.y++;
				if ((p.y < getWidth())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'J')||(mazeData[p.x][p.y] == '7')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y--;
			}
			else if(mazeData[p.x][p.y] == 'F')
			{
				p.x++;
				if ((p.x < getHeight())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'J')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x--;
				p.y++;
				if ((p.y < getWidth())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'J')||(mazeData[p.x][p.y] == '7')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y--;
			}
			else if(mazeData[p.x][p.y] == '7')
			{
				p.x++;
				if ((p.x < getHeight())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'J')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x--;
				p.y--;
				if ((p.y >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y++;
			}
			else if(mazeData[p.x][p.y] == 'J')
			{
				p.x--;
				if ((p.x >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == '7')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x++;
				p.y--;
				if ((p.y >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y++;
			}
			else if(mazeData[p.x][p.y] == 's')
			{
				p.x--;
				if ((p.x >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == '7')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x+=2;
				if ((p.x < getHeight())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'J')||
						(mazeData[p.x][p.y] == '|')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.x--;
				p.y--;
				if ((p.y >= 0)&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'L')||(mazeData[p.x][p.y] == 'F')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y+=2;
				if ((p.y < getWidth())&&(!visited[p.x][p.y])&&
						((mazeData[p.x][p.y] == 'J')||(mazeData[p.x][p.y] == '7')||
						(mazeData[p.x][p.y] == '-')||(mazeData[p.x][p.y] == 'g'))) {
					if(recIsGoal(visited,p)) { flag = true; }
				}
				p.y--;
			}
			return flag;
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


			gc.drawImage(t.getbackg(),0,0, W, H);



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

