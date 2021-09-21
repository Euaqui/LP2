package figures;

import java.awt.*;

public class Triangle extends Figure {
    

    public Triangle(int x, int x2, int x3, int y, int y2, int y3){
	this.x = x;
	this.x2 = x2;
	this.x3 = x3;
        this.y = y;
        this.y2 = y2;
        this.y3 = y3;
	this.w = this.y3 - this.y;
	this.h = y2-((this.y3 + this.y)/2);
    }
    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
	super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
	//g.setColor(new Color(139,0,139));
	//g2d.fillPolygon(new int[] {this.x1, this.x2, this.x3}, new int[] {this.y1, this.y2, this.y3}, 3);
	//g.setColor(new Color(255,255,0));
        g2d.drawPolygon(new int[] {this.x, this.x2, this.x3}, new int[] {this.y, this.y2, this.y3}, 3);
    }

}
