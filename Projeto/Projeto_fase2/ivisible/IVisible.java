package ivisible;

import java.awt.Graphics;

public interface IVisible {
    public boolean clicked (int coordX, int coordY);
    public void paint (Graphics g, boolean focused);
}
