package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;
    protected String nombreEquipo;
    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    public Equipo(String nombre) {
        this.nombreEquipo = nombre;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void agregarJugador(JugadorHockey jugador, int posicion) {
        if (posicion >= 0 && posicion < jugadores.length) {
            jugadores[posicion] = jugador;
        }
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }

    public String addJugador(JugadorHockey jugador) {
        for(int i = 1; i <jugadores.length; i++) {
            if(jugadores[i] == null) {
                jugadores[i] = jugador;
                return "Guardado";
            }
        }
        return "No se pudo guardar";
    }
}