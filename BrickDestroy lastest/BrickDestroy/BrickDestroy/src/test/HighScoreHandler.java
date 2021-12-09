package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HighScoreHandler {
	public static List<String> read() {
		return readScores("score.txt");
	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	public static List<String> readScores(String fichier){
		List<String> listeLignes = new LinkedList<>();
	    try
	    {
	      File file = new File(fichier);   
	      FileReader fr = new FileReader(file);    
	      BufferedReader br = new BufferedReader(fr);  
	      StringBuffer sb = new StringBuffer();    
	      String line;
	      while((line = br.readLine()) != null)
	      {
	    	if (line.equals("")==false && isNumeric(line.trim()))
	    		listeLignes.add(line.trim());    
	      }
	      fr.close();    
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	    return listeLignes;
	}
	
	public static void saveScore(String args, int mode) {
		append("score.txt",args);
	}
	
    public static void append(String filename, String text) {
        BufferedWriter bufWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename, true);
            bufWriter = new BufferedWriter(fileWriter);

            bufWriter.newLine();
            bufWriter.write(text);
            bufWriter.close();
        } catch (IOException ex) {
            
        } finally {
            try {
                bufWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
             
            }
        }
    }
}
