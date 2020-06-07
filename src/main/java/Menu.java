
// Importa la clase ArrayList (todavía no se usa;
import java.util.ArrayList;

/**
 * Acá ira el menú del proyecto PhoneBook y todo lo relacionado con él
 */
public class Menu {

    //// Atributos
    /**
     * Arreglo de Strings que contiene las opciones del menú
     */
    private ArrayList<String> opciones;
    /**
     * Opción que ingresa el usuario, se usa en los métodos desplegarMenu y switchMenu
     */
    private int eleccion;
    /**
     * Validador usado en la clase Menu
     */
    private Validador v = new Validador();

    //// Abreviaturas de variables globales
    Agenda agenda = PhoneBook.agenda;

    //// Constructores
    public Menu(ArrayList opciones) {
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

        this.eleccion = v.validarInt("Escoja una opción: ");
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
     * Método para enumerar los datos dentro de un ArrayList
     * @param al ArrayList que se quiere ordenar
     */
    public void enumerarArrayList(ArrayList al){
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
     * Método para interpretar la selección en el menú principal
     */
    public void switchMenu() {
        //Switch para la selección, tomando variable seleccion del método desplegarMenu
        switch (eleccion) {
            case 1:
                agenda.crearContacto();
                break;

            case 2:
                agenda.listarContactos();
                break;

            case 3:
                agenda.mostrarContacto();
                break;

            case 4:
                agenda.editarContacto();
                break;

            case 5:
                agenda.eliminarContacto();
                break;

            case 6:
                salir();
                break;

            default:
                System.out.println("La opción ingresada no existe.");
        }
    }

    /**
     * Método que se usa para confirmar la salida del programa
     */
    private void salir() {
        boolean valido = false;
        int a;
        do {
            System.out.println("¿Desea salir del programa? 1=Sí 0=No");
            a = v.validarInt("Escoja una opción: ");
            switch (a) {
                case 1:
                    PhoneBook.seguir = false;
                case 0:
                    valido = true;
                    break;
                default:
                    System.out.println("La opción ingresada no existe.");
            }
        } while (!valido);
    }

    //// Getters y Setters
    public int getEleccion() {
        return eleccion;
    }
}
