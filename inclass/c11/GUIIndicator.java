package inclass.c11;

import java.awt.*;

import java.awt.event.*;
import javax.swing.JProgressBar;

public class GUIIndicator {
    static Frame f = new Frame();
    static Button b = new Button("Click me!!");
    static Label l = new Label();
    static JProgressBar p = new JProgressBar();

    public static void main(String[] args) {
        f.add(b);
        f.add(l);
        f.add(p);
        p.setVisible(false);
        f.pack();
        f.setSize(350, 250);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        ActionListener listener =
                new MyActionListener(l, p, b);
        b.addActionListener(listener);
    }
}

class MyActionListener implements ActionListener {
    Label l;
    JProgressBar p;
    Button b;
    int i;

    MyActionListener(Label l, JProgressBar p, Button b) {
        this.l = l;
        this.b = b;
        this.p = p;
    }

    public void actionPerformed(ActionEvent e) {
        new Thread() {
            public void run() {
                try {
                    b.setEnabled(false);
                    p.setValue(0);
                    p.setVisible(true);
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        p.setValue(p.getValue() + 20);
                    }
                    Thread.sleep(200);
                    p.setVisible(false);
                    l.setText("Button have been clicked "
                            + ++i + " times.");
                    b.setEnabled(true);
                } catch (InterruptedException e1) {
                }
            }
        }.start();
    }
}
