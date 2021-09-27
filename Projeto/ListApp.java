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
	this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    pMouse = getMousePosition();
                    foco = null;
                    for (Figure fig: figs){ 
                        if (fig.clicked(pMouse.x,pMouse.y)){
                            foco = fig;
                        }
			if (foco!=null){
			    figs.add(foco);
			    figs.remove(foco);			    
			}
			repaint();
                    }
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
		    pMouse = getMousePosition();
                    int x = pMouse.x;
		    int y = pMouse.y;
                    int w = 70;
                    int h = 70;

                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h, Color.yellow, Color.green);
                        figs.add(r);

                    } 

		    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, Color.green, Color.red));

                    }  

		    if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, w,h, Color.red, Color.blue));

		    } 

		    if (evt.getKeyChar() == 'p') {
                        figs.add(new Pentagon(x,y, w,h, Color.blue, Color.yellow));
		    }
		      
		    if(evt.getKeyCode() == 127){
			figs.remove(foco);
		    }
                    repaint();
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
    }
}
