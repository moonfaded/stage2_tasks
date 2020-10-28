package errorandexception.maintask.models;

public class Student {
  private static int newId = 0;
  private int id = newId++;
  private String firstName;
  private String lastName;
  private Univercity univercity;
  private Faculty faculty;
  private Group group;
  private RecordBook recordBook;

  public Student(String firstName, String lastName, Univercity univercity, Faculty faculty, Group group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.univercity = univercity;
    this.faculty = faculty;
    this.group = group;
    this.recordBook = new RecordBook();
    switch (faculty.getFacultyName()) {
      case "MILITARY": {
        recordBook.addSubjectToRecordBook(Subject.MATH);
        recordBook.addSubjectToRecordBook(Subject.DANCE);
        recordBook.addSubjectToRecordBook(Subject.LOGIC);
        break;
      }
      case "INFOCOMMUNICATIONS": {
        recordBook.addSubjectToRecordBook(Subject.MATH);
        recordBook.addSubjectToRecordBook(Subject.DESIGN);
        recordBook.addSubjectToRecordBook(Subject.SPORT);
        break;
      }
      default: {
        System.out.println("Subjects setting error!");
        break;
      }
    }
    group.getStudentList().add(this);
  }

  public RecordBook getRecordBook() {
    return recordBook;
  }
}
