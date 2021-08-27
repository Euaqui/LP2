//SEGUE ARQUIVO  '.PNG'
//https://user-images.githubusercontent.com/88299200/131145973-785f8bc1-7efd-4706-8eec-76e90981d5e3.png

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1,e2,e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
	this.e2 = new Ellipse(70,100, 130,30);
	this.e3 = new Ellipse(150,150, 30,90);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
	this.e2.paint(g);
	this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(139,0,139));
	g2d.fillOval(50,50, 100,30);
	g.setColor(new Color(255,255,0));
        g2d.draw(new Ellipse2D.Double(50,50, 100,30));

	g.setColor(new Color(0,245,255));
	g2d.fillOval(150,150, 30,90);
	g.setColor(new Color(255,215,0));
	g2d.draw(new Ellipse2D.Double(150,150, 30,90));


	g.setColor(new Color(255,0,0));
	g2d.fillOval(70,100, 130,30);
	g.setColor(new Color(0,255,0));
        g2d.draw(new Ellipse2D.Double(70,100, 130,30));

	
    }
}
