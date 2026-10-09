package entregas.paredesFernanda;

public class EjemploListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada lista1 = new ListaEnlazada();
        lista1.insertarAlPrincipio(4);
        lista1.insertarAlPrincipio(3);
        lista1.insertarAlPrincipio(3);
        lista1.insertarAlPrincipio(2);
        lista1.insertarAlPrincipio(1);
        lista1.insertarAlPrincipio(1);

        System.out.print("Entrada:            ");
        lista1.imprimirLista();

        lista1.eliminarRepetidos();
        System.out.print("Con Dummy (Salida): ");
        lista1.imprimirLista();

        System.out.println("------------------------------------");

        ListaEnlazada lista2 = new ListaEnlazada();
        lista2.insertarAlPrincipio(4);
        lista2.insertarAlPrincipio(3);
        lista2.insertarAlPrincipio(3);
        lista2.insertarAlPrincipio(2);
        lista2.insertarAlPrincipio(1);
        lista2.insertarAlPrincipio(1);

        System.out.print("Entrada:            ");
        lista2.imprimirLista();

        lista2.eliminarRepetidosSinDummy();
        System.out.print("Sin Dummy (Salida): ");
        lista2.imprimirLista();
    }
}