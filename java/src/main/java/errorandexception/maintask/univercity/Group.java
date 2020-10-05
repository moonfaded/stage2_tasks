package errorandexception.maintask.univercity;

import errorandexception.maintask.exception.NoFacultiesException;
import errorandexception.maintask.exception.NoGroupsOfFacultyException;
import errorandexception.maintask.exception.NoStudentsInGroupException;
import errorandexception.maintask.exception.NoSubjectsException;
import errorandexception.maintask.student.Student;

import java.util.*;

public class Group {
  private final Faculty faculty;
  private final int groupNumber;
  private static List<List<Student>> groupsList = new ArrayList<>();
  private static List<Group> groupListAsGroups = new ArrayList<>();
  private List<Student> studentListOfGroup = new ArrayList<>();

  public Group(int groupNumber, Faculty faculty, Student... students) {
    this.groupNumber = groupNumber;
    this.faculty = faculty;

    studentListOfGroup.addAll(Arrays.asList(students));
    groupsList.add(studentListOfGroup);
    groupListAsGroups.add(this);

    for (Student student : students) {
      student.setFaculty(faculty);
      switch (faculty) {
        case MILITARY: {
          student.getRecordBook()
              .addSubjectToRecordBook(Subject.MATH)
              .addSubjectToRecordBook(Subject.DANCE)
              .addSubjectToRecordBook(Subject.LOGIC);
          break;
        }
        case INFOCOMMUNICATIONS: {
          student.getRecordBook()
              .addSubjectToRecordBook(Subject.MATH)
              .addSubjectToRecordBook(Subject.DESIGN)
              .addSubjectToRecordBook(Subject.SPORT);
          break;
        }
        default: {
          System.out.println("Subjects setting error!");
          break;
        }
      }
    }
  }

  public List<Student> getStudentsByGroup() {
    return studentListOfGroup;
  }

  public static List<List<Student>> getGroupsList() {
    return groupsList;
  }

  public static void checkGroupsWithoutStudents() throws NoStudentsInGroupException {
    for (List<Student> group : groupsList) {
      if (group.isEmpty()) {
        throw new NoStudentsInGroupException("One or more groups contains no students!");
      }
    }
  }

  public Faculty getGroupFaculty() {
    return faculty;
  }

  public static void checkFacultiesWithoutGroups() throws NoGroupsOfFacultyException {
    List<Faculty> allFacultiesList = new LinkedList<>(Arrays.asList(Faculty.values()));
    List<Faculty> usedFacultiesList = new ArrayList<>();
    for (int i = 0; i < groupsList.size(); i++) {
      usedFacultiesList.add(groupListAsGroups.get(i).getGroupFaculty());
    }
    allFacultiesList.removeAll(usedFacultiesList);
    if (!allFacultiesList.isEmpty()) {
      throw new NoGroupsOfFacultyException("One or more faculties are unused!");
    }
  }

  public static void checkForEmptyFacultiesList() throws NoFacultiesException {
    List<Faculty> allFacultiesList = Arrays.asList(Faculty.values());
    if (allFacultiesList.isEmpty()) {
      throw new NoFacultiesException ("There are no faculties!");
    }
  }

  @Override
  public String toString() {
    return "Group{" +
               "faculty=" + faculty +
               ", groupNumber=" + groupNumber +
               ", studentListOfGroup=" + studentListOfGroup +
               '}';
  }
}
