
/**
 * FileReFormat class
 * 
 * This class will read in the formatted text file of SmallAreaIncomePovertyEstData.txt
 * using the BufferedReader and FileReader character stream and written to an output 
 * file using the PrintWriter, BufferedWriter, and FileWriter character streams.
 * 
 * @author sDantzler
 */

import java.io.*;

public class FileReFormat {

   public static void main(String[] args) throws IOException {

      // try with resources
      try (BufferedReader fileinput = new BufferedReader(new FileReader(
            "/Users/sdantzle/Documents/Personal Reports/School/Intro to Java/Homework/Homework10/HW_Output1.txt"));
            PrintWriter fileoutput = new PrintWriter(
                  new BufferedWriter(new FileWriter(
                        "/Users/sdantzle/Documents/Personal Reports/School/Intro to Java/Homework/Homework10/HW_Output2.txt")))) {

         int count = 0; // count the records in the file
         String line; // Assign each line within the file

         // while loop to print out formatted file to a different output file
         while ((line = fileinput.readLine()) != null) {
            count++;
            fileoutput.println(line);
         } // end while loop
           // display the total records in the input file
         System.out.println("Number of records in file: " + count);
      } // end try
      catch (IOException ioe) {
         System.out.println("I/O Error: " + ioe);
      } // end catch

   }// end main method

}// end class FileReformat
