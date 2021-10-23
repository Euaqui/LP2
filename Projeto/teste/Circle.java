package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Circle extends Figure {
    

    public Circle (int x, int y, int w, int h, Color fundo, Color borda) {
        super(x,y,w,h,fundo,borda);
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public Color contorno = new Color(0,0,0);
    public void paint (Graphics g, boolean emFoco) {
        Graphics2D g2d = (Graphics2D) g;

	if (emFoco==true){
		g2d.setColor(contorno);
        	g2d.drawRect(this.x-4,this.y-4,this.w+8,this.h+8);
	}

        g2d.setColor(this.fundo);
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.borda);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}