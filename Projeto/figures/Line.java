package figures;

import java.awt.*;

public class Line extends Figure{
    int x, y;
    int x1, y1;

    public Line (int x, int y, int x1, int y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }
/*
falta implementar
    public void print () {
        System.out.format("Reta de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
*/
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.x1,this.y1);
    }
}