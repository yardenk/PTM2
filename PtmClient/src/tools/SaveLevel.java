package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveLevel {
	
	public static void saveLevel(char[][]level) throws IOException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;

		StringBuilder builder = new StringBuilder();


		    for(int i = 0; i < level.length; i++)
		    {
		       for(int j = 0; j < level[0].length; j++)
		       {
		          builder.append(level[i][j]+"");
		       }
		       builder.append("\n");
		    }
		    System.out.println(builder.toString());
		    BufferedWriter writer = new BufferedWriter(new FileWriter("./src/resources/level-" + dateFormat.format(date) + ".txt"));
		    writer.write(builder.toString());
		    writer.close();
	}

}
