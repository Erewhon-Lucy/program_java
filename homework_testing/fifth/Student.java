package homework_testing.fifth;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;
    Student(String name, String address, String program, int year, double fee) {
        super(name,address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public String toString() {
        return "Student[Person[name=" + getName() + ",address="
                + getAddress() + "],program=" + getProgram() + ",year="
                + getYear() + ",fee=" + getFee() + "]";
    }

    public static void main(String[] args) {
        System.out.println("test Student *************************************");
        Student s1 = new Student("Jack", "Shenzhen", "A", 1,3.14);
        System.out.println("Show the Student s1's information :");
        System.out.println(s1.toString());
        System.out.println("Change s1's program");
        s1.setProgram("B");
        System.out.println("Now s1's program is : " + s1.getProgram());
        System.out.println("Change s1's year");
        s1.setYear(2);
        System.out.println("Now s1's year is : " + s1.getYear());
        System.out.println("Change s1's fee");
        s1.setFee(6.28);
        System.out.println("Now s1's fee is : " + s1.getFee());
    }
}