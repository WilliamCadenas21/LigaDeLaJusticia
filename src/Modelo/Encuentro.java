package Modelo;

import java.util.ArrayList;

public class Encuentro {
    
    private ArrayList<Vehiculo> vehiculosVillanos;
    private ArrayList<Vehiculo> vehiculosHeroes;
    private ArrayList<Villano> villanos;
    private ArrayList<SuperHeroe> heroes;
    private final String nombre,lugar,fecha;
    
    public Encuentro(String nombre,String lugar,String fecha,ArrayList<SuperHeroe> heroes,ArrayList<Villano> villanos) {
        this.villanos = villanos;
        this.heroes = heroes;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        vehiculosHeroes = new ArrayList<>();
        vehiculosVillanos = new ArrayList<>();
    }

    public void addVehiculoSuper(Vehiculo vehiculo) {
        vehiculosHeroes.add(vehiculo);
    }
    
    public void addVehiculoVillano(Vehiculo vehiculo) {
        vehiculosVillanos.add(vehiculo);
    }
    
}