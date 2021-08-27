//Segue arquivos  '.PNG'
//tarefa 3.1) https://user-images.githubusercontent.com/88299200/131157998-34b7e803-5caa-46fa-aa7f-524d7c5f522a.png

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;


class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Triangle t1;
    Losango l1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
	this.t1 = new Triangle(10,20,30, 150,50,150);
	this.l1 = new Losango(20,30,40,30, 200,245,200,160);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
	this.t1.paint(g);
	this.l1.paint(g);
    }
}
