package errorandexception.maintask.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
  private String facultyName;
  private Univercity univercity;
  private List<Group> groupList = new ArrayList<>();

  public Faculty(String facultyName, Univercity univercity) {
    this.facultyName = facultyName;
    this.univercity = univercity;
    univercity.getFaculties().add(this);
  }

  public String getFacultyName() {
    return facultyName;
  }
  public List<Group> getGroupList() {
    return groupList;
  }
}
