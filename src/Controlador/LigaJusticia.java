package Controlador;

import Modelo.*;
import java.util.ArrayList;

public class LigaJusticia {

    ArrayList<SuperHeroe> superHeroes;
    ArrayList<Villano> villanos;
    ArrayList<Encuentro> encuentros;

    public static void main(String[] args) {
        Vehiculo vTemporal;
        ArrayList<SuperHeroe> ListaAuxSuper;
        ArrayList<Villano> ListaAuxVilla;
        Encuentro eTemporal;

        LigaJusticia lj = new LigaJusticia();

        lj.addSuperHeroes(new SuperHeroe("Superman"));
        lj.addSuperHeroes(new SuperHeroe("Batman"));
        lj.addSuperHeroes(new SuperHeroe("Robin"));

        lj.addVillanos(new Villano("Joker"));
        lj.addVillanos(new Villano("Pinguino"));

        SuperHeroe s = lj.getSuperHeroe("Batman");
        if (s != null) {
            s.addCompañero(lj.getSuperHeroe("Robin"));
        } else {
            System.out.println("No existe");
        }

        lj.getSuperHeroe("Batman").addVehiculo(new Vehiculo("Batimovil"));
        lj.getSuperHeroe("Batman").addVehiculo(new Vehiculo("Baticoptero"));
        lj.getVillano("Pinguino").addVehiculo(new Vehiculo("Patomovil"));
        
        
        //Batalla 1
        ListaAuxSuper = new ArrayList<>();
        ListaAuxSuper.add(lj.getSuperHeroe("Batman"));
        ListaAuxSuper.add(lj.getSuperHeroe("Superman"));
        
        ListaAuxVilla = new ArrayList<>();
        ListaAuxSuper.add(lj.getSuperHeroe("Pinguino"));
        
        lj.addEncuentros(new Encuentro("Batalla1","Metropolis","Enero 1",ListaAuxSuper, ListaAuxVilla));
        vTemporal = lj.getSuperHeroe("Batman").getVehiculo("Batimovil");
        eTemporal = lj.getEncuentros().get(lj.getEncuentros().size());//interesante forma de extraer el ulitmo encuentro
        eTemporal.addVehiculoSuper(vTemporal);
    }

    private SuperHeroe getSuperHeroe(String nombre) {
        for (int i = 0; i < superHeroes.size(); i++) {
            if (nombre.equalsIgnoreCase(superHeroes.get(i).getNombre())) {
                System.out.println("entro");
                return superHeroes.get(i);
            }
        }
        return null;
    }

    public LigaJusticia() {
        this.superHeroes = new ArrayList<>();
        this.villanos = new ArrayList<>();
    }

    public void addSuperHeroes(SuperHeroe s) {
        superHeroes.add(s);
    }

    public void addVillanos(Villano v) {
        villanos.add(v);
    }

    public void addEncuentros(Encuentro encuentro) {
        encuentros.add(encuentro);
    }

    private Villano getVillano(String nombre) {
        for (int i = 0; i < villanos.size(); i++) {
            if (nombre.equalsIgnoreCase(villanos.get(i).getNombre())) {
                System.out.println("entro");
                return villanos.get(i);
            }
        }
        return null;
    }

    private ArrayList<Encuentro> getEncuentros() {
        return encuentros;
    }
}
