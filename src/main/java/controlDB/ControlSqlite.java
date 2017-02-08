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
                    " EnergyComsumer CHAR(50) NOT NULL," +
                    " TimePriod      INT    NOT NULL, " +
                    " UpdatedPowerRating    FLOAT     NOT NULL, " +
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
            stmt.close();
            c.close();
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
        sql =  "INSERT INTO " + tableName +
                " VALUES (" +
                dataSet[0] + ", " +
                dataSet[1] + ", " +
                dataSet[2] + ", " +
                dataSet[3] + ", " +
                dataSet[4] + ", " +
                dataSet[5] + ", " +
                dataSet[6] + ")";
        stmt.executeUpdate(sql);
    }

    public void UpdateData(String tableName){

    }

    public void DisplayTable(String tableName){

    }
}
