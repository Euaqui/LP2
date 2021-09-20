package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, x2, x3, y, y2, y3;
    int w, h; 
    public abstract void paint (Graphics g);
}
