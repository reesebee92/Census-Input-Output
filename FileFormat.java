
/**
 * FileFormat class
 * 
 * This class will read in the provided text file, SmallAreaIncomePovertyEstData.txt,
 * using the BufferedReader and FileReader character stream and reformat the data to
 * only include data per state for the total population, child population, child 
 * poverty population, and the percentage of child poverty within that state. Once this
 * is completed for each state this data will be written to an output file using the 
 * PrintWriter, BufferedWriter, and FileWriter character streams.
 * 
 * @author sDantzler
 */

import java.io.*;

public class FileFormat {

   public static void main(String[] args) throws IOException {

      // try with resources
      try (BufferedReader fileinput = new BufferedReader(new FileReader(
            "/Users/sdantzle/Documents/Personal Reports/School/Intro to Java/Homework/Homework10/SmallAreaIncomePovertyEstData.txt"));
            PrintWriter fileoutput = new PrintWriter(
                  new BufferedWriter(new FileWriter(
                        "/Users/sdantzle/Documents/Personal Reports/School/Intro to Java/Homework/Homework10/HW_Output1.txt")))) {

         int index = 0; // Count through different positions in the file
         int count = 0; // Count the records in the file
         String line; // Assign each line within the file

         char[] stateCode = { '0', '1' }; // Needed to compare/update state
                                          // codes

         // Initial population values
         int totalPop = 0;
         int childPop = 0;
         int childPovPop = 0;
         String tPop = "";
         String cPop = "";
         String cPovPop = "";

         // Write the title to the file
         fileoutput.println(
               "State   Population  Child Population Child Poverty Population  %Child Poverty");
         fileoutput.println(
               "-----   ----------  ---------------- ------------------------  ---------------");

         // while loop to go through each line in the file
         while ((line = fileinput.readLine()) != null) {

            count++;

            // If the the state code is the same add each amount per position in
            // the file
            // This is executed by getting a string of each population and then
            // parsing
            // the string and adding the new number to the total population
            // value
            if (line.charAt(0) == stateCode[0]
                  && line.charAt(1) == stateCode[1]) {

               for (index = 82; index < 90; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     tPop = tPop + line.charAt(index);
                  }
               } // end for loop
               totalPop = totalPop + Integer.parseInt(tPop);
               tPop = "";

               for (index = 91; index < 99; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     cPop = cPop + line.charAt(index);
                  }
               } // end for loop
               childPop = childPop + Integer.parseInt(cPop);
               cPop = "";

               for (index = 100; index < 108; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     cPovPop = cPovPop + line.charAt(index);
                  }
               } // end for loop
               childPovPop = childPovPop + Integer.parseInt(cPovPop);
               cPovPop = "";
            } // end if

            // If the the state code is NOT the same output the results stored
            // within the population variables, update the state code array, and
            // reinitialize each population value (total 6)
            // Then repeat the above
            else {
               fileoutput.printf("%4s%1s%,13d%,18d%,25d%17.2f\n", stateCode[0],
                     stateCode[1], totalPop, childPop, childPovPop,
                     ((childPovPop * 100.00) / childPop));
               stateCode[0] = line.charAt(0);
               stateCode[1] = line.charAt(1);
               totalPop = 0;
               childPop = 0;
               childPovPop = 0;

               for (index = 82; index < 90; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     tPop = tPop + line.charAt(index);
                  }
               } // end for loop
               totalPop = totalPop + Integer.parseInt(tPop);
               tPop = "";

               for (index = 91; index < 99; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     cPop = cPop + line.charAt(index);
                  }
               } // end for loop
               childPop = childPop + Integer.parseInt(cPop);
               cPop = "";

               for (index = 100; index < 108; index++) {
                  if (line.charAt(index) == ' ') {
                     continue;
                  } else {
                     cPovPop = cPovPop + line.charAt(index);
                  }
               } // end for loop
               childPovPop = childPovPop + Integer.parseInt(cPovPop);
               cPovPop = "";
            } // end else

         } // end while

         // Output the final results for the last state after the while loop
         // exits
         fileoutput.printf("%4s%1s%,13d%,18d%,25d%17.2f\n", stateCode[0],
               stateCode[1], totalPop, childPop, childPovPop,
               ((childPovPop * 100.00) / childPop));

         // Display the total records in the input file
         System.out.println("Number of records in file: " + count);

      } // end try
      catch (IOException ioe) {
         System.out.println("I/O Error: " + ioe);
      } // end catch

   }// end main method

}// end classFileFormat
