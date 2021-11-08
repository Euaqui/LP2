import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.io.*;

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
    ArrayList<Button> buts = new ArrayList<Button>();
    private static final long serialVersionUID = 1L;
    Figure foco = null;
    Button focoB = null;
    Point pMouse = null;

    private int xf,yf;
    private int contorno = 0;
    private int baldinhodopaint = 0;
    private Color paleta[] = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK, Color.GRAY, Color.PINK, Color.ORANGE, Color.MAGENTA};
    
    @SuppressWarnings("unchecked") 
    ListFrame () {
	try{
	    FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            ArrayList<Figure> object = (ArrayList<Figure>)o.readObject();
	    this.figs = object;
            o.close();
	}catch(Exception x) { System.out.println("ERRO!"); }

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
		    try{
			FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }catch (Exception x){}


                    System.exit(0);
                }
            }
        );
	
	buts.add(new Button(0,new Rect(20,50,20,20,Color.BLACK,Color.BLACK)));
        buts.add(new Button(1,new Circle(20,80,20,20,Color.BLACK,Color.BLACK)));
        buts.add(new Button(2,new Triangle(20,110,20,20,Color.BLACK,Color.BLACK)));
        buts.add(new Button(3,new Pentagon(20,140,20,20,Color.BLACK,Color.BLACK)));
	buts.add(new Button_Delete(4,new Rect(20,170,20,20,Color.BLACK,Color.BLACK)));

	this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    try{

                        int x = evt.getX();
                        int y = evt.getY();
                        pMouse = getMousePosition();
                        foco = null;
			if ((5 <= pMouse.x && pMouse.x <= 50) && (30 <= pMouse.y && pMouse.y <= 210)) {
                            foco=null;
                            for(Button but:buts){
                                if(but.clicked(pMouse.x,pMouse.y)){
                                    focoB = but;
                                }
                                repaint();
                            }
                        }
                        else if(focoB != null){
                            int idx = focoB.idx;
                            pMouse = getMousePosition();
                            int w = 70;
                            int h = 70;
                            
                            if (idx==0){
                                figs.add(new Rect(x,y, w,h,Color.yellow,Color.green));
                            }
                            else if(idx==1){
                                figs.add(new Circle(x,y,w,h,Color.green,Color.red));
                            }
                            else if(idx==2){
                                figs.add(new Triangle(x,y,w,h,Color.red,Color.blue));
                            }
                            else if(idx==3){
                                figs.add(new Pentagon(x,y,w,h,Color.blue,Color.yellow));
                            }
			    else if(idx==4){
                                figs.remove(foco);

                            }
			    focoB = null;
			    repaint();
			}
			else{
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
                        }

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
        this.setSize(400, 400);
    }

    public void paint (Graphics g/*, boolean focused*/) {
        super.paint(g);

        for (Figure fig: this.figs) {
	    if(foco==fig){
		    foco.AchaFoco(g,true);
	    }
            fig.paint(g,true);
        }
	for(Button but: buts){
            but.paint(g,but == focoB);
        }

    }
}
