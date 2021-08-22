# LP2
```
// HelloWorldApp.java  
class HelloWorldApp { 
    public static void main (String [] args) {  
        System.out.println ("Hello World!");  
    }  
}  
```  
![image](https://user-images.githubusercontent.com/88299200/127883231-f85a42a4-93c6-427e-88ff-671285f7f4ae.png)
![image](https://user-images.githubusercontent.com/88299200/128756095-e097f70b-6ff8-4121-9ca2-62d67d4b1ec2.png)

![image](https://user-images.githubusercontent.com/88299200/128756095-e097f70b-6ff8-4121-9ca2-62d67d4b1ec2.png)
```
//codigo alterado
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
	this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.white);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
	
	/*quadrado*/
	g2d.setPaint(Color.orange);
	g2d.drawLine(120,120, 120,230);
        g2d.drawLine(120,230, 230,230);
	g2d.drawLine(230,230, 230,120);
        g2d.drawLine(230,120, 120,120);
	
	/*circulo*/
	g2d.setPaint(Color.pink);
	g2d.drawOval(120,120, 110,110);
	
	/*bandeira*/
	g2d.setPaint(Color.green);
	g2d.fillRect(120,240, 110,85);
	g2d.setPaint(Color.yellow);
	g2d.drawLine(121,283, 175,324);
	g2d.drawLine(175,324, 229,286);
	g2d.drawLine(229,286, 175,240);
	g2d.drawLine(175,240, 121,283);
	g2d.setPaint(Color.blue);
	g2d.fillOval(143,250, 66,66);
	g2d.setPaint(Color.red);
	g2d.drawString("nao consegui pintar o losango",70, 50);
	g2d.drawString("nem a faixa branca",70,65);
    }
}

//codigo original

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
    }
}

```
![Captura de tela 2021-08-22 163419](https://user-images.githubusercontent.com/88299200/130367846-d7c35455-b7fe-427a-8440-2e7da31215f5.png)

