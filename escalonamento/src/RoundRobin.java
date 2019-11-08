import filaCircular.FilaCircular;
import processo.Processo;
import simulador.Simulador;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RoundRobin {
    public boolean simular() {
        System.out.println("\n ---- TESTE ROUND ROBIN ----\n");

        final FilaCircular ready = new FilaCircular();

        int quantum = (int)(Math.random()*(500 - 100) + 100);

        System.out.println("Executando teste com o quantum: " + quantum);

        Simulador s1 = new Simulador(100, ready);
        Simulador s2 = new Simulador(200, ready);
        Simulador s3 = new Simulador(300, ready);
        Simulador s4 = new Simulador(400, ready);
        Simulador s5 = new Simulador(500, ready);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();

        int iteracao = 0;
        int count = 0;
        ArrayList<Integer> terminou = new ArrayList<Integer>();
        while (terminou.size() < 5) {
            count += 1;
            Processo p = ready.modify(null);
            if (p != null) {
                try {
                    if (p.getIniciada()) p.resume();
                    else p.start();

                    iteracao += 1;

                    int quant = 0;

                    while (quant != quantum) {
                        if (p.isAlive()) {
                            TimeUnit.MILLISECONDS.sleep(1);
                            quant += 1;
                        } else quant = quantum;
                    }

                    if (p.isAlive()) {
                        p.suspend();
                        ready.modify(p);

                    } else terminou.add(1);
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println("\nTERMINOU A ITERAÇÃO");
        System.out.println(s1.getProcesso() + " Turnaround: " + s1.getProcesso().turnaround() + " ms");
        System.out.println(s2.getProcesso() + " Turnaround: " + s2.getProcesso().turnaround() + " ms");
        System.out.println(s3.getProcesso() + " Turnaround: " + s3.getProcesso().turnaround() + " ms");
        System.out.println(s4.getProcesso() + " Turnaround: " + s4.getProcesso().turnaround() + " ms");
        System.out.println(s5.getProcesso() + " Turnaround: " + s5.getProcesso().turnaround() + " ms");

        return true;
    }
}
