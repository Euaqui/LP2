interface buyable /*compravel*/{ // objetos: t-shirt, car, table (camisa, carro, mesa)
  int purchase /*comprar*//*indica se o obeto esta disponivel para compra e o preco*/ (boolean offer,double price);/* oferta indica se algo esta disponivel para compra ou nao,
                                                                                                         preco indica o preco de compra do objeto*/ 
  int sell/*vender*//*indica se o objeto está disponivel para venda, o preco*/(boolean offer, double price); /* oferta indica se algo esta disponivel para venda ou nao, 
                                                                                                      preco indica preco de venda do objeto*/
}


interface cleanable{ //limpavel objetos: picture frame, cutlery, book (porta-retrato, copo, livro)
  void to_clean /*limpar*//*indica a quanto temp um objeto nao e limpo*/(int time); // tempo indica a quanto tempo nao sao limpos 
  void organize /*organizar*//*indica a melhor ordem para organizar os objetos*/ (int order); // ordem indica a ordem para organizar os objetos
}
