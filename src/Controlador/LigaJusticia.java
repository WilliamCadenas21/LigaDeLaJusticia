package Controlador;

import Modelo.*;
import java.util.ArrayList;

public class LigaJusticia {

    ArrayList<SuperHeroe> superHeroes;
    ArrayList<Villano> villanos;
    static ArrayList<Encuentro> encuentros;

    public static void main(String[] args) {
        Vehiculo vTemporal;
        ArrayList<SuperHeroe> ListaAuxSuper;
        ArrayList<Villano> ListaAuxVilla;
        Encuentro eTemporal;
        encuentros = new ArrayList<>();
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

        lj.addEncuentros(new Encuentro("Batalla1", "Metropolis", "Enero 1", ListaAuxSuper, ListaAuxVilla));

        vTemporal = lj.getSuperHeroe("Batman").getVehiculo("Batimovil");
        eTemporal = lj.getEncuentros().get(lj.getEncuentros().size() - 1);//interesante forma de extraer el ulitmo encuentro
        eTemporal.addVehiculoSuper(vTemporal);
        vTemporal.addEncuentro(eTemporal);

        //Batalla 2
        ListaAuxSuper.clear();
        ListaAuxSuper.add(lj.getSuperHeroe("Batman"));

        ListaAuxVilla.clear();
        ListaAuxSuper.add(lj.getSuperHeroe("Joker"));

        lj.addEncuentros(new Encuentro("Batalla2", "Ciudad Gotica", "Enero 2", ListaAuxSuper, ListaAuxVilla));

        vTemporal = lj.getSuperHeroe("Batman").getVehiculo("Batimovil");
        eTemporal = lj.getEncuentros().get(lj.getEncuentros().size() - 1);//interesante forma de extraer el ulitmo encuentro
        eTemporal.addVehiculoSuper(vTemporal);
        vTemporal.addEncuentro(eTemporal);
        
        vTemporal = lj.getSuperHeroe("Batman").getVehiculo("Baticoptero");
        eTemporal.addVehiculoSuper(vTemporal);
        vTemporal.addEncuentro(eTemporal);

        //Batalla 3
        ListaAuxSuper.clear();
        ListaAuxSuper.add(lj.getSuperHeroe("Robin"));
        ListaAuxSuper.add(lj.getSuperHeroe("Superman"));

        ListaAuxVilla.clear();
        ListaAuxSuper.add(lj.getSuperHeroe("Pinguino"));

        lj.addEncuentros(new Encuentro("Batalla3", "Ciudad Central", "Enero 3", ListaAuxSuper, ListaAuxVilla));

        vTemporal = lj.getSuperHeroe("Batman").getVehiculo("Batimovil");
        eTemporal = lj.getEncuentros().get(lj.getEncuentros().size() - 1);//interesante forma de extraer el ulitmo encuentro
        eTemporal.addVehiculoSuper(vTemporal);
        vTemporal.addEncuentro(eTemporal);

        vTemporal = lj.getVillano("Pinguino").getVehiculo("Patomovil");
        eTemporal.addVehiculoVillano(vTemporal);//por que es de un villano
        vTemporal.addEncuentro(eTemporal);

        lj.getSuperHeroe("Batman").getVehiculoMasUsado();
    }

    private SuperHeroe getSuperHeroe(String nombre) {
        for (int i = 0; i < superHeroes.size(); i++) {
            if (nombre.equalsIgnoreCase(superHeroes.get(i).getNombre())) {
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
                return villanos.get(i);
            }
        }
        return null;
    }

    private ArrayList<Encuentro> getEncuentros() {
        return encuentros;
    }
}