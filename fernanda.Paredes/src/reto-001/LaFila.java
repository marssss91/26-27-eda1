import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LaFila {
    private LinkedList<Persona> cola;
    private Random random;

    public LaFila(Random random) {
        this.cola = new LinkedList<>();
        this.random = random;
    }

    public int getLongitudMetros() {
        return this.cola.size();
    }

    public boolean estaVacia() {
        return this.cola.isEmpty();
    }

    private boolean decideEntrarSiFilaLarga() {
        if (cola.size() > 30) {
            // true = se queda, false = desiste y se va
            return random.nextDouble() >= 0.50;
        }
        return true;
    }

    public boolean llegadaNormal(Persona p) {
        if (!decideEntrarSiFilaLarga()) {
            return false;
        }
        cola.addLast(p);
        return true;
    }

    public boolean llegadaPreferente(Persona p) {
        if (!decideEntrarSiFilaLarga()) {
            return false;
        }

        int posicionInsercion = 0; // Si nadie es preferente, va directo al frente
        for (int i = cola.size() - 1; i >= 0; i--) {
            if (cola.get(i).esPreferente()) {
                posicionInsercion = i + 1;
                break;
            }
        }

        cola.add(posicionInsercion, p);
        return true;
    }

    public boolean colarseDetrasDeConocido(Persona colado) {
        if (cola.isEmpty()) {
            return llegadaNormal(colado);
        }
        if (!decideEntrarSiFilaLarga()) {
            return false;
        }

        int indiceAmigo = random.nextInt(cola.size());
        cola.add(indiceAmigo + 1, colado);
        return true;
    }

    public Persona atender() {
        if (cola.isEmpty()) {
            return null;
        }
        return cola.pollFirst();
    }

    public int purgarAburridos(int minutoActual) {
        int abandonos = 0;
        Iterator<Persona> it = cola.iterator();

        while (it.hasNext()) {
            Persona p = it.next();
            if (p.tiempoEnFila(minutoActual) > 8) {
                if (random.nextDouble() < 0.30) {
                    it.remove(); // Borrado seguro en listas enlazadas
                    abandonos++;
                }
            }
        }
        return abandonos;
    }
}