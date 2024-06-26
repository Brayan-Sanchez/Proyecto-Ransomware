package Formularios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioVictima extends JFrame implements ActionListener {

    private final JTextField campoNombre;
    private final JTextField campoCorreo;
    private final JTextField campoIpVictima;
    private final JTextField campoLlaveCifrado;
    private final JTextField campoLlaveDescifrado;
    private final JButton botonGuardar;
    private final JButton botonCancelar;
    private final DefaultTableModel modeloTabla;

    // Constructor
    public FormularioVictima() {
        // Configura el título del JFrame
        super("Formulario de Víctima");

        // Configura el layout del JFrame
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(6, 2, 5, 5));

        // Inicializa las etiquetas y los campos de texto
        // Declara los componentes
        JLabel labelNombre = new JLabel("Nombre:");
        campoNombre = new JTextField(20);
        JLabel labelCorreo = new JLabel("Correo Electrónico:");
        campoCorreo = new JTextField(20);
        JLabel labelIpVictima = new JLabel("IP Víctima:");
        campoIpVictima = new JTextField(20);
        JLabel labelLlaveCifrado = new JLabel("Llave Cifrado:");
        campoLlaveCifrado = new JTextField(20);
        JLabel labelLlaveDescifrado = new JLabel("Llave Descifrado:");
        campoLlaveDescifrado = new JTextField(20);

        // Agrega las etiquetas y los campos de texto al panel principal
        panelPrincipal.add(labelNombre);
        panelPrincipal.add(campoNombre);
        panelPrincipal.add(labelCorreo);
        panelPrincipal.add(campoCorreo);
        panelPrincipal.add(labelIpVictima);
        panelPrincipal.add(campoIpVictima);
        panelPrincipal.add(labelLlaveCifrado);
        panelPrincipal.add(campoLlaveCifrado);
        panelPrincipal.add(labelLlaveDescifrado);
        panelPrincipal.add(campoLlaveDescifrado);

        // Inicializa los botones
        botonGuardar = new JButton("Guardar");
        botonCancelar = new JButton("Cancelar");

        // Agrega los botones al panel principal
        panelPrincipal.add(botonGuardar);
        panelPrincipal.add(botonCancelar);

        // Configura el modelo de la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("IP Víctima");
        modeloTabla.addColumn("Llave Cifrado");
        modeloTabla.addColumn("Llave Descifrado");

        // Inicializa la tabla
        JTable tablaDatos = new JTable(modeloTabla);

        // Agrega el panel principal y la tabla al JFrame
        add(panelPrincipal, BorderLayout.NORTH);
        add(new JScrollPane(tablaDatos), BorderLayout.CENTER);

        // Configura los botones para escuchar eventos
        botonGuardar.addActionListener(this);
        botonCancelar.addActionListener(this);

        // Configura el tamaño del JFrame
        setSize(600, 400);

        // Configura el comportamiento de cierre del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el JFrame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGuardar) {
            // Obtiene el texto de los campos y agrega una nueva fila a la tabla
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            String ipVictima = campoIpVictima.getText();
            String llaveCifrado = campoLlaveCifrado.getText();
            String llaveDescifrado = campoLlaveDescifrado.getText();

            modeloTabla.addRow(new Object[]{nombre, correo, ipVictima, llaveCifrado, llaveDescifrado});

            // Limpia los campos de texto
            campoNombre.setText("");
            campoCorreo.setText("");
            campoIpVictima.setText("");
            campoLlaveCifrado.setText("");
            campoLlaveDescifrado.setText("");
        } else if (e.getSource() == botonCancelar) {
            // Limpia los campos de texto
            campoNombre.setText("");
            campoCorreo.setText("");
            campoIpVictima.setText("");
            campoLlaveCifrado.setText("");
            campoLlaveDescifrado.setText("");
        }
    }

    public static void main(String[] args) {
        // Crea una instancia de la clase Formularios.FormularioVictima
        new FormularioVictima();
    }
}

