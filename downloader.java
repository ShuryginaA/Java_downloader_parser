/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

/**
 *
 * @author Anna
 */
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
  
public class downloader {
  
    public static void downloadWPage(String wpage)
    {
        try {
            URL url = new URL(wpage);
            BufferedReader reader = 
              new BufferedReader(new InputStreamReader(url.openStream()));
            FileWriter fileWritr=new FileWriter("Download.html");
            BufferedWriter writer = 
              new BufferedWriter(fileWritr);
            String tmpLine;
            while ((tmpLine = reader.readLine()) != null) {
                writer.write(tmpLine);
            } 
            reader.close();
            writer.close();
            System.out.println("Downloaded\n");
            
           
        }
        catch (MalformedURLException mue) {
            System.out.println("MalformedURLException: invalid URL");
        }
        catch (IOException ie) {
            System.out.println("IOException");
        }
    }
}