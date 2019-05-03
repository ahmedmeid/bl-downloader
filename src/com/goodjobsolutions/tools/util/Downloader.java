package com.goodjobsolutions.tools.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class Downloader {
	
	static final Logger logger = Logger.getLogger(Downloader.class.getCanonicalName());
	
public static void downloadUsingStream(String urlStr, String file) throws IOException{
	    logger.info("downloading: "+urlStr+" to "+file);
		
		File f = new File(file);
		if(f.exists())
			return;
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    } 

}
