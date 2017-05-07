package Modelo;

import java.util.ArrayList;

public abstract class Personaje {

    private final String nombre;
    protected ArrayList<Vehiculo> vehiculos;

    public Personaje(String nombre) {
        this.nombre = nombre;
        vehiculos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public abstract void addVehiculo(Vehiculo vehiculo);
    
    public abstract Vehiculo getVehiculo(String nombre);

    @Override
    public boolean equals(Object o) {
        if (o instanceof Personaje) {
            Personaje p = (Personaje) o;
            if (p.getNombre().equalsIgnoreCase(this.getNombre())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
