/*
- Considere as 2 figuras mais complexas da sua resposta à Pergunta 3.1 do Módulo 1.
1. Implemente uma struct em C para uma delas e uma classe em Java para a outra.
2. Implemente uma função em C e um método em Java "print" para elas.
As informações contidas na struct e class precisam ser suficientes para representar a figura de forma completa.
Não é necessário realmente desenhar as figuras na tela, mas somente com essas informações teria que ser possível desenhá-las de forma não ambígua.
*/

#include <stdio.h> 

typedef struct {
  int x, y; //posicao
  int w, h; //Tamanho
} Retangulo;

void print (Retangulo *r) {
  printf ("Tamanho (%d,%d) / Posicao (%d,%d)\n",
  r->w,r->h, r->x,r->y);
}

void main () {
  Retangulo r1 = { 10,10, 120,50 };
  print(&r1);
}
