import javax.swing.*;

public class Lista {

    private Nodo inicio;
    private int tamano;

    public Lista() {
        this.inicio = null;
        this.tamano = 0;
    }

    // Método para agregar un valor entero al final de la lista
    public void agregar(int dato, JTextArea textArea) {

        Nodo nuevoNodo = new Nodo(dato, null);

        if (this.inicio == null) {

            this.inicio = nuevoNodo;
        } else {

            Nodo actual = this.inicio;
            while (actual.getSiguiente() != null) {

                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoNodo);
        }

        tamano++;
        actualizarTextArea(textArea);
    }

    // Método para eliminar un valor entero de la lista
    public boolean eliminar(int dato, JTextArea textArea) {

        if (this.inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return false;
        }
        if (this.inicio.getDato() == dato) {

            this.inicio = this.inicio.getSiguiente();
            this.tamano--;
            actualizarTextArea(textArea);
            return true;
        }

        Nodo actual = inicio;

        while (actual.getSiguiente() != null && actual.getSiguiente().getDato() != dato) {

            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {

            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            this.tamano--;
            actualizarTextArea(textArea);
            return true;
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado en la lista.");
        return false;
    }

    // Método para realizar una búsqueda lineal
    public int buscarLineal(int dato,  JTextArea textArea) {

        Nodo actual = this.inicio;
        int posicion = 0;
        while (actual != null) {

            if (actual.getDato() == dato) {

                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // Método para ordenar la lista usando burbuja
    public void ordenarBurbuja(JTextArea textArea) {

        if (this.inicio == null || this.inicio.getSiguiente() == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = this.inicio;
            Nodo siguiente = this.inicio.getSiguiente();
            while (siguiente != null) {
                if (actual.getDato() > siguiente.getDato()) {
                    int temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.getSiguiente();
            }
        } while (swapped);

        actualizarTextArea(textArea); // Actualiza la vista en el JTextArea
    }

    // Método para mostrar la lista en el JTextArea
    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía.");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.getDato()).append("\n");
                actual = actual.getSiguiente();
            }
            textArea.setText(listaStr.toString());
        }
    }

    // Método para actualizar el JTextArea cada vez que cambia la lista
    private void actualizarTextArea(JTextArea textArea) {
        mostrarLista(textArea);
    }
}
