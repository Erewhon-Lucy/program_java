package exp;

public class Person {
    protected String name;
    protected String sex;
    protected int age;

    Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    Person() {
        this.name = "";
        this.sex = "";
        this.age = 0;
    }

    String getName() {
        return name;
    }

    String getSex() {
        return sex;
    }

    int getAge() {
        return age;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSex(String sex) {
        this.sex = sex;
    }

    void setAge(int age) {
        this.age = age;
    }

    void display(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Sex: " + person.getSex());
        System.out.println("Age: " + person.getAge());
    }
}
