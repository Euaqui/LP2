import java.awt.*;

import ivisible,*;

import figures.*;

public class Button implements IVisible {
    protected int idx;
    protected Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        
    }

    public boolean clicked (int x, int y) {
        return (fig.x-7<=x && x<=fig.x+fig.w+15 && fig.y-7<=y && y<=fig.y+fig.h+15);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

	if(focused == true){
        	g2d.setColor(Color.GRAY);
        }
	else{
		g2d.setColor(Color.WHITE);
	}

        g2d.fillRect(fig.x-6, fig.y-6, fig.w+12, fig.h+12);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(fig.x-7, fig.y-7, fig.w+13, fig.h+13);

        this.fig.paint(g, false);
    }
}
