package errorandexception.maintask;

import errorandexception.maintask.exception.*;
import errorandexception.maintask.student.RecordBook;
import errorandexception.maintask.student.Student;
import errorandexception.maintask.univercity.Faculty;
import errorandexception.maintask.univercity.Group;
import errorandexception.maintask.univercity.Subject;

public class Start {
  public static void main(String[] args) throws WrongMarkException {

    Group studentGroup1 = new Group(42493, Faculty.INFOCOMMUNICATIONS,
        new Student("Alexander", "Vladyko"),
        new Student("Yulia", "Bayarskikh")
    );
    Group studentGroup2 = new Group(42491, Faculty.MILITARY,
        new Student("Alexey", "Repety"),
        new Student("Anton", "Ignatovich")
    );

    Student.getRecordBookByStudentId(0).addMarksToSubject(Subject.MATH, 7, 9, 6, 8, 1);
    Student.getRecordBookByStudentId(0).addMarksToSubject(Subject.DESIGN, 10, 10);
    Student.getRecordBookByStudentId(1).addMarksToSubject(Subject.DESIGN, 8, 9);
    Student.getRecordBookByStudentId(1).addMarksToSubject(Subject.SPORT, 4, 6, 6);
    Student.getRecordBookByStudentId(2).addMarksToSubject(Subject.MATH, 10, 2, 3);
    Student.getRecordBookByStudentId(2).addMarksToSubject(Subject.DANCE, 10, 10);
    Student.getRecordBookByStudentId(3).addMarksToSubject(Subject.LOGIC, 8, 9);
    Student.getRecordBookByStudentId(3).addMarksToSubject(Subject.MATH, 4, 6, 6);

    System.out.println("Alexander Vladyko's average math score: "
                           + Student
                                 .getRecordBookByStudentId(0)
                                 .getAverageMarkBySubject(Subject.MATH));

    System.out.println("Alexander Vladyko's average score: "
                           + Student
                                 .getRecordBookByStudentId(0)
                                 .getAverageMarkByStudent());

    System.out.println("Average score by math by student group 1: "
                           + RecordBook
                                 .getAverageMarkBySubjectByGroup(Subject.MATH, studentGroup1));

    System.out.println("Average score by all faculties: "
                           + RecordBook
                                 .getAverageMarkByAllFaculties(Subject.MATH));

    try {
      Student.checkStudentsWithoutSubjects();
      Group.checkGroupsWithoutStudents();
      Group.checkFacultiesWithoutGroups();
      Group.checkForEmptyFacultiesList();
    } catch (NoSubjectsException | NoStudentsInGroupException | NoGroupsOfFacultyException | NoFacultiesException e) {
      e.printStackTrace();
    }
  }
}
