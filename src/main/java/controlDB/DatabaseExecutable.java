package controlDB;

import java.sql.SQLException;

/**
 * This interface is used to communicate the data input
 * with the database
 * (e.g. when add a light in simulation window, the data input and collected
 * will be inserted in database)
 * Created by Rui on 2017/2/5.
 */
public interface DatabaseExecutable {
    /**
     * Insert a new data into tableName
     * primarily used on DataInput
     * @param tableName
     */
    public void InsertData(String tableName, Object[] dataSet);

    /**
     * update data in tableName
     * primarily used on Light and heating
     * @param tableName
     */
    public void UpdateData(String tableName);

    /**
     * Display all the records in tableName
     * @param tableName
     */
    public void DisplayTable();

    //public ArrayList[] getResult(String sql);
}
