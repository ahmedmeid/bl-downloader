package com.goodjobsolutions.tools;

import static com.goodjobsolutions.tools.util.Downloader.downloadUsingStream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageCreator {
	
	static final Logger logger = Logger.getLogger(ImageCreator.class.getCanonicalName());
	
public void createImage(int width, int height, String imageId) throws IOException {
	
	logger.info("creating "+imageId);
		
		File tempDir = new File(imageId);
		tempDir.mkdir();
		
		int columns = (int) Math.floor(width / 256); 
		int rows = (int) Math.floor(height / 256);   

		BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		BufferedImage img = null;
		
		int currentHeight = 0;
	
		for(int i=0;i<rows+1;i++)
		{
			int currentWidth = 0;
			for(int j=0;j<columns+1;j++)
			{		
				String fileName = imageId + "/" + j+ "_" +i + ".jpg"; 
				String url = Constants.BASE_URL+imageId+"/"+currentWidth+","+currentHeight+",256,256/256,/0/default.jpg";
				try {
					downloadUsingStream(url, fileName);
					File imageFile = new File(fileName);
					img = ImageIO.read(imageFile);
					finalImage.createGraphics().drawImage(img, currentWidth, currentHeight, null);
					currentWidth += 256;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}			
			}
			currentHeight += 256;
		}
		
		File final_image = new File(imageId+".jpg");
		ImageIO.write(finalImage, "jpeg", final_image);
		logger.info("file "+imageId+".jpg has been created");
	}

}
