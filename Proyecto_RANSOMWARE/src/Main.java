import Formularios.FormularioVictima;
import Formularios.MainMenuForm;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Formularios.MainMenuForm y hacerla visible
        MainMenuForm mainMenuForm = new MainMenuForm();
        mainMenuForm.setVisible(true);

        // Crear una instancia de Formularios.FormularioVictima y hacerla visible
        FormularioVictima formularioVictima = new FormularioVictima();
        formularioVictima.setVisible(true);
    }
}