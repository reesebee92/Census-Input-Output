# Census-Input-Output

The purpose of this project is to practice the Java feature of inputting and outputting files and formatting the files.

Design

My design includes two programs: 1) read in the text file provided, reformat the data, and display the total file records, 2) read in the reformatted data report and display the total record count within the file. I thought about using the BufferedOutputStream and the BufferedInputStream with the FileOutputStream and FileInputStream respectively, but I decided to use the Reader and Writer classes instead since I am familiar with String manipulation. Once I read in the text file I combined each state’s data in one line with an added parameter of the percentage of child poverty relative to the child population. The total population data parameters per state will be 4: 1) Total Population, 2) Child Population, 3) Child Poverty Population, and 4) % Child Poverty.
