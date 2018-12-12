package sample;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.plaf.nimbus.State;

/**
 * @author Larson
 */
public class DBUtil {

  // Establish connection
  private static Connection connection = null;
  final static String DATABASE_URL = "jdbc:derby:lib\\tester";

  // connect
  public static void dbConnect() throws SQLException, ClassNotFoundException {
    // Establish connection with Connection String
    try {
      connection = DriverManager.getConnection(DATABASE_URL);
    } catch (SQLException e) {
      System.out.println("Connection Failed" + e);
      e.printStackTrace();
      throw e;
    }
  }

  // Close connection
  public static void dbDisconnect() throws SQLException {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  // DB Execute query
  public static ResultSet dbExecuteQuery(String querystmt)
      throws SQLException, ClassNotFoundException {
    Statement stmt = null;
    ResultSet resultSet = null;
    CachedRowSetImpl crs = null;
    try {
      dbConnect();
      System.out.println("Select Statement: " + querystmt + "\n");
      stmt = connection.createStatement();
      resultSet = stmt.executeQuery(querystmt);
      crs = new CachedRowSetImpl();
      crs.populate(resultSet);
    } catch (SQLException e) {
      System.out.println("Problem at executeQuery : " + e);
      throw e;
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (stmt != null) {
        stmt.close();
      }
      dbDisconnect();
    }
    return crs;
  }

  public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
    Statement stmt = null;
    try {
      dbConnect();
      stmt = connection.createStatement();
      stmt.executeUpdate(sqlStmt);
    } catch (SQLException e) {
      System.out.println("Problem at executeUpdate : " + e);
      throw e;
    } finally {
      if (stmt != null) {
        stmt.close();
      }
      dbDisconnect();
    }
  }
}






