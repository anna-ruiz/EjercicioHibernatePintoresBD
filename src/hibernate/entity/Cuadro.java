package hibernate.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cuadro")
public class Cuadro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anyo")
    private int anyo;

    @ManyToOne
    @JoinColumn(name = "idPintor")
    private Pintor pintor;

    public Cuadro() {
    }

    public Cuadro(String nombre, int anyo, Pintor pintor) {
        this.nombre = nombre;
        this.anyo = anyo;
        this.pintor = pintor;
    }

    public Cuadro(String nombre, int anyo) {
        this.nombre = nombre;
        this.anyo = anyo;
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

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    @Override
    public String toString() {
        return "Cuadro{" +
                "Id = " + id +"\n" +
                "Nombre = " + nombre + "\n" +
                "Año = " + anyo +"\n" +
                "Pintor = " + pintor +"\n" +
                '}';
    }
}
