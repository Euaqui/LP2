package figures;

import java.awt.*;

public class Triangle {
    private int x1,x2,x3, y1,y2,y3;
    private int a,b,c, a1,b1,c1;
    private int w, h;

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3, int a, int b, int c, int a1, int b1, int c1){
	this.x1 = x1;
	this.x2 = x2;
	this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
	this.a = a;
	this.b = b;
	this.c = c;
	this.a1 = a1;
	this.b1 = b1;
	this.c1 = c1;
	this.w = this.y3 - this.y1;
	this.h = y2-((this.y3 + this.y1)/2);
    }
    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x1, this.y1);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(this.a,this.b,this.c));
	g2d.fillPolygon(new int[] {this.x1, this.x2, this.x3}, new int[] {this.y1, this.y2, this.y3}, 3);
	g.setColor(new Color(this.a1,this.b1,this.c1));
        g2d.drawPolygon(new int[] {this.x1, this.x2, this.x3}, new int[] {this.y1, this.y2, this.y3}, 3);
    }

}
