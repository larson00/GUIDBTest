package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Larson
 */
public class TeamInfo {

  // Declare variables for table columns
  private StringProperty teamName;
  private StringProperty teamDivision;
  private StringProperty overallRank;
  private StringProperty offensiveRank;
  private StringProperty defensiveRank;
  private StringProperty starterRank;

  // Constructor
  public TeamInfo() {
    this.teamName = new SimpleStringProperty();
    this.teamDivision = new SimpleStringProperty();
    this.overallRank = new SimpleStringProperty();
    this.offensiveRank = new SimpleStringProperty();
    this.defensiveRank = new SimpleStringProperty();
    this.starterRank = new SimpleStringProperty();
  }


  public String getTeamName() {
    return teamName.get();
  }

  public StringProperty teamNameProperty() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName.set(teamName);
  }

  public String getTeamDivision() {
    return teamDivision.get();
  }

  public StringProperty teamDivisionProperty() {
    return teamDivision;
  }

  public void setTeamDivision(String teamDivision) {
    this.teamDivision.set(teamDivision);
  }

  public String getOverallRank() {
    return overallRank.get();
  }

  public StringProperty overallRankProperty() {
    return overallRank;
  }

  public void setOverallRank(String overallRank) {
    this.overallRank.set(overallRank);
  }

  public String getOffensiveRank() {
    return offensiveRank.get();
  }

  public StringProperty offensiveRankProperty() {
    return offensiveRank;
  }

  public void setOffensiveRank(String offensiveRank) {
    this.offensiveRank.set(offensiveRank);
  }

  public String getDefensiveRank() {
    return defensiveRank.get();
  }

  public StringProperty defensiveRankProperty() {
    return defensiveRank;
  }

  public void setDefensiveRank(String defensiveRank) {
    this.defensiveRank.set(defensiveRank);
  }

  public String getStarterRank() {
    return starterRank.get();
  }

  public StringProperty starterRankProperty() {
    return starterRank;
  }

  public void setStarterRank(String starterRank) {
    this.starterRank.set(starterRank);
  }


}
