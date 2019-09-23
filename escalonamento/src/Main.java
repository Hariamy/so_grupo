import filaCircular.FilaCircular;
import processo.Processo;
import simulador.Simulador;

import java.util.concurrent.TimeUnit;

public class Main {
    private static void esperar() {
        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        RoundRobin roundRobin1 = new RoundRobin();
        RoundRobin roundRobin2 = new RoundRobin();
        RoundRobin roundRobin3 = new RoundRobin();
        RoundRobin roundRobin4 = new RoundRobin();
        RoundRobin roundRobin5 = new RoundRobin();
        FCFS fcfs1 = new FCFS();
        FCFS fcfs2 = new FCFS();
        FCFS fcfs3 = new FCFS();
        FCFS fcfs4 = new FCFS();
        FCFS fcfs5 = new FCFS();

        roundRobin1.simular();
        esperar();
        roundRobin2.simular();
        esperar();
        roundRobin3.simular();
        esperar();
        roundRobin4.simular();
        esperar();
        roundRobin5.simular();
        esperar();


        fcfs1.simular();
        esperar();
        fcfs2.simular();
        esperar();
        fcfs3.simular();
        esperar();
        fcfs4.simular();
        esperar();
        fcfs5.simular();
    }
}
