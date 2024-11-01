package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;
    private JugadorHockey[] jugadores;
    private Persona[] personas;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;
    private final int CANTIDAD_JUGADORES = 24;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public Arbitro[] getArbitros() {
        return arbitros;
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public Equipo crearEquipo(String nombreEq) {
        Equipo equipo = new Equipo(nombreEq);
        return equipo;
    }

    public String addEquipo(Equipo equipo) {
        for(int i = 1; i <equipos.length; i++) {
            if(equipos[i] == null) {
                equipos[i] = equipo;
                contadorEquipos ++;
                return "Guardado";
            }
        }
        return "No se pudo guardar";
    }

    public Arbitro crearArbitro(int edad, String nombreArb, int opcion) {
        boolean exit = false;
        Arbitro arbitro = null;
        do {
            if (opcion == 1) {
                arbitro = new ArbitroPrincipal(nombreArb, edad);
                exit = true;
                break;
            } else if (opcion == 2) {
                arbitro = new JuezDeLinea(nombreArb, edad);
                exit = true;
            }
        } while(!exit);
        return arbitro;
    }

    public String addArbitro(Arbitro arbitro) {
        for(int i = 1; i <arbitros.length; i++) {
            if(arbitros[i] == null) {
                arbitros[i] = arbitro;
                return "Guardado";
            }
        }
        return "No se pudo guardar";
    }

    private Equipo buscarEquipo(String nomEquipo) {
        for(Equipo equipo : equipos) {
            if(equipo != null && equipo.getNombreEquipo().equalsIgnoreCase(nomEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public String asociarJugadorAEquipo(String nomEquipo, JugadorHockey jugador) {
        if(buscarEquipo(nomEquipo) != null) {
            return buscarEquipo(nomEquipo).addJugador(jugador);
        }
        return "No se encontró el equipo";
    }

    
    public JugadorHockey crearJugadorHockey(String nombre, int edad, Posicion posicion) {
        JugadorHockey jugador = new JugadorHockey(nombre, edad, posicion);
        return jugador;
    }


    public void crearJugadoresDePrueba() {
        // equipo 1
        asociarJugadorAEquipo("Equipo A", crearJugadorHockey("Juan", 23, Posicion.PORTERO));
        asociarJugadorAEquipo("Equipo A", crearJugadorHockey("Andres", 30, Posicion.DEFENSA));
        asociarJugadorAEquipo("Equipo A", crearJugadorHockey("Maria", 19, Posicion.ALA));
        asociarJugadorAEquipo("Equipo A", crearJugadorHockey("Jesus", 19, Posicion.CENTRO));

        // equipo 2

        asociarJugadorAEquipo("Equipo B", crearJugadorHockey("Camila", 30, Posicion.PORTERO));
        asociarJugadorAEquipo("Equipo B", crearJugadorHockey("Sara", 25, Posicion.DEFENSA));
        asociarJugadorAEquipo("Equipo B", crearJugadorHockey("Gilberto", 27, Posicion.ALA));
        asociarJugadorAEquipo("Equipo B", crearJugadorHockey("Pepe", 19, Posicion.CENTRO));
    }



    public void crearArbitrosDePrueba() {
        addArbitro(crearArbitro(46, "Julian Gonzalez", 1));
        addArbitro(crearArbitro(35, "Marcela Nunez", 2));
        addArbitro(crearArbitro(56, "Ana Carmona", 2));
        addArbitro(crearArbitro(29, "Cristian Melendez", 2));
    }

    public void crearEquiposDePrueba() {
        addEquipo(crearEquipo("Equipo A"));
        addEquipo(crearEquipo("Equipo B"));
        addEquipo(crearEquipo("Equipo C"));
        addEquipo(crearEquipo("Equipo D"));
    }


    public String simulacionJugadaGol() {
        // gol por parte del Equipo A
        JugadorHockey[] jugadoresDelGol = buscarEquipo("Equipo A").getJugadores();
        String mensaje = null;
        for(int i = 0; i<5; i++){
            if(jugadoresDelGol != null) {
                JugadorHockey jugador1 = jugadoresDelGol[i];
                JugadorHockey jugador2 = jugadoresDelGol[i+1];
                mensaje += "El jugador " + jugador1.getNombre() + " le pasa el disco a el jugador " + jugador2.getNombre();
            }
        }
        return mensaje;
    }
}
