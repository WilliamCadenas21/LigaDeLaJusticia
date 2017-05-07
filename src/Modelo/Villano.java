package Modelo;

import java.util.ArrayList;

public class Villano extends Personaje {

    private ArrayList<Encuentro> encuentros;

    public Villano(String nombre) {
        super(nombre);
    }

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculo.setPersonaje(this);
        vehiculos.add(vehiculo);
    }

    @Override
    public Vehiculo getVehiculo(String nombre) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (nombre.equalsIgnoreCase(vehiculos.get(i).getNombre())) {
                return vehiculos.get(i);
            }
        }
        return null;
    }
}
