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
    public Connection c  = null;
    public Statement stmt = null;
    public String sql = null;
    public ControlSqlite(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Data.db");
            System.out.println("Opened database successfully");

            //create DataInput database to reord all the data input
            stmt = c.createStatement();
            sql = "CREATE TABLE if not exists ENERGYDATA " +
                    " (EnergyComsumer CHAR(50) NOT NULL," +
                    " TimePriod      INT    NOT NULL, " +
                    " UpdatedPowerRating    DOUBLE     NOT NULL, " +
                    " Location        CHAR(50), " +
                    " TotalConsumption     DOUBLE NOT NULL," +
                    " TotalEstimatedEmissions DOUBLE NOT NULL," +
                    " Temperature DOUBLE )";
            stmt.executeUpdate(sql);

            //The table for Light
            //stmt = c.createStatement();
            sql = "CREATE TABLE if not exists Light " +
                    "(ID     INT PRIMARY KEY NOT NULL,"+
                    " PowerRating    FLOAT     NOT NULL, " +
                    " Location        CHAR(50), " +
                    " Consumption     DOUBLE NOT NULL," +
                    " EstimatedEmissions DOUBLE NOT NULL," +
                    " TotalNumber    Int)";
            stmt.executeUpdate(sql);

            //The table for Heating
            //stmt = c.createStatement();
            sql = "CREATE TABLE if not exists Heating " +
                    "(ID     INT PRIMARY KEY NOT NULL,"+
                    " PowerRating    FLOAT     NOT NULL, " +
                    " Location        CHAR(50), " +
                    " Consumption     DOUBLE NOT NULl," +
                    " EstimatedEmissions DOUBLE NOT NULL," +
                    " TotalNumber     Int)";
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

    public void InsertData(String tableName, Object[] dataSet) throws SQLException {
        //insert new data

        /*sql =  "INSERT INTO " + tableName +
                " VALUES (" +
                dataSet[0].toString() + ", " +
                dataSet[1].toString() + ", " +
                dataSet[2].toString() + ", " +
                dataSet[3].toString() + ", " +
                dataSet[4].toString() + ", " +
                dataSet[5].toString() + ", " +
                dataSet[6].toString() + ")";*/
        sql = "INSERT INTO "+ tableName + " VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, (String)dataSet[0]);
            pstmt.setInt(2, (Integer)dataSet[1]);
            pstmt.setDouble(3, (Double)dataSet[2]);
            pstmt.setString(4, (String)dataSet[3]);
            pstmt.setDouble(5, (double)dataSet[4]);
            pstmt.setDouble(6, (double)dataSet[5]);
            pstmt.setDouble(7, (double)dataSet[6]);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
