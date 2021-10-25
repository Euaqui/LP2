import java.awt.*;
import figures.*;
import ivisible.*;

public class Button implements IVisible {
    public  int    idx;
    private Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        
    }

    public boolean clicked (int x, int y) {
        return (fig.x-7<=x && x<=fig.x+fig.w+15 && fig.y-7<=y && y<=fig.y+fig.h+15);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

	if(focused){
        	g2d.setColor(Color.GRAY);
        }
	else{
		g2d.setColor(Color.WHITE);
	}

        g2d.fillRect(fig.x, fig.y, fig.w, fig.h);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(fig.x-4, fig.y-4, fig.w+8, fig.h+8);

        this.fig.paint(g, false);
    }
}
