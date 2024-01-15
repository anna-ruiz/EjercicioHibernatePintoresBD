package hibernate.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "estudio")
public class Estudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cp")
    private int cp;

    @Column(name = "localidad")
    private String localidad;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Pintor pintor;

    public Estudio() {
    }

    public Estudio(String calle, int numero, int cp, String localidad, Pintor pintor) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
        this.pintor = pintor;
    }

    public Estudio(String calle, int numero, int cp, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "Id = " + id + "\n" +
                 "Calle = " + calle + "\n" +
                "Numero = " + numero +"\n" +
                "Cp = " + cp +"\n" +
                "Localidad = " + localidad + "\n" +
                "Pintor = " + pintor +"\n" +
                '}';
    }
}
