package com.vlb.phonebook;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GestorJSON {

    //// Atributos
    static Agenda test = Principal.agenda;
    static GestorArchivo ga = new GestorArchivo();

    //// Métodos
    public static void guardarJSON(){

        JSONArray agenda = new JSONArray();
        int contador = 0;

        for(Contacto c: test.getContactos()){
            contador++;
            agenda.put("Contacto #"+contador+":");

            JSONArray contacto = new JSONArray();

            if(c.getNombre() == null){
                contacto.put("null");
            }
            else{
                // Crea un objeto con el nombre
                JSONObject nombre = new JSONObject();
                nombre.put("nombre", c.getNombre());

                // Añade el nombre al JSONArray del contacto
                contacto.put(nombre);
            }

            contacto.put("listaTelefonos");
            if(c.getTelefonos().size() == 0){
                contacto.put("null");
            }
            else{
                JSONArray listaTelefonos = new JSONArray();
                for(Telefono t: c.getTelefonos()) {
                    JSONObject telefono = new JSONObject();

                    // Guarda el número y tipo en un JSONObject
                    telefono.put("numero", t.getNumero());
                    telefono.put("tipo", t.getTipo());

                    // Añade el teléfono a la lista de teléfonos
                    listaTelefonos.put(telefono);
                }

                // Añade el arreglo con los teléfonos al contacto
                contacto.put(listaTelefonos);
            }

            contacto.put("direccion");
            if(c.getDireccion() == null){
                contacto.put("null");
            }
            else{
                JSONObject direccion = new JSONObject();
                direccion.put("ciudad", c.getDireccion().getCiudad());
                direccion.put("calle", c.getDireccion().getCalle());
                direccion.put("numero", c.getDireccion().getNumero());

                // Añade la dirección
                contacto.put(direccion);
            }

            contacto.put("listaEmails:");
            if(c.getEmails().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de emails usando el ArrayList
                JSONArray listaEmails = new JSONArray(c.getEmails());

                // Añade la  lista de emails al contacto
                contacto.put(listaEmails);
            }

            contacto.put("listaApodos:");
            if(c.getApodos().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de apodos usando el ArrayList
                JSONArray listaApodos = new JSONArray(c.getApodos());

                // Añade la  lista de apodos al contacto
                contacto.put(listaApodos);
            }

            contacto.put("fechaCumple:");
            if(c.getFechaCumple() == null){
                contacto.put("null");
            }
            else{
                JSONObject fechacumple = new JSONObject();
                fechacumple.put("dia", c.getFechaCumple().getDia());
                fechacumple.put("numeroMes", c.getFechaCumple().getNumeroMes());
                fechacumple.put("mes", c.getFechaCumple().getMes());

                // Añade el mes
                contacto.put(fechacumple);
            }

            contacto.put("listaNotas:");
            if(c.getNotas().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de notas usando el ArrayList
                JSONArray listaNotas = new JSONArray(c.getNotas());

                // Añade la  lista de notas al contacto
                contacto.put(listaNotas);
            }

            // Añade el contacto a la agenda
            agenda.put(contacto);
        }

        // Muestra el JSON
        System.out.println(agenda.toString(4));

        // Guarda el JSON en un archivo "agenda.json"
        ga.crearArchivo(agenda.toString(4), "agenda.json");
    }

    /**
     * Método que carga un el archivo agenda.json (si este existe), y carga sus datos en en JSONArray Principal.agendaJSON
     */
    public static void cargarJSON(){
        // Si el archivo "agenda.json" existe, cargarlo
        if (Files.exists(Paths.get("agenda.json"))) {
            // Carga los datos de "agenda.json" al JSONArray agendaJSON
            Principal.agendaJSON = ga.convertirArchivoAJSONArray("agenda.json");

            System.out.println("Datos de \"agenda.json\" cargados");

            // Muestra el JSON en pantalla, para verificar que funcionó bien
            System.out.println(Principal.agendaJSON.toString());
        }
    }
}
