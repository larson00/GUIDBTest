package sample;
/**
 * @author Larson
 * Controller Class. OnAction contains all functionality for the GUI.
 * Connection is made with database "tester" and data is displayed using Labels.
 * resultSet stores the data from the SQL table.
 * Data was gathered from the Madden NFL 2018 team rankings.
 * 11/19/2018
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

  @FXML
  private Label lblTeam;

  @FXML
  private Label lblDivision;

  @FXML
  private Label lblOverall;

  @FXML
  private Label lblOffensive;

  @FXML
  private Label lblDefensive;

  @FXML
  private Label lblStarter;

  @FXML
  void viewTeam(ActionEvent event) {
    // Connect to the database
    final String DATABASE_URL = "jdbc:derby:lib\\tester";
    final String SELECT_QUERY =
        "SELECT name, division, overallRank, offensiveRank, defensiveRank, starterRank FROM teams";

    // use try-with-resources to connect to and query the database
    try (
        Connection connection = DriverManager.getConnection(
            DATABASE_URL, "", "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
      // get ResultSet's meta data
      {
        //ResultSet object.
        resultSet.next();
        lblTeam.setText(resultSet.getString(1));
        lblDivision.setText(resultSet.getString(2));
        lblOverall.setText(resultSet.getString(3));
        lblOffensive.setText(resultSet.getString(4));
        lblDefensive.setText(resultSet.getString(5));
        lblStarter.setText(resultSet.getString(6));


      }
    } // AutoCloseable objects' close methods are called now
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } catch (Exception ex) {
      System.out.println("Error");
    }

  }

}
