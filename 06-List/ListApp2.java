//ELIPSES
//Segue arquivo ".PNG"
//https://user-images.githubusercontent.com/88299200/132219368-ea9bdfa7-b9cd-4eb4-9cc6-ba23c42070a7.png

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class ListApp2 {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Ellipse> el = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        el.add(new Ellipse(x,y, w,h));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );

        this.setTitle("Lista de Elipses");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Ellipse e: this.el) {
            e.paint(g);
        }
    }
}
