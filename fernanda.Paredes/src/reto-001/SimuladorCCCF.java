import java.util.Random;

public class SimuladorCCCF {

    public static void main(String[] args) {
        Random rand = new Random();
        LaFila fila = new LaFila(rand);

        int totalAtendidos = 0;
        int totalAburridos = 0;
        final int DURACION_MINUTOS = 120;

        System.out.println("===============================================================");
        System.out.println(" SIMULACION CCCF - CONTROL DE FILA (2 HORAS)");
        System.out.println("===============================================================");
        System.out.printf("%-8s | %-12s | %s%n", "Minuto", "Longitud (m)", "Eventos destacados");
        System.out.println("---------------------------------------------------------------");

        for (int m = 1; m <= DURACION_MINUTOS; m++) {
            StringBuilder eventos = new StringBuilder();

            if (m < 20) {
                if (rand.nextDouble() < 0.60) {
                    fila.llegadaNormal(new Persona(m, false));
                    eventos.append("+Llegada ");
                }
            } else {
                double dadoLlegada = rand.nextDouble();

                if (dadoLlegada < 0.45) {
                    if (fila.llegadaNormal(new Persona(m, false))) {
                        eventos.append("+Llegada ");
                    } else {
                        eventos.append("(Desistió por fila larga) ");
                    }
                } else if (dadoLlegada < 0.55) {
                    if (fila.llegadaPreferente(new Persona(m, true))) {
                        eventos.append("+Preferente ");
                    } else {
                        eventos.append("(Preferente desistió) ");
                    }
                } else if (dadoLlegada < 0.62) {
                    if (fila.colarseDetrasDeConocido(new Persona(m, false))) {
                        eventos.append("+Colado ");
                    }
                } else if (dadoLlegada < 0.68 && !fila.estaVacia()) {
                    eventos.append("~TraspasoCompra ");
                }

                if (m % 5 == 0) {
                    int salieron = fila.purgarAburridos(m);
                    if (salieron > 0) {
                        totalAburridos += salieron;
                        eventos.append("-Abandono(").append(salieron).append(") ");
                    }
                }

                if (m % 15 == 0 && fila.getLongitudMetros() > 25) {
                    Persona atendidoRapido = fila.atender();
                    if (atendidoRapido != null) {
                        totalAtendidos++;
                        eventos.append(">>CajaParlante(P").append(atendidoRapido.getId()).append(") ");
                    }
                }
            }

            if (rand.nextDouble() < 0.40) {
                Persona atendido = fila.atender();
                if (atendido != null) {
                    totalAtendidos++;
                    eventos.append("Atendido(P").append(atendido.getId()).append(") ");
                }
            }

            System.out.printf("%-8d | %-12d | %s%n", m, fila.getLongitudMetros(), eventos.toString().trim());
        }

        System.out.println("===============================================================");
        System.out.println("RESUMEN AL CIERRE (Minuto 120):");
        System.out.println("Total personas atendidas: " + totalAtendidos);
        System.out.println("Total personas que abandonaron por aburrimiento: " + totalAburridos);
        System.out.println("Personas restantes en fila: " + fila.getLongitudMetros());
        System.out.println("Longitud final de la fila: " + fila.getLongitudMetros() + " metros.");
        System.out.println("===============================================================");
    }
}