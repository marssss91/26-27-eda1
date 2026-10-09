package entregas.paredesFernanda;

public class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void insertarAlPrincipio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void imprimirLista() {
        if (cabeza == null) {
            System.out.println("null");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void eliminarRepetidos() {
        Nodo nodoDummy = new Nodo(0);
        nodoDummy.siguiente = cabeza;
        Nodo nodoAnterior = nodoDummy;

        while (nodoAnterior.siguiente != null) {
            Nodo nodoActual = nodoAnterior.siguiente;
            boolean esRepetido = false;

            while (nodoActual.siguiente != null && nodoActual.dato == nodoActual.siguiente.dato) {
                esRepetido = true;
                nodoActual = nodoActual.siguiente;
            }

            if (esRepetido) {
                nodoAnterior.siguiente = nodoActual.siguiente;
            } else {
                nodoAnterior = nodoActual;
            }
        }

        cabeza = nodoDummy.siguiente;
    }

    public void eliminarRepetidosSinDummy() {
        while (cabeza != null && cabeza.siguiente != null && cabeza.dato == cabeza.siguiente.dato) {
            int valorRepetido = cabeza.dato;
            while (cabeza != null && cabeza.dato == valorRepetido) {
                cabeza = cabeza.siguiente;
            }
        }


        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.siguiente != null && actual.siguiente.dato == actual.siguiente.siguiente.dato) {
                int valorRepetido = actual.siguiente.dato;
                while (actual.siguiente != null && actual.siguiente.dato == valorRepetido) {
                    actual.siguiente = actual.siguiente.siguiente;
                }
            } else {
                actual = actual.siguiente;
            }
        }
    }
}