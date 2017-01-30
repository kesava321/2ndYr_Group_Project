package main;

/**
 * Created by Kesava on 30/01/2017.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public class FileFunctions {

        public static void main(String[] args) {
            // create ArrayList to store the energyData objects
            List<energyData> energyConsumer = new ArrayList<>();
            try {
                // create a Buffered Reader object instance with a FileReader
                BufferedReader br = new BufferedReader(new FileReader("energyData.txt"));

                // read the first line from the text file
                String fileRead = br.readLine();

                // loop until all lines are read
                while (fileRead != null) {