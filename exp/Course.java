package exp;

public class Course {
    private String cname;
    private String cid;
    private int chour;

    Course(String cid, String cname, int chour) {
        this.cid = cid;
        this.cname = cname;
        this.chour = chour;
    }

    Course() {
        this.cid = "";
        this.cname = "";
        this.chour = 0;
    }

    String getCid() {
        return cid;
    }

    String getCname() {
        return cname;
    }

    int getChour() {
        return chour;
    }

    void setCid(String cid) {
        this.cid = cid;
    }

    void setCname(String cname) {
        this.cname = cname;
    }

    void setChour(int chour) {
        this.chour = chour;
    }

    void display(Course course) {
        System.out.println("Cid: " + course.getCid());
        System.out.println("Cname: " + course.getCname());
        System.out.println("Chour: " + course.getChour());
    }
}
