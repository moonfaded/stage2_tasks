package errorandexception.maintask.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
  private int groupNumber;
  private Univercity univercity;
  private Faculty faculty;
  private List<Student> studentList = new ArrayList<>();

  public Group(int groupNumber, Univercity univercity, Faculty faculty) {
    this.groupNumber = groupNumber;
    this.univercity = univercity;
    this.faculty = faculty;
    faculty.getGroupList().add(this);
  }

  public List<Student> getStudentList() {
    return studentList;
  }
}
