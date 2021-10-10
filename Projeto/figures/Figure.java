package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {
    public int x, y;
    public int w, h; 
    public Color fundo;
    public Color borda;

    public Figure(int x, int y, int w, int h, Color fundo, Color borda){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.borda = borda;
    }
  
    public abstract void paint (Graphics g);

    public boolean clicked (int coordX, int coordY) {
        return (((x <= coordX) && (y <= coordY)) && ((coordX <= (x + w)) && (coordY <= (y + h))));
    }
    
    public Color contorno = new Color(0,0,0);

    public void AchaFoco(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawRect(this.x-4,this.y-4,this.w+8,this.h+8);
    }
  
} 
