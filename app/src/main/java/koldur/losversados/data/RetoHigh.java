package koldur.losversados.data;

import java.util.UUID;

/**
 * Created by Juan on 26/03/2017.
 */

public class RetoHigh {
    private int id;
    private String nombre;
    private String descr;

    public RetoHigh(String name, String descrip){
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.nombre=name;
        this.descr=descrip;
    }

    public int getID() {return id;}
    public String getNombre() {return nombre;}
    public String getDescr() {return descr;}

}
