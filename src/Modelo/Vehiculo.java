package Modelo;

import java.util.ArrayList;

public class Vehiculo {

    private Personaje personaje;
    private final String nombre;
    private ArrayList<Encuentro> encuentros;

    public String getNombre() {
        return nombre;
    }

    public Vehiculo(String nombre) {
        this.nombre = nombre;
        encuentros = new ArrayList<>();
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void addEncuentro(Encuentro Encuentro) {
        encuentros.add(Encuentro);
    }

    public ArrayList<Encuentro> getEncuentros() {
        return encuentros;
    }
}
