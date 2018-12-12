package sample;
/**
 * @author Larson Controller Class. OnAction contains all functionality for the GUI. Connection is
 * made with database "tester" and data is displayed using Labels. resultSet stores the data from
 * the SQL table. Data was gathered from the Madden NFL 2019 team rankings. 11/19/2018
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class Controller {

  // Observable list for teamList
  private ObservableList<TeamInfo> teamList = FXCollections.observableArrayList();


  @FXML
  private AnchorPane anchor;

  @FXML
  private ComboBox<TeamInfo> comboBox;

  @FXML
  private TableColumn<TeamInfo, String> teamColumn;

  @FXML
  private TableColumn<TeamInfo, String> divisionColumn;

  @FXML
  private TableColumn<TeamInfo, String> overallColumn;

  @FXML
  private TableColumn<TeamInfo, String> offenseColumn;

  @FXML
  private TableColumn<TeamInfo, String> defenseColumn;

  @FXML
  private TableColumn<TeamInfo, String> starterColumn;

  @FXML
  private Button viewTeam;

  @FXML
  private Button updateRank;

  @FXML
  private TableView<TeamInfo> teamTable;

  @FXML
  private ComboBox<?> comboTest;

  @FXML
  void updateRank(ActionEvent event) {
    //fillTable();
    init();
  }

  @FXML
  void viewTeam(ActionEvent event) {
    // Does nothing currently
  }

  @FXML
  void selectTeam(ActionEvent event) {

    //fillTable();
    //init();
  }

  @FXML
  public void init() {
    // Puts the values of teamName into the combobox

    String statement = "SELECT * FROM teams";

    try {
      ResultSet resultSet = DBUtil.dbExecuteQuery(statement);
      while (resultSet.next()) {
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamName(resultSet.getString("name"));
        teamInfo.setTeamDivision(resultSet.getString("division"));
        teamInfo.setOverallRank(resultSet.getString("overallRank"));
        teamInfo.setOffensiveRank(resultSet.getString("offensiveRank"));
        teamInfo.setDefensiveRank(resultSet.getString("defensiveRank"));
        teamInfo.setStarterRank(resultSet.getString("starterRank"));
        teamList.add(teamInfo);


      }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error");
    }
    // Get a list view for the combobox
    // from https://docs.oracle.com/javafx/2/ui_controls/list-view.htm
    Callback<ListView<TeamInfo>, ListCell<TeamInfo>> names = n -> new ListCell<TeamInfo>() {
      @Override
      protected void updateItem(TeamInfo item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? "" : item.getTeamName());
      }
    };
    // Combobox stuff
    comboBox.setCellFactory(names);
    comboBox.setButtonCell(names.call(null));
    comboBox.setItems(teamList);

  }

  private void fillTable() {
    // Get data to the table - not working
    teamColumn.setCellValueFactory(cellData -> cellData.getValue().teamNameProperty());
    divisionColumn.setCellValueFactory(cellData -> cellData.getValue().teamDivisionProperty());
    overallColumn.setCellValueFactory(cellData -> cellData.getValue().overallRankProperty());
    offenseColumn.setCellValueFactory(cellData -> cellData.getValue().offensiveRankProperty());
    defenseColumn.setCellValueFactory(cellData -> cellData.getValue().defensiveRankProperty());
    starterColumn.setCellValueFactory(cellData -> cellData.getValue().starterRankProperty());

    ObservableList<TeamInfo> allTeams = FXCollections.observableArrayList();


    teamTable.setItems(allTeams);

  }
}

