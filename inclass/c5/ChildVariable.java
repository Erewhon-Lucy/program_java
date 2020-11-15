package inclass.c5;

public class ChildVariable extends ParentVariable {
    String instanceVariable = "child variable";
    public void printInstanceVariable() {
    System.out.println(instanceVariable);
    }
    public static void main(String[] args) {
    ParentVariable childVariable = new ChildVariable();
    childVariable.printInstanceVariable();
    }
}