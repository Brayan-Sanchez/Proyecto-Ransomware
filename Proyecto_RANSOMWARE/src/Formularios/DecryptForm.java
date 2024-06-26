package Formularios;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DecryptForm extends JFrame {

    public DecryptForm(File fileToDecrypt) {

        setTitle("Formulario de Descifrado");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel decryptLabel = new JLabel("Descifrando archivo: " + fileToDecrypt.getAbsolutePath());
        add(decryptLabel);
    }
}
