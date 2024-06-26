package Formularios;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EncryptForm extends JFrame {

    public EncryptForm(File folderToEncrypt) {

        setTitle("Formulario de Cifrado");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel encryptLabel = new JLabel("Cifrando carpeta: " + folderToEncrypt.getAbsolutePath());
        add(encryptLabel);
    }
}