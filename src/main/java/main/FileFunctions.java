package main;

/**
 * Created by Kesava on 30/01/2017.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileFunctions {

    // create ArrayList to store the energyData objects
    private List<energyData> energyConsumer = new ArrayList<>();

    public void readFile(String[] args) {
        try {
            // create a Buffered Reader object instance with a FileReader
            BufferedReader br = new BufferedReader(new FileReader("energyData.txt"));
            // read the first line from the text file
            String fileRead = br.readLine();
            // loop until all lines are read
            while (fileRead != null) {
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
