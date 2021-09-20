//Segue abaixo arquivo '.PNG'
//https://user-images.githubusercontent.com/88299200/134066402-24f268e6-c166-4354-a6fc-15ad4775f437.png

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
////////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x2, x3;
    int y2,y3;
} Triangle;

void Triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de vertices (%d,%d), (%d,%d), (%d,%d) na posicao (%d,%d).\n",
           sup->x, sup->y, this->x2, this->y2, this->x3, this->y3, sup->x, sup->y);
}

Triangle* triangle_new (int x, int y, int x2, int y2, int x3, int y3) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
    this->x3 = x3;
    this->y3 = y3;
}
///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x2, y2;
} Line;

void Line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha que comeca na posicao (%d,%d) e termina na posicao (%d,%d).\n",
        sup->x, sup->y, this->x2, this->y2);
}

Line* line_new (int x, int y, int x2, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}
//////////////////////////////////////////////////////////////////////////////
void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,20,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) line_new(30,30,90,90),
        (Figure*) triangle_new(50,50,100,100,150,50)
    };

    ///
    int i;// antes estava declarado dentro do for
    for ( i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///
    
    for ( i=0; i<6; i++) {
        free(figs[i]);
    }
}
