/**
 * FileUtilities.java 
 * Fall 2011 mlb
 */

import java.util.*;
import java.io.*;



public class FileUtilities 
{ 
   
   // This file must be in the current directory
   private static final String FILE_NAME = "javawords.txt";
   
   
   
   //------------------ getStrings -------------------------
   //
   //   returns a Vector of Strings
   //   Each string is of the form:  word:hint 
   //   where word contains no spaces.
   //   The words and hints are read from FILE_NAME
   //
   //
   public static Vector<String> getStrings (  ) 
   {
      Vector<String> words = new Vector<String>();
      
      File file = new File( FILE_NAME );
      
      Scanner scanFile;
      try
      {
         scanFile = new Scanner( file);
      } 
      catch ( IOException e)
      {
         System.err.println( "LineInput Error: " + e.getMessage() );
         return null;
      }
      while ( scanFile.hasNextLine() )
      {
         // read the word and follow it by a colon
         String s = scanFile.nextLine().trim().toUpperCase() + ":";
         
         if( s.length()>1 && scanFile.hasNextLine() )
         {
            // append the hint and add to collection
            s+= scanFile.nextLine().trim();
            words.add(s);
         }
      }  
      
      // shuffle
      Collections.shuffle(words);
      
      return words;
   } 
}
