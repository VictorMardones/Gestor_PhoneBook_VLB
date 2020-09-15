package interfaz_grafica;

import lanzador.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogTextoGeneral extends JDialogGeneral {

    //// Atributos
    /**
     * Texto que contiene el área
     */
    protected String texto;
    /**
     * Área con el texto
     */
    protected JTextArea textArea;
    /**
     * Scroll para el área de texto
     */
    protected JScrollPane scroll;

    //// Constructores
    protected JDialogTextoGeneral() {
        // Este constructor es protegido, significa que esta clase no se puede instanciar
    }

    //// Métodos
    @Override
    protected void inicializarComponentes(){
        super.inicializarComponentes();

        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        botonVolverAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        textArea = new JTextArea(texto);
        textArea.setVisible(true);
        // Para que no se pueda editar
        textArea.setEditable(false);

        // Instancia el JScrollPane para la textArea (y define el funcionamiento vertical y horizontal)
        scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    protected void ubicarComponentes(){
        panel.add(scroll);
        panel.add(botonVolverAtras);

        add(panel);
    }

    @Override
    protected void configurarVentana(){
        super.configurarVentana();

        // Tamaño inicial
        setSize(400, 350);
    }
}
