import hibernate.entity.Agente;
import hibernate.entity.Cuadro;
import hibernate.entity.Estudio;
import hibernate.entity.Pintor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    static Session session;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String respuesta = "";
    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException e) {
            System.out.println("Error: "+e);
        }


    }

    private static void menu() throws IOException {

        do {
            System.out.println("--- Elige una opción ---");
            System.out.println("1. Insertar un Agente");
            System.out.println("2. Insertar un Pintor");
            System.out.println("3. Insertar un Cuadro");
            System.out.println("4. Ver la lista de pintores");
            System.out.println("5. Salir");
            respuesta = br.readLine();
            session = sessionFactory.openSession();
            session.beginTransaction();

            switch (respuesta){
                case "1" -> insertarAgente();
                case "2" -> insertarPintor();
                case "3" -> insertarCuadro();
                case "4" -> listarPintores(true);
                default -> {
                    if (!respuesta.equals("5")){
                        System.out.println("Error: debes introducir un valor númerico");
                    }
                }
            }

            session.getTransaction().commit();
            session.close();

        }while (!respuesta.equals("5"));


    }

    private static void listarPintores(boolean completo) {
        List<Pintor> pintores = session.createQuery("from Pintor , Pintor.class").list(); //volcamos en una lista los agentes de la BD

        for (Pintor p: pintores){
            if (completo){
                System.out.println(p);
            }else {
                System.out.println(p.getId()+". "+ p.getNombre());
            }
        }
    }

    private static void insertarCuadro() throws IOException {
        listarPintores(false);
        System.out.println("Selecciona un Id del Pintor de la lista");
        int idPintor = Integer.parseInt(br.readLine());
        Pintor pintor = session.get(Pintor.class, idPintor);

        System.out.println("Dime el nombre del cuadro");
        String nombre = br.readLine();
        System.out.println("Dime el año del cuadro");
        int anyo = Integer.parseInt(br.readLine());

        Cuadro cuadro = new Cuadro(nombre,anyo);
        cuadro.setPintor(pintor);
        pintor.getCuadros().add(cuadro);

        session.merge(pintor);


    }

    private static void insertarPintor() throws IOException {
        mostrarAgentes();

        System.out.println("Introduce el Id de uno de los Agentes de la lista");
        int idAgente = Integer.parseInt(br.readLine());
        Agente agente = session.get(Agente.class, idAgente);


        System.out.println("Introduce los datos del Pintor");
        System.out.println("Nombre");
        String nombre = br.readLine();
        System.out.println("Apellidos");
        String apellidos = br.readLine();
        System.out.println("Introduce el número de cuadros");
        int numCuadros = Integer.parseInt(br.readLine());


        Pintor pintor = new Pintor(nombre,apellidos,numCuadros);
        Estudio estudio = insertarEstudio();
        estudio.setPintor(pintor);
        pintor.setEstudio(estudio);

        pintor.setAgente(agente);
        agente.getPintores().add(pintor);



    }

    private static Estudio insertarEstudio() throws IOException {
        System.out.println("Dime la calle del estudio");
        String calle = br.readLine();
        System.out.println("Dime el número");
        int numero = Integer.parseInt(br.readLine());
        System.out.println("Dime el código postal");
        int cp = Integer.parseInt(br.readLine());
        System.out.println("Dime la localidad");
        String localidad = br.readLine();

        return new Estudio(calle,numero,cp,localidad);
    }

    private static void mostrarAgentes() {
        List<Agente> agentes = session.createQuery("from Agente" , Agente.class).list(); //volcamos en una lista los agentes de la BD

        for (Agente a: agentes){
            System.out.println(a.getId()+". "+a.getNombre());
        }
    }

    private static void insertarAgente() throws IOException {
        System.out.println("Inserta los datos del agente");
        String nombre = br.readLine();
        System.out.println("Dime el número de clientes");
        int numClientes = Integer.parseInt(br.readLine());

        Agente agente = new Agente(nombre,numClientes);
        session.persist(agente); //lo añadimos a la bd
    }
}