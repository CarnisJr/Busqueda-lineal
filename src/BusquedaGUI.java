
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaGUI {
    private JTextField inputField;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarLinealButton;
    private JTextArea txtResultado;
    private JPanel pGeneral;
    private JButton mostrarButton;
    Lista lista = new Lista();

    public BusquedaGUI() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, txtResultado);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor, txtResultado);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarBurbuja(txtResultado);
                JOptionPane.showMessageDialog(null, "Lista ordenada con el método Burbuja.");
            }
        });

        buscarLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarLineal(valor, txtResultado);
                    if (posicion == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento encontrado en posición: " + posicion);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaGUI");
        frame.setContentPane(new BusquedaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
