package errorandexception.maintask.student;

import errorandexception.maintask.exception.NoSubjectsException;
import errorandexception.maintask.univercity.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Student {
  private static int newId = 0;
  private final int id = newId++;
  private final String firstName;
  private final String lastName;
  private final RecordBook recordBook;
  private Faculty faculty;
  private static final List<Student> allStudentsList = new ArrayList<>();

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.recordBook = new RecordBook();

    allStudentsList.add(this);
  }

  public RecordBook getRecordBook() {
    return recordBook;
  }

  public static RecordBook getRecordBookByStudentId(int Id) {
    return allStudentsList.get(Id).getRecordBook();
  }

  public void setFaculty (Faculty faculty) {
    this.faculty = faculty;
  }

  public static void checkStudentsWithoutSubjects() throws NoSubjectsException {
    for (int i = 0; i < Student.allStudentsList.size(); i++) {
      if (Student.getRecordBookByStudentId(i).getRecordBook().keySet().isEmpty()) {
        throw new NoSubjectsException("One or more students have no subjects!");
      }
    }
  }

  @Override
  public String toString() {
    return "\nStudent{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", recordBook=" + recordBook +
               ", faculty=" + faculty +
               '}';
  }
}
