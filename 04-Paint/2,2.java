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
        this.e1 = new Ellipse(50,100, 100,30, 139,0,139, 255,255,0);
	this.e2 = new Ellipse(70,100, 130,30, 0,245,255, 255,215,0);
	this.e3 = new Ellipse(150,150, 30,90, 255,0,0, 0,255,0);
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
    int a, b, c, a1, b1, c1;

    Ellipse (int x, int y, int w, int h, int a, int b, int c, int a1, int b1, int c1) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.a = a;
	this.b = b;
	this.c = c;
	this.a1 = a1;
	this.b1 = b1;
	this.c1 = c1;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(this.a,this.b,this.c));
	g2d.fillOval(this.x,this.y, this.w,this.h);
	g.setColor(new Color(this.a1,this.b1,this.c1));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));

	
    }
}
