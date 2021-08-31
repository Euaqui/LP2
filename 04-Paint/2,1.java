//ARQUIVO .PNG  AQUI
//https://user-images.githubusercontent.com/88299200/130379093-e6b26410-adea-41d8-8ae8-3d6253f85a38.png

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, 139,0,139, 255,255,0);
	this.r2 = new Rect(100,150, 50,150, 0,245,255, 255,0,0);
	this.r3 = new Rect(150,300, 150,150, 255,215,0, 0,255,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
	this.r2.paint(g);
	this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h, int a, int b, int c, int a1, int b1, int c1) {
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
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(this.a,this.b,this.c));
	g2d.fillRect(this.x,this.y, this.w,this.h);
	g.setColor(new Color(this.a1,this.b1,this.c1));
        g2d.drawRect(this.x,this.y, this.w,this.h);
	
    }
}
