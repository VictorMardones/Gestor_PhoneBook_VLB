package phonebook;

public class Editor extends Menu{
    /**
     * Método para volver al menú editor (cuarta o tercera opción de switchMenu)
     */
    protected void volverAtras(){
        System.out.println("Ha salido del "+nombreMenu);
        seguir = false; // No pide confirmación
    }
}