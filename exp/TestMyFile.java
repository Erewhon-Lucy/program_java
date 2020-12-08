package exp;

import java.io.*;
import java.util.*;

public class TestMyFile {
    protected static int length = 1;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyFile people_file = new MyFile(new File("People.txt"));
        WritePerson(people_file);
        people_file.readFile(people_file.people);

        MyFile studnets_file = new MyFile(new File("Students.txt"));
        WriteStudent(studnets_file);
        studnets_file.readFile(studnets_file.students);

        MyFile teachers_file = new MyFile(new File("Teachers.txt"));
        WriteTeachers(teachers_file);
        teachers_file.readFile(teachers_file.teachers);

        MyFile courses_file = new MyFile(new File("Courses.txt"));
        WriteCourses(courses_file);
        courses_file.readFile(courses_file.courses);

        MyFile schedule_file = new MyFile(new File("Schedule.txt"));
        WriteSchedlue(schedule_file);
        schedule_file.readFile(schedule_file.schedules);

        MyFile elec_file = new MyFile(new File("elec.txt"));
        WriteElec(elec_file);
        elec_file.readFile(elec_file.electivecourses);

        System.out.println("Please enter sid");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sid = bufferedReader.readLine();
        for (int i = 0; i < 5; i++) {          // 通过学号来找选课类
            if (sid.compareTo(elec_file.electivecourses[i].getSid()) == 0) {
                for (int j = 0; j < 5; j++) {         //通过选课类中的classid找schedule， 输出schedule中的classroom
                    if (elec_file.electivecourses[i].getClassid().compareTo(schedule_file.schedules[j].getClassid()) == 0) {
                        System.out.println("classroom is " + schedule_file.schedules[j].getClassroom());
                        for (int k = 0; k < 5; k++) {           //通过schedule中的cid找course
                            if (schedule_file.schedules[j].getCid().compareTo(courses_file.courses[k].getCid()) == 0) {
                                System.out.println("course name is " + courses_file.courses[k].getCname());    //输出课程名称
                            }
                        }
                        for (int k = 0; k < 5; k++) {     //通过schedule中的tid找teacher
                            if (schedule_file.schedules[j].getTid().compareTo(teachers_file.teachers[k].getTid()) == 0) {
                                System.out.println("teacher's name is " + teachers_file.teachers[k].getName());
                            }
                        }
                    }
                }
            }
        }
        System.out.println("If not information output, it means sid not found");
    }

    private static void WritePerson(MyFile myfile) throws IOException {

        String s = new String();
        String name = new String();
        String sex = new String();
        int age;
        for (int j = 0; j < myfile.people.length; j++)
            myfile.people[j] = new Person(null, null, 0);
        System.out.println("please enter the " + length + " person's information, press F to quit");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.people[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.people[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.people[i].setAge(age);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.people[i]);
            i++;
        }
    }

    private static void WriteStudent(MyFile myfile) throws IOException {
        String s = new String();
        String name = new String();
        String sex = new String();
        String sid = new String();
        String major = new String();
        int age;
        for (int j = 0; j < myfile.students.length; j++)
            myfile.students[j] = new Student();
        length = 1;
        System.out.println("Please enter the " + length + "student's information, press F to quit.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.students[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.students[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.students[i].setAge(age);

            System.out.println("please enter sid: ");
            sid = bufferedReader.readLine();
            myfile.students[i].setSid(sid);

            System.out.println("please enter major: ");
            major = bufferedReader.readLine();
            myfile.students[i].setMajor(major);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.students[i]);
            i++;
        }
    }

    private static void WriteTeachers(MyFile myfile) throws IOException {
        String s = new String();
        String name = new String();
        String sex = new String();
        String tid = new String();
        String title = new String();
        int age;
        for (int j = 0; j < myfile.teachers.length; j++)
            myfile.teachers[j] = new Teacher();
        length = 1;
        System.out.println("please enter the " + length + "teacher's information: ");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.teachers[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.teachers[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.teachers[i].setAge(age);

            System.out.println("please enter tid: ");
            tid = bufferedReader.readLine();
            myfile.teachers[i].setTid(tid);

            System.out.println("please enter title: ");
            title = bufferedReader.readLine();
            myfile.teachers[i].setTitle(title);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.teachers[i]);
            i++;
        }
    }

    private static void WriteCourses(MyFile myfile) throws IOException {
        String s = new String();
        String cname = new String();
        String cid = new String();
        int chour;
        for (int j = 0; j < myfile.teachers.length; j++)
            myfile.courses[j] = new Course(null, null, 0);
        length = 1;
        System.out.println("please enter the " + length + "course's information, press F to quit.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter course name: ");
            cname = bufferedReader.readLine();
            myfile.courses[i].setCname(cname);

            System.out.println("please enter course id: ");
            cid = bufferedReader.readLine();
            myfile.courses[i].setCid(cid);

            System.out.println("please enter course hour: ");
            chour = Integer.parseInt(bufferedReader.readLine());
            myfile.courses[i].setChour(chour);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.courses[i]);
            i++;
        }
    }

    private static void WriteSchedlue(MyFile myfile) throws IOException {
        String s = new String();
        String classid = new String();
        String cid = new String();
        String tid = new String();
        String classroom = new String();
        for (int j = 0; j < myfile.schedules.length; j++)
            myfile.schedules[j] = new Schedule(null, null, null, null);
        length = 1;
        System.out.println("please enter the" + length + "Schedule's information press F to quit.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter class id: ");
            classid = bufferedReader.readLine();
            myfile.schedules[i].setClassid(classid);

            System.out.println("please enter course id: ");
            cid = bufferedReader.readLine();
            myfile.schedules[i].setCid(cid);

            System.out.println("please enter teacher's id: ");
            tid = bufferedReader.readLine();
            myfile.schedules[i].setTid(tid);

            System.out.println("please enter classroom: ");
            classroom = bufferedReader.readLine();
            myfile.schedules[i].setClassroom(classroom);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.schedules[i]);
            i++;
        }
    }

    private static void WriteElec(MyFile myfile) throws IOException {
        String s = new String();
        String elid = new String();
        String sid = new String();
        String classid = new String();
        for (int j = 0; j < myfile.electivecourses.length; j++)
            myfile.electivecourses[j] = new Electivecourse(null, null, null);
        length = 1;
        System.out.println("please enter the " + length + "elective course's information, press F to quit.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter elective course id: ");
            elid = bufferedReader.readLine();
            myfile.electivecourses[i].setElid(elid);

            System.out.println("please enter sid: ");
            sid = bufferedReader.readLine();
            myfile.electivecourses[i].setSid(sid);

            System.out.println("please enter class id: ");
            classid = bufferedReader.readLine();
            myfile.electivecourses[i].setClassid(classid);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.electivecourses[i]);
            i++;
        }
    }

}