//
// Created by AmbarPC on 18/08/2024.
#ifndef UNTITLED1_AGENDA_H
#define UNTITLED1_AGENDA_H
#include <iostream>
#include <string>
#include "evento.h"
#include "vector"
using namespace std;

class agenda {
private:


    vector<evento*>eventos;

public:
    agenda(vector<evento *> _eventos);
    agenda();
    void tomadatos();
    int response();
    void modificar(evento *a);

    evento* buscar(vector<evento *> eventos);
    void imprimir();
    void menu();
    int exclusivo(int, int,string , vector<evento *> eventos);

};


#endif //UNTITLED1_AGENDA_H
