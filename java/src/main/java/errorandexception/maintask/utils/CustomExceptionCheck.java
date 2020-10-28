package errorandexception.maintask.utils;

import errorandexception.maintask.exceptions.NoFacultiesException;
import errorandexception.maintask.exceptions.NoGroupsOfFacultyException;
import errorandexception.maintask.exceptions.NoStudentsInGroupException;
import errorandexception.maintask.exceptions.NoSubjectsException;
import errorandexception.maintask.models.Faculty;
import errorandexception.maintask.models.Group;
import errorandexception.maintask.models.Student;
import errorandexception.maintask.models.Univercity;

public class CustomExceptionCheck {

  public static void checkForAnyCustomExceptions() throws NoSubjectsException, NoStudentsInGroupException, NoGroupsOfFacultyException, NoFacultiesException {
    checkStudentsWithoutSubjects();
    checkGroupsWithoutStudents();
    checkFacultiesWithoutGroups();
    checkIfThereIsNoFaculties();
  }

  public static void checkStudentsWithoutSubjects() throws NoSubjectsException {
    for (Faculty faculty : Univercity.getFaculties()) {
      for (Group group : faculty.getGroupList()) {
        for (Student student : group.getStudentList()) {
          if (student.getRecordBook().getRecordBook().isEmpty()) {
            throw new NoSubjectsException("One or more students doesn't have any subjects!");
          }
        }
      }
    }
  }

  public static void checkGroupsWithoutStudents() throws NoStudentsInGroupException {
    for (Faculty faculty : Univercity.getFaculties()) {
      for (Group group : faculty.getGroupList()) {
        if (group.getStudentList().isEmpty()) {
          throw new NoStudentsInGroupException("One or more groups contains no students!");
        }
      }
    }
  }

  public static void checkFacultiesWithoutGroups() throws NoGroupsOfFacultyException {
    for (Faculty faculty : Univercity.getFaculties()) {
      if (faculty.getGroupList().isEmpty()) {
        throw new NoGroupsOfFacultyException("One or more faculties have no groups!");
      }
    }
  }

  public static void checkIfThereIsNoFaculties() throws NoFacultiesException {
    if (Univercity.getFaculties().isEmpty()) {
      throw new NoFacultiesException("There are no faculties!");
    }
  }
}
