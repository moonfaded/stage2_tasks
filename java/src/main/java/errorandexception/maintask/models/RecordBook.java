package errorandexception.maintask.models;

import errorandexception.maintask.exceptions.WrongMarkException;
import errorandexception.maintask.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordBook {
  private Map<Subject, List<Integer>> recordBook = new HashMap<>();

  public Map<Subject, List<Integer>> getRecordBook() {
    return recordBook;
  }

  public RecordBook addSubjectToRecordBook(Subject subject) {
    recordBook.put(subject, new ArrayList<>());
    return this;
  }

  public void addMarksToSubject(Subject subject, int ... marks) throws WrongMarkException {
    for (int mark: marks) {
      if (mark >= 1 && mark <= 10) {
        recordBook.get(subject).add(mark);
      }
      else {
        throw new WrongMarkException("Incorrect mark!");
      }
    }
  }

  public double getAverageMarkBySubject(Subject subject) {
    if (recordBook.containsKey(subject)) {
      return recordBook.get(subject).stream().mapToInt(value -> value).average().orElse(-1);
    }
    else {
      return -1;
    }
  }

  public double getAverageMarkByStudent() {
    List<Integer> allMarks = new ArrayList<>();
    for (List<Integer> element : recordBook.values()) {
      allMarks.addAll(element);
    }
    return allMarks.stream().mapToInt(value -> value).average().orElse(-1);
  }

  public static double getAverageMarkBySubjectByGroup(Subject subject, Group group) {
    List<Integer> allMarks = new ArrayList<>();
    for (Student student : group.getStudentList()) {
      if (student.getRecordBook().recordBook.containsKey(subject)) {
        allMarks.addAll(student.getRecordBook().recordBook.get(subject));
      }
    }
    return allMarks.stream().mapToDouble(value -> value).average().orElse(-1);
  }
  public static double getAverageMarkByAllFaculties(Subject subject) {
    List<Integer> allMarks = new ArrayList<>();
    for (Faculty faculty: Univercity.getFaculties()) {
      for (Group group : faculty.getGroupList()) {
        for (Student student : group.getStudentList()) {
          if (student.getRecordBook().recordBook.containsKey(subject)) {
            allMarks.addAll(student.getRecordBook().recordBook.get(subject));
          }
        }
      }
    }
    return allMarks.stream().mapToDouble(value -> value).average().orElse(-1);
  }
}
