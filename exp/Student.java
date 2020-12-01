package exp;

public class Student extends Person {
    private String sid;
    private String major;

    Student(String sid, String name, String sex, int age, String major) {
        super(name, sex, age);
        this.sid = sid;
        this.major = major;
    }

    Student() {
        super("", "", 0);
        this.sid = "";
        this.major = "";
    }

    String getSid() {
        return sid;
    }

    String getMajor() {
        return major;
    }

    void setSid(String sid) {
        this.sid = sid;
    }

    void setMajor(String major) {
        this.major = major;
    }

    void display(Student student) {
        super.display(student);
        System.out.println("Sid: " + student.getSid());
        System.out.println("Major: " + student.getMajor());
    }
}