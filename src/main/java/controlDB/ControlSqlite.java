package controlDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.File;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.sql.* ;
import javax.imageio.*;
import javafx.embed.swing.SwingFXUtils;
import java.ArrayList;

/**
 * This is the database control class based on Sqlite.
 * Before use this class, the Sqlite should be download on your machine.
 * Created by Rui on 2017/2/1.
 */
public class ControlSqlite implements DatabaseExecutable{
    private Connection c  = null;
    private Statement stmt = null;
    private String sql = null;
    public ControlSqlite(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Data.db");
            System.out.println("Opened database successfully");

            //create DataInput database to reord all the TYPES
            stmt = c.createStatement();
            sql = "CREATE TABLE if not exists Types_Table " +
                    "(appliance_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " power_type TEXT)";
            stmt.executeUpdate(sql);

            //The table for RATING
            sql = "CREATE TABLE if not exists Rating " +
                    "(appliance_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " power_rating REAL)";
            stmt.executeUpdate(sql);

            //The table for APPLIANCE
            sql = "CREATE TABLE if not exists Appliance " +
                    "(appliance_ID INTEGER PRIMARY KEY AUTOINCREMENT,"  +
                    "name TEXT," +
                    "image BLOB)";
            stmt.executeUpdate(sql);

            System.out.println("Table created successfully");
            //stmt.close();
            //c.close();
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void databaseClose() {
        try {
            stmt.close();
            c.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.printf("Database disconnected\n");
    }

    public void InsertData(String tableName, Object[] dataSet) {

        if (tableName == "Types_Table") {
            sql = "INSERT INTO "+ tableName + " VALUES (?,?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(2, (String) dataSet[1]);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else if (tableName == "Rating"){
            sql = "INSERT INTO "+ tableName + " VALUES (?,?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setInt(2, (Integer) dataSet[1]);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            sql = "INSERT INTO "+ tableName + " VALUES (?,?,?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(2, (String) dataSet[0]);
                pstmt.setBytes(3, readFile((String) dataSet[1]));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public ArrayList<Object[]>() getResult(String sql) {
        ArrayList<Object[]> al = new ArrayList<String>();

        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            //judge whether rs has records in database
            if (rs.next()){

            }
            else{
                System.out.printf("Error: Nothing found!\n");
            }
        }
        catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return al;
    }

    /**
     * return the image form table Appliance by id
     * if noting found, return null and print error message
     * @param id the Appliance_id column in table
     * @return a javafx image
     */
    public javafx.scene.image.Image getImageByIdFromAppliance(int id){

        String sql = "SELECT image FROM Appliance WHERE appliance_ID = " + id;
        javafx.scene.image.Image img = null;
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            //judge whether rs has records in database
            if (rs.next()){
                byte[] temp = rs.getBytes("image");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(temp));
                image = Windows.DrawAppliance.scale(image, 50,50);
                img = SwingFXUtils.toFXImage(image, null);
            }
            else{
                System.out.printf("Error: Nothing found!\n");
            }
        }
        catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return img;
    }

    /**
     * return the image form table Appliance by id
     * if noting found, return null and print error message
     * @param id the Appliance_id column in table
     * @return string
     */
    public String getNameByIdFromAppliance(int id){
        String sql = "SELECT name FROM Appliance WHERE appliance_ID = " + id;
        String name = null;
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            //judge whether rs has records in database
            if (rs.next()){
                name = rs.getString("name");
            }
            else{
                System.out.printf("Error: Nothing found!\n");
            }
        }
        catch (  SQLException e ) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public void DisplayUpdatedColumn(){

    }

     /**
     * Display the content of database
     */
    public void DisplayTable(){
        //ControlSqlite cs = new ControlSqlite();
        for (int i = 0; i < 3; i++) {
            String tableName = "";

            if (i == 0) tableName = "Types_Table";
            if (i == 1) tableName = "Rating";
            if (i == 2) tableName = "Appliance";

            String sql = "SELECT * FROM " + tableName;

            System.out.printf("----Table " + i + "----\n");
            try (
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
                // loop through the result set
                while (rs.next()) {
                    if (i == 0) {
                        System.out.println(
                                rs.getInt("appliance_ID") + "\t" +
                                        rs.getString("power_type") + "\t");
                    }

                    if (i == 1) {
                        System.out.println(
                                rs.getInt("appliance_ID") + "\t" +
                                        rs.getInt("power_rating") + "\t");
                    }

                    if (i == 2) {
                        System.out.println(
                                rs.getInt("appliance_ID") + "\t" +
                                        rs.getString("name") + "\t" +
                                        rs.getString("image"));
                        //write image to file
                        File file = new File("src/main/resources/temp.png");
                        FileOutputStream fos = new FileOutputStream(file);

                        //test
                        if (rs.getBytes(2) == null){
                            System.out.println("hello");
                        }
                        //test
                        //byte[] test = readFile("src/main/resources/Images/heating.png");
                        //fos.write(test);

                        InputStream input = rs.getBinaryStream("image");

                        byte[] buffer = new byte[1024];

                        while ( input.read(buffer) > 0 ) {
                            fos.write(buffer);
                        }
                        fos.flush();
                        fos.close();
                        input.close();
                    }
                }
                System.out.printf("----End Of Data Display----\n");
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public byte[] ReadImageByColumn(String Column){
        String sql = "SELECT * FROM Appliance where name = '" + Column + "'";
        byte[] temp = null;
        try (Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
            temp = rs.getBytes("image");
            return temp;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return temp;
    }

    /**
     * Read the file and returns the byte array
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public String getWordFromString(int position, String sql){
        String word = null;
        int count = 0, j = 0;
        for (int i = position; i > 0 ; i--)
        {
           for (; ;count++ ) {
               if (sql[count] == ' '){
                   count++;
                   break;
               }
           }
        }

        while (sql[count] != ' '){
            word[j] = sql[count];
            count++;
            j++;
        }
        return word;
    }
}


