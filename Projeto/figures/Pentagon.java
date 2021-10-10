package figures;

import java.awt.*;

public class Pentagon extends Figure{

	public Pentagon(int x,int y,int w,int h,Color fundo,Color borda){
		super(x,y,w,h,fundo,borda);
	}

	public void paint (Graphics g) {
        	Graphics2D g2d = (Graphics2D) g;
        	int x1[] = {this.x+(w/2),this.x-(w/2)+(w/2),this.x-(w/4)+(w/2),this.x+(w/4)+(w/2),this.x+(w/2)+(w/2)};
        	int y1[] = {this.y,this.y + (h/2),this.y+h ,this.y+h,this.y+(h/2)};
        	g2d.setColor(this.fundo);
        	g2d.fillPolygon(x1, y1, 5); 
        	g2d.setColor(this.borda);
        	g2d.drawPolygon(x1, y1, 5);
    }

}
