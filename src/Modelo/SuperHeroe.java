package Modelo;

import java.util.ArrayList;

public class SuperHeroe extends Personaje {

    private ArrayList<SuperHeroe> compañero;
    private ArrayList<Encuentro> encuentros;

    public SuperHeroe(String nombre) {
        super(nombre);
        compañero = new ArrayList<>();
    }

    public void addCompañero(SuperHeroe superHeroe) {
        compañero.add(superHeroe);
        vehiculos = new ArrayList<>();
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

    public void getVehiculoMasUsado() {
        int NunmeroDeEncuntros = vehiculos.get(0).getEncuentros().size();
        String nombreVehiculo = vehiculos.get(0).getNombre();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getEncuentros().size() > NunmeroDeEncuntros) {
                NunmeroDeEncuntros = vehiculos.get(i).getEncuentros().size();
                nombreVehiculo = vehiculos.get(i).getNombre();
            }
        }
        System.out.println(nombreVehiculo);
    }
}