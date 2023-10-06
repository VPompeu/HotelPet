package utilitario;

import javax.swing.JOptionPane;
public class Console {

    public static String lerDados(String mensagem) {
        String s = null;
        do {
            s = JOptionPane.showInputDialog(null, mensagem);
        } while (s.isEmpty());
        return s;
    }

    public static void mostrarDados(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
