package homework_testing.fifth;

public class Staff extends Person {
    private String school;
    private double pay;
    Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public double getPay() {
        return pay;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    public String toString() {
        return "Staff[Person[name=" + getName() + ",address=" + getAddress()
                + "],school=" + getSchool() + ",pay=" + getPay() + "]";
    }

    public static void main(String[] args) {
        System.out.println("test Staff ***************************************");
        Staff s2 = new Staff("Timmy", "Chengdu", "UESTC-Qingshuihe", 66.66);
        System.out.println("Show the Staff s2's information :");
        System.out.println(s2.toString());
        System.out.println("Change s2's school");
        s2.setSchool("UESTC-Shahe");
        System.out.println("Now s2's school is : " + s2.getSchool());
        System.out.println("Change s2's pay");
        s2.setPay(99.99);
        System.out.println("Now s2's pay is : " + s2.getPay());
    }
}