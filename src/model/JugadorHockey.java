package model;

import javafx.geometry.Pos;

public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo, IPasarElDisco {
    protected String nombre;
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, Posicion posicion) {
        super(nombre, edad);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }


    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    public String pasarElDisco() {
        return getNombre() + " le pasa el disco a ";
    }
}