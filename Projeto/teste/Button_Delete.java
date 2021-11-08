import java.awt.*;
import figures.*;

public class Button_Delete extends Button{

	public Button_Delete(int idx, Figure fig) {
		super(idx, fig);
	}
	
	public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

    	if(focused == true) {
    		g2d.setColor(Color.GRAY);
    	}
    	else {
    		g2d.setColor(Color.WHITE);
    	}
        
        g2d.fillRect(fig.x-6, fig.y-6, fig.w+12, fig.h+12);
        g2d.setColor(Color.BLACK);
        
        g2d.drawRect(fig.x-7, fig.y-7, fig.w+13, fig.h+13);
        
        int fontSize = 18;
        g2d.setFont(new Font("Arial", Font.PLAIN, fontSize));
        g2d.setColor(Color.red);
        
        g2d.drawString("Del", fig.x-3, fig.y +15);
	}
}