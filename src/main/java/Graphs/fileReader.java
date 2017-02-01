package Graphs;

/**
 * Created by Kesava on 30/01/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileReader {

    public class FileFunctions {

        public static void main(String[] args) {
            // create ArrayList to store the energyData objects
            List<energyData> energyConsumer = new ArrayList<>();
            try {
                // create a Buffered Reader object instance with a FileReader
                BufferedReader br = new BufferedReader(new fileReader("energyData.txt"));

                // read the first line from the text file
                String fileRead = br.readLine();

                // loop until all lines are read
                while (fileRead != null) {

                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");

                    // assume file is made correctly
                    // and make temporary variables for the three types of data
                    String tempenergyConsumer = tokenize[0];
                    int tempQuantity = Integer.parseInt(tokenize[1]);
                    float tempenergyRating = Float.parseFloat(tokenize[2]);

                    // create temporary instance of energyConsumer object
                    // and load with three data values
                    energyData tempObj = new energyData(tempenergyConsumer, tempQuantity, tempenergyRating);

                    // add to array list
                    energyConsumer.add(tempObj);

                    // read next line before looping
                    // if end of file reached
                    fileRead = br.readLine();
                }


            // close file stream
            br.close();
        }

            // handle exceptions
            catch (FileNotFoundException fnfe)
            {
                System.out.println("file not found");
            }

            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
