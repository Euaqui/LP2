package figures;

import java.awt.*;

public class Pentagon extends Figure{

	public Pentagon(int x,int y,int w,int h,Color fundo,Color borda){
		super(x,y,w,h,fundo,borda);
	}

	public void paint (Graphics g) {
        	Graphics2D g2d = (Graphics2D) g;
        	int x1[] = {this.x+10,this.x+25,this.x+65,this.x+80,this.x+43};
        	int y1[] = {this.y,this.y+30,this.y+30,this.y,this.y-24,};
        	g2d.setColor(this.fundo);
        	g2d.fillPolygon(x1, y1, 5); 
        	g2d.setColor(this.borda);
        	g2d.drawPolygon(x1, y1, 5);
    }

}