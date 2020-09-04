package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    //// Atributos
    /**
     * Panel principal
     */
    private JPanel panel;
    /**
     * Panel con las opciones del menú principal
     */
    private JPanel panelOpciones;
    /**
     * Label con el nombre del programa
     */
    private JLabel labelGestorPhoneBook;
    /**
     * Botón para crear un nuevo contacto
     */
    private JButton botonNuevoContacto;
    /**
     * Botón para ver los datos de un contacto
     */
    private JButton botonDatosContacto;
    /**
     * Botón para acceder al menú de edición de un contacto
     */
    private JButton botonEditarContacto;
    /**
     * Botón para eliminar a un contacto
     */
    private JButton botonEliminarContacto;
    /**
     * Botón para salir del programa
     */
    private JButton botonSalir;

    //// Constructores
    public VentanaPrincipal(){
        inicializar();

        //// Otras características de la ventana

        // Título
        setTitle("Gestor Phonebook VLB");
        // Tamaño inicial
        setSize(500, 500);
        // La ventana inicia centrada
        setLocationRelativeTo(null);
        // Inhabilita la opción de cambiar el tamaño de la ventana
        // setResizable(false);
        // Cuando se cierre la ventana se finaliza el programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //// Métodos
    /**
     * Método para iniciar la ventana principal (instancia todos los objetos necesarios)
     */
    private void inicializar(){
        // Carga el ícono de la aplicación
        cargarIcono();

        // Instancia el JPanel
        panel = new JPanel();
        // Usa el BoxLayout para mostrar los botones verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        // Crea un borde para el panel con las opciones
        panelOpciones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true), "Opciones"));

        // Instancia el JLabel
        labelGestorPhoneBook = new JLabel("Gestor PhoneBook VLB");
        // Centra el label (con los botones se hace lo mismo)
        labelGestorPhoneBook.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Usa letra más grande
        labelGestorPhoneBook.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        // Instancia los JButton
        botonNuevoContacto = new JButton("Crear un contacto nuevo");
        botonNuevoContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonDatosContacto = new JButton("Ver datos de un contacto");
        botonDatosContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEditarContacto = new JButton("Editar un contacto");
        botonEditarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonEliminarContacto = new JButton("Eliminar un contacto");
        botonEliminarContacto.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonSalir = new JButton("Salir del programa");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añade los objetos al JPanel
        panel.add(labelGestorPhoneBook);

        panelOpciones.add(botonNuevoContacto);
        panelOpciones.add(botonDatosContacto);
        panelOpciones.add(botonEditarContacto);
        panelOpciones.add(botonEliminarContacto);
        panelOpciones.add(botonSalir);
        panel.add(panelOpciones);

        // Añade el JPanel al JFrame
        add(panel);

        // Implementa ActionListener para los botones
        botonNuevoContacto.addActionListener(this);
        botonDatosContacto.addActionListener(this);
        botonEditarContacto.addActionListener(this);
        botonEliminarContacto.addActionListener(this);
        botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botonNuevoContacto){
            setVisible(false);

            // Instancia una ventana para crear un contacto y la hace visible
            VentanaNuevoContacto vnc = new VentanaNuevoContacto();
            vnc.setVisible(true);
        }

        if (ae.getSource() == botonDatosContacto) {
            setVisible(false);

            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere ver");
            vec.setVisible(true);
        }

        if (ae.getSource() == botonEditarContacto){
            setVisible(false);

            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere editar");
            vec.setVisible(true);
        }

        if (ae.getSource() == botonEliminarContacto){
            setVisible(false);

            // Instancia una ventana para elegir un contacto y la hace visible
            VentanaElegirContacto vec = new VentanaElegirContacto("Escoja el contacto que quiere borrar");
            vec.setVisible(true);
        }

        if (ae.getSource() == botonSalir){
            setVisible(false);

            // Crea el panel para pedir confirmación
            int n = JOptionPane.showConfirmDialog(panel.getParent(),
                    "¿Está seguro de que desea salir?",
                    "Salir del programa",
                    JOptionPane.YES_NO_OPTION);

            // Si el usuario escoge "Sí"
            if(n == JOptionPane.YES_OPTION){
                // Sale del programa y retorna 0
                System.exit(0);
            }
        }
    }

    /**
     * Método que carga el ícono de la aplicación desde un archivo externo
     */
    private void cargarIcono() {
        Image icono = Toolkit.getDefaultToolkit().getImage("archivos/icono_phonebook_nuevo.png");
        setIconImage(icono);
    }
}
