import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.ArrayList;

import figures.*;

//baseado no listapp3

class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure foco = null;
    Point pMouse = null;

    int xf,yf;
    int contorno = 0;
    int baldinhodopaint = 0;
    Color paleta[] = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK, Color.GRAY, Color.PINK, Color.ORANGE, Color.MAGENTA};
    

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
                    try{
                        int x = evt.getX();
                        int y = evt.getY();
                        pMouse = getMousePosition();
                        foco = null;
                        for (Figure fig: figs){
                            if (fig.clicked(pMouse.x,pMouse.y)){
                                foco = fig;
                                xf = foco.x - pMouse.x;
                                yf = foco.y - pMouse.y;
                            }
                        }
                        if (foco!=null){
                            figs.remove(foco);
                            figs.add(foco);
                        }
                        repaint();
                        
                    }catch(Exception x){}
                    
                }
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent move) {
                    pMouse = getMousePosition();
                    if (foco != null) {
                        figs.remove(foco);
                        figs.add(foco);
                        foco.x = pMouse.x + xf;
                        foco.y = pMouse.y + yf;
                    }
                    repaint();
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

		    if (evt.getKeyChar() == 'c') {
                        figs.add(new Circle(x,y, w,h, Color.green, Color.red));

                    }  

		    if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, w,h, Color.red, Color.blue));

		    } 

		    if (evt.getKeyChar() == 'p') {
                        figs.add(new Pentagon(x,y, w,h, Color.blue, Color.yellow));
		    }

		    if (evt.getKeyChar()=='a'){
                        foco.w+=10;
			foco.h+=10;
                    }

                    if (evt.getKeyChar()=='d'){
			if (foco.w<=10 || foco.h<=10){
                        	foco.w-=0;
				foco.h-=0;
			}
			else{
				foco.w-=10;
				foco.h-=10;
			} 
                    }
		      
		    if(evt.getKeyCode() == 8){
			figs.remove(foco);
		    }
                    repaint();

		    if (evt.getKeyCode() == 32){
                        for( Figure fig: figs){
                            if ((foco == null) || (foco!=null)){
                                foco=fig;
                                figs.remove(foco);
                                figs.add(foco);
                                break;
                            }
                            repaint();
                            

                        }
                        
                    }
		    if(evt.getKeyChar() == 'b'){
                       if (contorno == 9){
                           contorno = 0;
                       }
                       else {
                           contorno++;
                       }
                       foco.borda = paleta[contorno];

                   }
		   repaint();

                   if (evt.getKeyChar() == 'f'){
                       if (baldinhodopaint == 9){
                           baldinhodopaint = 0;
                       }
                       else {
                           baldinhodopaint++;
                       }
                       foco.fundo = paleta[baldinhodopaint];

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
	    if(foco==fig){
		    foco.AchaFoco(g);
	    }
            fig.paint(g);
        }

    }
}
