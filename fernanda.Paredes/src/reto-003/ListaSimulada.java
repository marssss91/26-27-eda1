public class ListaSimulada {

    int[] datos = new int[2];
    int size = 0;

    void add(int valor) {
        if (size == datos.length) {
            crecer();
        }
        datos[size] = valor;
        size++;
    }

    void insert(int pos, int valor) {
        if (size == datos.length) {
            crecer();
        }
        for (int i = size; i > pos; i--) {
            datos[i] = datos[i - 1];
        }
        datos[pos] = valor;
        size++;
    }

    void remove(int pos) {
        for (int i = pos; i < size - 1; i++) {
            datos[i] = datos[i + 1];
        }
        size--;
    }

    int get(int pos) {
        return datos[pos];
    }

    void crecer() {
        int[] nuevo = new int[datos.length * 2];
        for (int i = 0; i < size; i++) {
            nuevo[i] = datos[i];
        }
        datos = nuevo;
    }

    void mostrar() {
        for (int i = 0; i < size; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaSimulada lista = new ListaSimulada();

        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.mostrar();

        lista.insert(1, 99);
        lista.mostrar();

        lista.remove(0);
        lista.mostrar();
    }
}