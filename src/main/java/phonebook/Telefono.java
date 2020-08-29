package phonebook;

/**
 * Clase que contiene los datos de un teléfono (número y tipo)
 */
public class Telefono {

    //// Atributos
    /**
     * Número de teléfono
     */
    int numero;
    /**
     * Tipo de teléfono (CELULAR, FIJO, TRABAJO)
     */
    TipoTelefono tipo;

    //// Constructores
    public Telefono(int numero, String tipo) {
        this.numero = numero;
        switch (tipo) {
            case "Celular" -> this.tipo=TipoTelefono.CELULAR;
            case "Fijo" -> this.tipo=TipoTelefono.FIJO;
            case "Trabajo" ->  this.tipo=TipoTelefono.TRABAJO;
        }
    }

    //// Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Este getter toma el tipo del Telefono y lo convierte en un String
     * @return Tipo en forma de String
     */
    public String getTipo() {
        return switch (tipo) {
            case CELULAR -> "Celular";
            case FIJO -> "Fijo";
            case TRABAJO -> "Trabajo";
        };
    }

    /**
     * Este setter toma un String y lo convierte en el tipo
     * @param tipo String que tiene el nombre del tipo2
     */
    public void setTipo(String tipo) {
        switch (tipo) {
            case "Celular" -> this.tipo=TipoTelefono.CELULAR;
            case "Fijo" -> this.tipo=TipoTelefono.FIJO;
            case "Trabajo" ->  this.tipo=TipoTelefono.TRABAJO;
            default -> System.out.println("Error: Parámetros incorrectos");
        }
    }

    @Override
    public String toString() {
        return switch (tipo) {
            case CELULAR -> "Celular: " + numero;
            case FIJO -> "Fijo: " + numero;
            case TRABAJO -> "Trabajo: " + numero;
        };
    }
}

enum TipoTelefono{
    CELULAR,
    FIJO,
    TRABAJO;
}