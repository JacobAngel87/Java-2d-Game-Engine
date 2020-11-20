package game_engine.src.Main;

import java.awt.Color;
import java.awt.image.BufferedImage;
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
	
	public static BufferedImage grayScaleImage(BufferedImage image) {
		try {
			 int width = image.getWidth();
	         int height = image.getHeight();
	         for(int i=0; i<height; i++) {
	            for(int j=0; j<width; j++) {
	               Color c = new Color(image.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               Color newColor = new Color(red+green+blue,
	               red+green+blue,red+green+blue);
	               image.setRGB(j,i,newColor.getRGB());
	            }
	         }
		} catch(Exception e) {}
		return image;
	}
}