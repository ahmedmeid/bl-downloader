package com.goodjobsolutions.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class Main {
	
	static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());
		
	
	public static void main(String[] args) throws Exception {
		
		logger.info("Application started");
		
		ImageCreator creator = new ImageCreator();
		
		FileInputStream fstream = new FileInputStream("images.list");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String line = null;
		while((line = br.readLine()) != null) {
			creator.createImage(Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT, line);
		}
		br.close();
		fstream.close();
		logger.info("Application closing");
	}
	

}
