#include <iostream>
#include "vector"
#include "evento.h"
#include "agenda.h"


int main() {


    vector<evento*>eventos;

    agenda*  agenda1=new agenda(eventos);
    agenda1->tomadatos();





delete agenda1;


    return 0;
}


