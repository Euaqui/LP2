package figures;

import java.awt.*;

public class Losango {
    public int x1,x2,x3,x4, y1,y2,y3,y4;
    int w, h;

    public Losango (int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4){
	this.x1 = x1;
	this.x2 = x2;
	this.x3 = x3;
	this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
	this.y4 = y4;
	this.w = this.y3 - this.y1;
	this.h = this.y2 - this.y4;
    }
    
    public void print () {
        System.out.format("Losango de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x1, this.y1);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(0,245,255));
	g2d.fillPolygon(new int[] {this.x1, this.x2, this.x3, this.x4}, new int[] {this.y1, this.y2, this.y3, this.y4}, 4);
	g.setColor(new Color(255,0,0));
	g2d.drawPolygon(new int[] {this.x1, this.x2, this.x3, this.x4}, new int[] {this.y1, this.y2, this.y3, this.y4}, 4);
    }

}
