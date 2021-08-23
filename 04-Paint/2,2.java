//SEGUE ARQUIVO  '.PNG'
//https://user-images.githubusercontent.com/88299200/130461716-380faa4e-e90c-47f4-b8fd-6a30c871710b.png

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
    Ellipse e1;

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
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
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
	      g2d.fillOval(this.x,this.y, this.w,this.h);
	      g.setColor(new Color(255,255,0));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	      g.setColor(new Color(0,245,255));
	      g2d.fillOval(100,150, 50,150);
	      g.setColor(new Color(255,0,0));
	      g2d.fillOval(150,300, 150,150);
	      g.setColor(new Color(0,255,0));
        g2d.draw(new Ellipse2D.Double(150,300, 150,150));
	      g.setColor(new Color(255,215,0));
	      g2d.fillOval(200,40, 50,50);
    }
}