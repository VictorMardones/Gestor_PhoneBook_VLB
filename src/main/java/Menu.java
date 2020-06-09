
// Importa la clase ArrayList
import java.util.ArrayList;

/**
 * Acá ira el menú principal del proyecto PhoneBook y todo lo relacionado con él
 */
public class Menu {

    //// Atributos
    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    private final ArrayList<String> opciones;
    /**
     * Opción que ingresa el usuario, se usa en los métodos desplegarMenu y switchMenu
     */
    private int eleccion;
    /**
     * Validador usado en la clase Menu
     */
    private final Validador v = new Validador();

    //// Abreviaturas de variables globales
    Agenda agenda = App.agenda;

    //// Constructores
    public Menu(ArrayList<String> opciones) {
        this.opciones = opciones;
    }

    //// Métodos
    /**
     * Método que muestra un menú con las opciones del gestor
     */
    public void desplegarMenu() {

        // Muestra el nombre del gestor con algo de decoración
        mostrarLogo();

        System.out.println("Menu de selección:");

        // Muestra las opciones
        enumerarArrayList(opciones);

        eleccion = v.validarInt(1, opciones.size(),
                "Escoja una opción: ",
                "La opción ingresada no existe.");
    }

    /**
     * Método para mostrar el nombre del gestor con algo de decoración
     */
    public void mostrarLogo(){
        System.out.println("******************************************");
        System.out.println("=========\\\\Gestor PhoneBook VLB//=========");
        System.out.println("******************************************");
    }

    /**
     * Método para mostrar una lista numerada de los datos dentro de un ArrayList
     * @param al ArrayList que se quiere ordenar
     */
    public void enumerarArrayList(ArrayList<String> al){
        if(al != null) {
            for (int i = 1; i <= al.size(); i++) {
                System.out.println(i + ".- " + al.get(i - 1));
            }
        }
        else{
            System.out.println("Error: ArrayList nulo");
        }
    }

    /**
     * Método para llamar otros métodos dependiendo de lo que haya ingresado el usuario
     */
    public void switchMenu() {
        //Switch para la selección, tomando variable seleccion del método desplegarMenu
        switch (eleccion) {
            case 1 -> agenda.crearContacto(); // recordar que agenda = App.agenda
            case 2 -> agenda.listarContactos();
            case 3 -> agenda.mostrarContacto();
            case 4 -> agenda.editarContacto();
            case 5 -> agenda.eliminarContacto();
            case 6 -> App.seguir = salir();
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     * @return Boolean que le indica al programa si debe seguir funcionando (true) o no (false)
     */
    public boolean salir() {
        int a = v.validarInt(0, 1,
                "¿Desea salir del programa? 1=Sí 0=No\nEscoja una opción: ",
                "La opción ingresada no existe.");

        return a != 1;
    }

    //// Getters y Setters
    public int getEleccion() {
        return eleccion;
    }
}
