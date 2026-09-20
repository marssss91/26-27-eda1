public class Persona {
    private static int autoincremento = 1;

    private int id;
    private int minutoLlegada;
    private boolean esPreferente;

    public Persona(int minutoLlegada, boolean esPreferente){
        this.id = autoincremento++;
        this.minutoLlegada = minutoLlegada;
        this.esPreferente = esPreferente;
    }
    public int getId() {
        return id;
    }

    public int getMinutoLlegada() {
        return minutoLlegada;
    }

    public int tiempoEnFila(int minutoActual) {
        return minutoActual - minutoLlegada;
    }

    public boolean esPreferente() {
    return esPreferente;
}

    @Override
    public String toString() {
        return "P" + id + (esPreferente ? "[Pref]": "");
    }
}