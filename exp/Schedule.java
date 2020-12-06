package exp;

public class Schedule {
    private String classid;
    private String cid;
    private String tid;
    private String classroom;

    Schedule(String classid, String cid, String tid, String classroom) {
        this.classid = classid;
        this.cid = cid;
        this.tid = tid;
        this.classroom = classroom;
    }

    Schedule() {
        this.classid = "";
        this.cid = "";
        this.tid = "";
        this.classroom = "";
    }

    String getClassid() {
        return classid;
    }

    String getCid() {
        return cid;
    }

    String getTid() {
        return tid;
    }

    String getClassroom() {
        return classroom;
    }

    void setClassid(String classid) {
        this.classid = classid;
    }

    void setCid(String cid) {
        this.cid = cid;
    }

    void setTid(String tid) {
        this.tid = tid;
    }

    void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    void display(Schedule schedule) {
        System.out.println("Classid: " + schedule.getClassid());
        System.out.println("Cid: " + schedule.getCid());
        System.out.println("Tid: " + schedule.getTid());
        System.out.println("Classroom: " + schedule.getClassroom());
    }
}
