package game_engine.src.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Author: Jacob Angel
// Date: 8/30/2020

public class Utils {
	
	// Reads the given file into a string to manipulate
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) { 
				builder.append(line + "\n");
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	// Turns valid string into int 
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
}