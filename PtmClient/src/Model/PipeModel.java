package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Observable;

import javafx.stage.FileChooser;
import tools.LoadLevel;
import tools.Rotate;
import tools.SaveLevel;

public class PipeModel extends Observable {
	
	

	public void saveLevel(char[][]mazeData) {
		try {
			SaveLevel.saveLevel(mazeData);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loadLevel() {
		FileChooser fc= new FileChooser(); 
		fc.setTitle("open maze file");
		fc.setInitialDirectory(new File("./src/resources"));
		FileChooser.ExtensionFilter xmlExtensionFilter =
		            new FileChooser.ExtensionFilter(
		                    "TXT files (.txt)", "*.txt");
		fc.getExtensionFilters().add(xmlExtensionFilter);
		fc.setSelectedExtensionFilter(xmlExtensionFilter);

		File chosen = fc.showOpenDialog(null);
		if (chosen!=null){
			try {
				//this.mazeData = LoadLevel.loadNewLevel(chosen);
				//setPipeGame(this.mazeData);
				char[][]mazeData=LoadLevel.loadNewLevel(chosen);
				setChanged();
				notifyObservers(mazeData);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void solve(char[][]mazeData) {
		Socket s=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try{
			s=new Socket("127.0.0.1",6400);
			s.setSoTimeout(3000);
			out=new PrintWriter(s.getOutputStream());
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			String problem = new String();
			for (int i = 0 ; i < mazeData.length; i++) {
				for (int j = 0 ; j < mazeData[0].length; j++) {
					problem = problem + mazeData[i][j];
				}
				out.println(problem);
				problem="";
			}
			
			out.println("done");

			out.flush();
			
			String line=in.readLine();
			while (line!=null) {
				String[] test = line.split(",");
				char [][] temp = Rotate.switchIT(mazeData,Integer.parseInt(test[0]),Integer.parseInt(test[1]),Integer.parseInt(test[2]));
				setChanged();
				notifyObservers(temp);
				//setPipeGame(temp);
			    line=in.readLine();
			}
			
			
		}catch(SocketTimeoutException e){
			System.out.println("Your Server takes over 3 seconds to answer");
		}catch(IOException e){
			System.out.println("Your Server ran into some IOException");
		}finally{
			try {
				in.close();
				out.close();
				s.close();
			} catch (IOException e) {
				System.out.println("Your Server ran into some IOException");
			}
		}

		
	}
	public void check(char[][] mazeData) {
		// TODO Auto-generated method stub
		
	}



}
