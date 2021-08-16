/*
- Considere as 2 figuras mais complexas da sua resposta à Pergunta 3.1 do Módulo 1.
1. Implemente uma struct em C para uma delas e uma classe em Java para a outra.
2. Implemente uma função em C e um método em Java "print" para elas.
As informações contidas na struct e class precisam ser suficientes para representar a figura de forma completa.
Não é necessário realmente desenhar as figuras na tela, mas somente com essas informações teria que ser possível desenhá-las de forma não ambígua.
*/
class Elipse {
  int x, y; //posicao
  int w, h; //tamanho
  float r1, r2; //raio maior e menor
  Elipse (int x, int y, int w, int h, float r1, float r2) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r1 = r1;
    this.r2 = r2;
  }
  void print () {
    System.out.format(" Tamanho (%d,%d) / Posicao (%d,%d) / Raios (%f,%f)\n",
    this.w, this.h, this.x, this.y, this.r1, this.r2);
    }
}

public class ElipseApp {
  public static void main (String[] args) {
  Elipse e1 = new Elipse(10,20, 150,60, 75,30);
  e1.print();
  }
}
