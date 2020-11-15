package homework_testing.fifth;

class Person {
    private String name;
    private String address;
    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String toString() {
        return "Person[name=" + name +",address=" + address + "]";
    }
    public static void main(String[] args) {
        System.out.println("test Person **********************************");
        Person p = new Person("Person's name", "Person's address1");
        System.out.println("Show this Person's information : ");
        System.out.println(p.toString());
        System.out.println("Change the Person's address");
        p.setAddress("Person's address2");
        System.out.println("Now the Person's address is : " + p.getAddress());
    }
}