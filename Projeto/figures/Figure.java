package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {
    int x, y;
    int w, h; 
    Color fundo;
    Color borda;

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
}
