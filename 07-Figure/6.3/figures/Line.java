package figures;

import java.awt.*;

public class Line extends Figure{
    

    public Line (int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
/*
falta implementar
    public void print () {
        System.out.format("Reta de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
*/
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.x2,this.y2);
    }
}
