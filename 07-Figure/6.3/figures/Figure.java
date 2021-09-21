package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, x2, y, y2;
    int w, h; 
    public abstract void paint (Graphics g);
}
