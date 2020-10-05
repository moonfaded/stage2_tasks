package errorandexception.maintask.student;

import errorandexception.maintask.exception.NoSubjectsException;
import errorandexception.maintask.exception.WrongMarkException;
import errorandexception.maintask.univercity.Group;
import errorandexception.maintask.univercity.Subject;

import java.util.*;

public class RecordBook {
  private final Map<Subject, List<Integer>> recordBook = new HashMap<>();

  public RecordBook addSubjectToRecordBook(Subject subject) {
    recordBook.put(subject, new ArrayList<>());
    return this;
  }

  public Map<Subject, List<Integer>> getRecordBook() {
    return recordBook;
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
    return recordBook.get(subject).stream().mapToInt(value -> value).average().orElse(-1);
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
    for (Student student : group.getStudentsByGroup()) {
      if (student.getRecordBook().recordBook.containsKey(subject)) {
        allMarks.addAll(student.getRecordBook().recordBook.get(subject));
      }
    }
    return allMarks.stream().mapToDouble(value -> value).average().orElse(-1);
  }

  public static double getAverageMarkByAllFaculties(Subject subject) {
    List<Integer> allMarks = new ArrayList<>();
    for (List<Student> groupAsList : Group.getGroupsList()) {
      for (Student student : groupAsList) {
        if (student.getRecordBook().recordBook.containsKey(subject)) {
          allMarks.addAll(student.getRecordBook().recordBook.get(subject));
        }
      }
    }
    return allMarks.stream().mapToDouble(value -> value).average().orElse(-1);
  }

  @Override
  public String toString() {
    return "" + Arrays.asList(recordBook);
  }
}
