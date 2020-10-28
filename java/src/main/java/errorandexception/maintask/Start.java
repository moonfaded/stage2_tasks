package errorandexception.maintask;

import errorandexception.maintask.exceptions.*;
import errorandexception.maintask.models.*;
import errorandexception.maintask.utils.CustomExceptionCheck;

public class Start {
  public static void main(String[] args) throws WrongMarkException, NoFacultiesException, NoGroupsOfFacultyException, NoStudentsInGroupException, NoSubjectsException {

    Univercity BSUIR = new Univercity("BSUIR");

    Faculty INFOCOMMUNICATIONS = new Faculty("INFOCOMMUNICATIONS", BSUIR);
    Faculty MILITARY = new Faculty("MILITARY", BSUIR);

    Group n42493 = new Group(42493, BSUIR, INFOCOMMUNICATIONS);
    Group n42491 = new Group(42491, BSUIR, MILITARY);

    Student AV = new Student("Alexander", "Vladyko", BSUIR, INFOCOMMUNICATIONS, n42493);
    Student YB = new Student("Yulia", "Bayarskikh", BSUIR, INFOCOMMUNICATIONS, n42493);
    Student AR = new Student("Alexey", "Repety", BSUIR, MILITARY, n42491);
    Student AI = new Student("Anton", "Ignatovich", BSUIR, MILITARY, n42491);

    AV.getRecordBook().addMarksToSubject(Subject.MATH, 7, 9, 6, 8, 1);
    AV.getRecordBook().addMarksToSubject(Subject.DESIGN, 10, 10);
    YB.getRecordBook().addMarksToSubject(Subject.DESIGN, 8, 9);
    YB.getRecordBook().addMarksToSubject(Subject.SPORT, 4, 6, 6);
    AR.getRecordBook().addMarksToSubject(Subject.MATH, 10, 2, 3);
    AR.getRecordBook().addMarksToSubject(Subject.DANCE, 10, 10);
    AI.getRecordBook().addMarksToSubject(Subject.LOGIC, 8, 9);
    AI.getRecordBook().addMarksToSubject(Subject.MATH, 4, 6, 6);

    CustomExceptionCheck.checkForAnyCustomExceptions();

    System.out.println("Alexander Vladyko's average math score: "
                           + AV.getRecordBook().getAverageMarkBySubject(Subject.MATH));

    System.out.println("Alexander Vladyko's average score: "
                           + AV.getRecordBook().getAverageMarkByStudent());

    System.out.println("Average score by math by student group n42493: "
                           + RecordBook.getAverageMarkBySubjectByGroup(Subject.MATH, n42493));

    System.out.println("Average score by all faculties: "
                           + RecordBook.getAverageMarkByAllFaculties(Subject.MATH));
  }
}
