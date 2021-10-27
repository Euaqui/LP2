#include <iostream>
#include "classes.h"

using namespace std;

int main{
 Base1 *obj1 = new Base1(); 
 Base2 *obj2 = new Base2(); 
 CFB *obj3 = new CFB(); 
  
 ob1->impBase1();
 ob2->impBase2();
  
 ob3->impBase1();
 ob3->impBase2();
  
 return 0;
}
