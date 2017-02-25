package controlDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.* ;

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
                    "(appliance_ID INT PRIMARY KEY," +
                    " power_type TEXT)";
            stmt.executeUpdate(sql);

            //The table for RATING
            sql = "CREATE TABLE if not exists Rating " +
                    "(appliance_ID INT PRIMARY KEY," +
                    " power_rating REAL)";
            stmt.executeUpdate(sql);

            //The table for APPLIANCE
            sql = "CREATE TABLE if not exists Appliance " +
                    "(appliance_ID INT PRIMARY KEY,"  +
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

    public void databaseClose() throws SQLException{
        stmt.close();
        System.out.printf("Database disconnected\n");
    }

    public void InsertData(String tableName, Object[] dataSet) throws SQLException {
        sql = "INSERT INTO "+ tableName + " VALUES (?,?)";

        if (tableName == "Types_Table") {
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(2, (String) dataSet[0]);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else if (tableName == "Rating"){
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setFloat(2, (String) dataSet[0]);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, (String) dataSet[0]);
                pstmt.setString(2, readFile((String)dataSet[1]));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void UpdateData(String tableName){

    }

    public void DisplayTable(String tableName) throws SQLException {
        //ControlSqlite cs = new ControlSqlite();
        String sql = "SELECT * FROM ENERGYDATA";

        try (
             Statement stmt  = c.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("EnergyComsumer") +  "\t" +
                        rs.getInt("TimePriod") + "\t" +
                        rs.getDouble("UpdatedPowerRating"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
