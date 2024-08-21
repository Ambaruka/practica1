//
// Created by AmbarPC on 18/08/2024.
//
#include <iostream>
#include <string>
#include "evento.h"
#include "vector"
#include "agenda.h"
#include <locale>

using namespace std;

agenda:: agenda(vector<evento *> _eventos) {
    eventos = std::move(_eventos);}

agenda::agenda() {
    eventos = vector<evento*>();
}

void agenda::tomadatos( ) {


    int situacion=1;
    string lugar1,tipoevento1,nombre1;
    int dia1,mes1,capacidad1,lugar2,tipoevento2;
    float hora1;
    double boleto1;

        cout<<"introdusca su nombre"<<endl;
        cin>>nombre1;

        cout << "Ingrese el lugar a reservar - \n1-minerva\n2-andares\n3-palomar" << endl;
        cin >> lugar2;
        switch (lugar2) {
            case 1:lugar1="Minerva";
                break;
            case 2:lugar1="Andares";
                break;
            case 3:lugar1="Palomar";
                break;
        }

        cout << "Ingrese el tipo de evento - \n1-Boda\n2-Cumpleaños\n3-Bautizo/Comunión" << endl;
        cin >> tipoevento2;
        switch (tipoevento2) {
            case 1:tipoevento1="Boda";
                break;
            case 2:tipoevento1="Cumpleaños";
                break;
            case 3:tipoevento1="Bautizo/Comunión";
                break;
        }

        cout << "Ingrese el dia del evento" << endl;
        cin >> dia1;

        cout << "Ingrese el mes del evento" << endl;
        cin >> mes1;

    situacion=exclusivo(dia1,mes1,lugar1,eventos);

    if (situacion==1) {
        cout << "Ingrese la capacidad del evento" << endl;
        cin >> capacidad1;

        cout << "Ingrese la hora del evento separando las horas y minutos con un punto\n    Eje.3.30" << endl;
        cin >> hora1;

        cout << "Ingrese el precio del boleto" << endl;
        cin >> boleto1;

        cout<<"La reservación se ha hecho correctamente "<<endl;

        evento *Evento = new evento(nombre1, lugar1, tipoevento1, dia1, mes1, capacidad1, hora1, boleto1);
        eventos.push_back(Evento);
    }
    menu();
}



void agenda::modificar(evento *a) {

    a= buscar(eventos);
    string lugar1,tipoevento1;
    int dia1,mes1,dato,capacidad1;
    float hora1;
    double boleto1;


    cout<<"introdusca el dato a modificar\n1-Lugar\n2-Tipo de evento\n3-Día\n4-Mes\n5-Capacidad\n6-Hora\n7-Boleto"<<endl;
    cin>>dato;

    switch (dato) {

        case 1: cout<<"El lugar registrado es "<<a->getLugar()<<"\nIngrese el lugar a reservar - \n1-minerva\n2-andares\n3-palomar" << endl;
        int lugar2;
        cin >> lugar2;
            switch (lugar2) {
                case 1:a->setLugar("Minerva");
                    break;
                case 2:a->setLugar("Andares");
                    break;
                case 3:a->setLugar("Palomar");
                    break;
            }
            break;

        case 2 : cout<<"El tipo de evento registrado es "<<a->getTipoEvento()<<"\nIngrese el tipo de evento - \n1-Boda\n2-Cumpleaños\n3-Bautizo/Comunión" << endl;
            int tipoevento2;
            cin >> tipoevento2;
            switch (tipoevento2) {
                case 1:a->setTipoEvento("Boda");
                    break;
                case 2:a->setTipoEvento("Cumpleaños");
                    break;
                case 3:a->setTipoEvento("Bautizo/Comunión");
                    break;
            }

            break;

        case 3:  cout<<"El dia reservado es "<< a->getDia()<<"introdusca el nuevo día a reservar"<<endl;
            cin>>dia1;
            a->setDia(dia1);
            break;

        case 4: cout<<"El mes agendado es "<< a->getMes() << " introdusca el nuevo mes a reservar"<<endl;
            cin>>mes1;
            a->setMes(mes1);
            break;

        case 5: cout<<"La capacidad actual es de "<< a->getCapacidad() << " introdusca la nueva capacidad a reservar"<<endl;
            cin>>capacidad1;
            a->setCapacidad(capacidad1);
            break;
        case 6: cout<<"La hora reservada actual es " << a->getHora() <<" introdusca la nueva hora a reservar"<<endl;
            cin>>hora1;
            a->setHora(hora1);
            break;
        case 7: cout<<"El precio del boleto actual es de $"<<a->getBoleto()<<" introdusca el nuevo precio "<<endl;
            cin>>boleto1;
            break;
    }
    menu();
}

int agenda::response() {
    cout<<("\nSi desea hacer otra reservación ponga 1"
           "\nSi desea modificar su reservacion ponga 2"
           "\nSi desea imprimir su evento ponga 3"
           "\nSi desea salir ponga  0")<<endl;
    int respuesta;
    cin>>respuesta;
    return respuesta;
}

evento* agenda:: buscar(vector<evento *> eventos){

    evento* a;
    string nombre1;
    cout<<"introdusca su nombre"<<endl;
    cin>>nombre1;
    for (evento* evento : eventos) {
        if (evento->getNombre() == nombre1) {
            a= evento;
        }
    }
    return a;
}

void agenda:: imprimir(){
    evento* a=buscar(eventos);
    cout<<"A nombre de: "<< a->getNombre() <<"\nLugar: "<< a->getLugar() <<"\nTipo de evento: "<<a->getTipoEvento()<<
        "\nDía: "<<a->getDia()<<"\nMes: "<<+ a->getMes()<<"\nCapacidad: "<<a->getCapacidad()<<
        "\nHora: "<<a->getBoleto()<<"\nPrecio boleto: $"<<a->getBoleto()<<endl;
    menu();

}

void agenda::menu() {
    switch (response()) {
        case 1:tomadatos();
            break;
        case 2:
            modificar(buscar(eventos));
            break;
        case 3:
            imprimir();
            break;
        case 0:
            break;
    }
}

int agenda::  exclusivo(int a, int b ,string c,vector<evento *> eventos) {
    int situacion=1;
    for (evento* evento : eventos) {
        if (a == evento->getDia() && b==evento->getMes() && c==evento->getLugar()) {
            cout<<"No se puede completar su reserva por falta de disponibilidad"<<endl;
            situacion= 2;
            break;
        }
    }
    return situacion;
}



