#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect {
    int x, y;
    int w, h;
}Rect;

Rect* rect_new(int x, int y, int w, int h){
    Rect* this = malloc(sizeof(Rect));
    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
}

void rect_drag (Rect* this, int dx, int dy){
    this->x += dx;
    this->y += dy;
}

void rect_print (Rect* this){
    printf("Rect na posicao(%d,%d) e dimensoes(%d,%d)\n",this->x,this->y,this->w,this->h);
}
