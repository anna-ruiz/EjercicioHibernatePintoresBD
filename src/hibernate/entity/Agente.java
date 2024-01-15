package hibernate.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "agente")
public class Agente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numClientes")
    private int numClientes;

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL) //Nombre del obj agente dentro del Pintor
    private Set<Pintor> pintores;

    public Agente() {
    }

    public Agente(String nombre, int numClientes, Set<Pintor> pintores) {
        this.nombre = nombre;
        this.numClientes = numClientes;
        this.pintores = pintores;
    }

    public Agente(String nombre, int numClientes) {
        this.nombre = nombre;
        this.numClientes = numClientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    public Set<Pintor> getPintores() {
        return pintores;
    }

    public void setPintores(Set<Pintor> pintores) {
        this.pintores = pintores;
    }

    @Override
    public String toString() {
        return "Agente{" +
                "Id =" + id +"\n" +
                "Nombre='" + nombre + "\n" +
                "NumClientes=" + numClientes +"\n" +
                "Pintores=" + pintores + "\n" +
                '}';
    }
}
