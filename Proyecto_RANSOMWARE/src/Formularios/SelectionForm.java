package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectionForm extends JFrame {
    private JLabel folderLabel;
    private JLabel encryptedFileLabel;
    private JFileChooser folderChooser;
    private JFileChooser fileChooser;
    private File selectedFolder;
    private File selectedFile;

    public SelectionForm() {
        setTitle("Seleccionar Archivos y Carpetas");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        folderLabel = new JLabel("Selecciona una carpeta:");
        add(folderLabel);

        folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JButton selectFolderButton = new JButton("Seleccionar carpeta");
        selectFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = folderChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFolder = folderChooser.getSelectedFile();
                    folderLabel.setText("Carpeta seleccionada: " + selectedFolder.getAbsolutePath());
                }
            }
        });
        add(selectFolderButton);

        encryptedFileLabel = new JLabel("Selecciona un archivo cifrado:");
        add(encryptedFileLabel);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JButton selectFileButton = new JButton("Seleccionar archivo");
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    encryptedFileLabel.setText("Archivo seleccionado: " + selectedFile.getAbsolutePath());
                }
            }
        });
        add(selectFileButton);

        JButton encryptButton = new JButton("Cifrar");
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EncryptForm(selectedFolder).setVisible(true);
            }
        });
        add(encryptButton);

        JButton decryptButton = new JButton("Descifrar");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DecryptForm(selectedFile).setVisible(true);
            }
        });
        add(decryptButton);
    }
}

