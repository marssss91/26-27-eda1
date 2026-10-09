package entregas.paredesFernanda;

public class EjemploListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarAlPrincipio(4);
        lista.insertarAlPrincipio(3);
        lista.insertarAlPrincipio(3);
        lista.insertarAlPrincipio(2);
        lista.insertarAlPrincipio(1);
        lista.insertarAlPrincipio(1);

        System.out.print("Entrada:            ");
        lista.imprimirLista();

        lista.eliminarRepetidos();

        System.out.print("Con Dummy (Salida): ");
        lista.imprimirLista();
    }
}