package hibernate.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pintor")
public class Pintor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //le decimos q es autoincremental
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "numCuadros")
    private int numCuadros;

    @ManyToOne
    @JoinColumn(name = "idAgente") //El name es la clave ajena
    private Agente agente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstudio")
    private Estudio estudio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pintor") //Busca el objeto con el que la clase cuadro guarda el pintor (El private pintor dentro de Cuadro)
    @OrderColumn(name = "indice")//Le pasamos la columna para ordenar los cuadros en base al pintor xq es una lista ordenada
    private List<Cuadro> cuadros;

    public Pintor() {
    }

    public Pintor( String nombre, String apellidos, int numCuadros, Agente agente, Estudio estudio, List<Cuadro> cuadros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numCuadros = numCuadros;
        this.agente = agente;
        this.estudio = estudio;
        this.cuadros = cuadros;
    }

    public Pintor(String nombre, String apellidos, int numCuadros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numCuadros = numCuadros;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumCuadros() {
        return numCuadros;
    }

    public void setNumCuadros(int numCuadros) {
        this.numCuadros = numCuadros;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public List<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCuadros(List<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    @Override
    public String toString() {
        return "Pintor{" +
                "Id" + id +"\n" +
                "Nombre='" + nombre +"\n"  +
                "Apellidos='" + apellidos + "\n" +
                "NumCuadros=" + numCuadros +"\n" +
                "Agente=" + agente +"\n" +
                "Estudio=" + estudio +"\n" +
                "Cuadros=" + cuadros +"\n" +
                '}';
    }
}
