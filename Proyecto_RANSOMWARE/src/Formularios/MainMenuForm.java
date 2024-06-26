package Formularios;

import Encriptacion.Encriptacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MainMenuForm extends JFrame {
    private File fileToEncrypt;
    private Encriptacion encriptacion;

    public MainMenuForm() {
        setTitle("Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton openSelectionFormButton = new JButton("Seleccionar Archivos/Carpetas");
        openSelectionFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    fileToEncrypt = fileChooser.getSelectedFile();
                }
            }
        });
        add(openSelectionFormButton);

        JButton encryptButton = new JButton("Encriptar");
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileToEncrypt != null) {
                    String clave = JOptionPane.showInputDialog("Por favor, introduce la clave de encriptación:");
                    try {
                        encriptacion = new Encriptacion(clave);
                        encriptacion.encriptar(fileToEncrypt.getAbsolutePath());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });
        add(encryptButton);

        JButton decryptButton = new JButton("Desencriptar");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileToEncrypt != null) {
                    String clave = JOptionPane.showInputDialog("Por favor, introduce la clave de desencriptación:");
                    try {
                        encriptacion = new Encriptacion(clave);
                        encriptacion.desencriptar(fileToEncrypt.getAbsolutePath());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });
        add(decryptButton);
    }
}