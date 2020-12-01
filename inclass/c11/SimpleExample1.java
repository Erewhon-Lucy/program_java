package inclass.c11;

import java.awt.*;

public class SimpleExample1 extends Frame {
    public static void main(String args[]) {
        Frame f = new Frame();
        Button b = new Button("Click me!!");
        f.add(b);
        f.setSize(300, 100);
        f.setTitle("This is my First AWT example");
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
}