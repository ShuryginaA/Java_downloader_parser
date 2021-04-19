/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 *
 * @author Anna
 */
public class parser {
    
   
 public static void parseWPage( File htmlFile) throws IOException
    
 {
     ArrayList<String> listOfSeparators = new ArrayList<>
        (Arrays.asList(" ", ".", "\"", "!", "?", ";", ":", "[", "]", "(", ")","\n", "\r", "\t"));
     
     //covert html file to document
     Document page = Jsoup.parse(htmlFile, "UTF-8"); 
     // create a HashMap to store words
     Map<String, Word> countMap = new HashMap<>();
     //get text
     String text=page.text(); 
     // create ByteArrayInputStream && BufferedReader to read text 
     ByteArrayInputStream bInpStr=new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
     BufferedReader reader = new BufferedReader(new InputStreamReader(bInpStr));
     String tmpLine;
     //add \\ to avoid treating symbols as Metacharacters
      String separatorsString = String.join("|\\", listOfSeparators);
     
        while ((tmpLine = reader.readLine()) != null) {
            String[] words = tmpLine.split(separatorsString);
     //if it's new word - create it in HashMap; inc the count
            for (String w : words) {
             Word word = countMap.get(w);
                if (word == null) {
                    word = new Word();
                    word.word = w;
                    word.count = 0;
                    countMap.put(w, word);
                }

                word.count++;
            }
            
        }
         reader.close();
      
        for (Word w :countMap.values() ) {
            System.out.println( w.word + "\t" + w.count);
        }
     
    }
   
    
}
