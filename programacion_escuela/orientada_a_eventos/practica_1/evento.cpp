//
// Created by AmbarPC on 18/08/2024.
//
#include "evento.h"
#include <string.h>

evento::evento(string _nombre,string _lugar,string _tipoEvento, int _dia, int _mes, int _capacidad, float _hora, double _boleto) {
    nombre= _nombre;
    lugar=_lugar;
    tipoEvento=_tipoEvento;
    dia=_dia;
    mes=_mes;
    capacidad=_capacidad;
    hora=_hora;
    boleto=_boleto;
}
void evento::setNombre(std::string _nombre) {
    nombre=_nombre;
}

string evento::getNombre() {
    return nombre;
}

void evento::setTipoEvento(string _tipoEvento) {
    tipoEvento = _tipoEvento;
}

string evento:: getTipoEvento() {
    return tipoEvento;
}

void evento:: setLugar(string _lugar){
    lugar=_lugar;
}

string evento::getLugar() {
    return lugar;
}

void evento:: setDia(int _dia) {
    dia = _dia;
}

int evento:: getDia() {
    return dia;
}

void evento:: setMes(int _mes) {
    mes = _mes;
}

int evento:: getMes() {
    return mes;
}

void evento:: setHora(float _hora) {
    hora = _hora;
}

float evento:: getHora() {
    return hora;
}

void evento:: setCapacidad(int _capacidad) {
    capacidad = _capacidad;
}

int evento:: getCapacidad() {
    return capacidad;
}

void evento:: setBoleto(double _boleto) {
    boleto = _boleto;
}

double evento:: getBoleto() {
    return boleto;

    //void evento :: imprimir() {
      //  cout << "Lugar: " << evento->lugar << endl;
        //cout << "Tipo de evento: " << evento->tipoEvento << endl;
        //cout << "Día: " << evento->dia << endl;
        //cout << "Mes: " << evento->mes << endl;
        //cout << "Hora: " << evento->hora << endl;
        //cout << "Capacidad: " << evento->capacidad << endl;
        //cout << "Precio: " << evento->boleto << endl;
   // }
}

