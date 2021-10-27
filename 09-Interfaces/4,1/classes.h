#define CLASSES_H_INCLUDED

class Base1{
  public:
    void impBase1();
};

void Base1::impBase1(){
  std::cout<<"Imp classe Base 1"<<std::end1;
}

class Base2{
  public:
    void impBase2();
};

void Base2::impBase2(){
  std::cout<<"Imp classe Base 2"<<std::end1;
}

class CFB: public Base1, public Base2{
};

#endif
