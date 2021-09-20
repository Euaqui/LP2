import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;


class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure foco = null;
    Point pMouse = null;
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
                    int x = rand.nextInt(350);
		    int x2 = rand.nextInt(350);
		    int x3 = rand.nextInt(350);
                    int y = rand.nextInt(350);
		    int y2 = rand.nextInt(350);
		    int y3 = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h);
                        figs.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
                    } else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,x2,x3, y,y2,y3));
		    } else if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, x2,y2));
		    }
		      else if(evt.getKeyCode() == 007){
			figs.remove(foco);
		    }
                    repaint();
                }
            }
        );
	this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    pMouse = getMousePosition();
                    foco = null;
                    for (Figure fig: this.figs){ // problema com o this.figs
                        if (fig.clicked(pMouse.x,pMouse.y)){ //ainda nao consegui resolver o problema com o fig.clicked
                            foco = fig;
                        }
                    }
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
// lembrete: trabalhar melhor a parte de cor de fundo e borda 
    }
}
