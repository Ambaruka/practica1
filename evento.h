//
// Created by AmbarPC on 18/08/2024.
#ifndef UNTITLED1_EVENTO_H
#define UNTITLED1_EVENTO_H
#include <string>
using namespace std;

class evento {
protected:
    string lugar, tipoEvento,nombre;
     int dia,mes,capacidad;
     float hora;
     double boleto;

public:
    evento(basic_string<char>,basic_string<char>, basic_string<char>, int, int, int, float, double);

    void setNombre(string nombre);
    string getNombre();
    void setTipoEvento(string tipoEvento);
     string getTipoEvento();
     void setLugar(string lugar);
     string getLugar();
     void setDia(int dia);
     int getDia();
     void setMes(int mes) ;
     int getMes() ;
     void setHora(float hora);
     float getHora();
     void setCapacidad(int capacidad);
     int getCapacidad() ;
     void setBoleto(double boleto) ;
     double getBoleto();

     void imprimir();
};




#endif //UNTITLED1_EVENTO_H
