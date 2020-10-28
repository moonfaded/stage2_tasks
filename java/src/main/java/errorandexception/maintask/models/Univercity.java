package errorandexception.maintask.models;

import java.util.ArrayList;
import java.util.List;

public class Univercity {
  private String univercityName;
  private static List<Faculty> faculties = new ArrayList<>();

  public Univercity(String univercityName) {
    this.univercityName = univercityName;
  }

  public static List<Faculty> getFaculties() {
    return faculties;
  }
}
