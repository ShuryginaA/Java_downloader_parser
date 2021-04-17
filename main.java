/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import static downloader.downloader.downloadWPage;
import static downloader.parser.parseWPage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Anna
 */
public class main {
    
    public static void main(String args[])
        throws IOException
    {
        String url = "https://www.simbirsoft.com/";
        downloadWPage(url);
        File file1 = new File("Z:\\NetBeansProjects\\Downloader", "Download.html");
        parseWPage(file1);
    }
    
}
