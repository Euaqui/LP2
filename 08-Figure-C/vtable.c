//Segue arquivo '.PNG' 
//https://user-images.githubusercontent.com/88299200/136122367-eb33dbbb-bd50-40a1-bb5f-0fc9b972c556.png

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.14159265358979323846

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Perimetro) (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* perimetro) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) com area (%d) e perimetro (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int rect_perimetro (Rect* this) {
    Figure* sup = (Figure*) this;
    return ((this->w + this->h) * 2);
}


Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Perimetro)  rect_perimetro
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int x2,x3, y2,y3;
} Triangle;

void triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de largura (%d) e altura (%d) vertice de cima comecando na posicao (%d,%d) com area (%d) e perimetro (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int triangle_area (Triangle* this) {
    Figure* sup = (Figure*) this;
    return (this->w * this->h)/2;
}

int triangle_perimetro (Triangle* this) {
    Figure* sup = (Figure*) this;
    return (sqrt(pow(this->x2 - sup->x, 2) + pow(this->y2 - sup->y, 2)) + sqrt(pow(this->x3 - this->x2, 2) + pow(this->y3 - this->y2, 2)) + sqrt(pow(sup->x - this->x3, 2) + pow(sup->y - this->y3, 2)));
}

Figure_vtable triangle_vtable = {
    (Figure_Print) triangle_print,
    (Figure_Area)  triangle_area,
    (Figure_Perimetro)  triangle_perimetro
};

Triangle* triangle_new (int x, int x2, int x3, int y, int y2, int y3) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangle_vtable;
    sup->x = x;
    sup->y = y;
    this->x2 = x+40;
	this->x3 = x-40;
    this->y2 = y+40;
    this->y3 = y+40;
    this->w = this->x2 - this->x3;
	this->h = this->y3 - sup->y;	
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Circle;

void circle_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Circulo de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int circle_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return PI * (this->w/2 * this->h/2);
}

int circle_perimetro(Rect*this){
    Figure* sup = (Figure*) this;
    return 2*PI*this->w/2;
}

Figure_vtable circle_vtable = {
    (Figure_Print) circle_print,
    (Figure_Area)  circle_area,
    (Figure_Perimetro) circle_perimetro
};

Circle* circle_new (int x, int y, int w, int h) {
    Circle* this = malloc(sizeof(Circle));
    Figure* sup = (Figure*) this;
    sup->vtable = &circle_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(20,20,110,110),
        (Figure*) triangle_new(90,140,40,40,140,140),
        (Figure*) circle_new(10,10,100,100)
    };

    
	int i;
	for (i=0; i<3; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    

    for (i=0; i<3; i++) {
        free(figs[i]);
    }
}
