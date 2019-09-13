import filaCircular.FilaCircular;
import processo.Processo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main extends Throwable{

    public static void main(String[] args) {
        final FilaCircular ready = new FilaCircular();

        int quantum = (int)(Math.random()*(500 - 100) + 100);

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

        while (true) {
            Processo p = ready.modify(null);
            if (p != null) {
                p.start();

                try {
                    TimeUnit.MILLISECONDS.sleep(quantum);
                    p.stop();
                    ready.modify(p);
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private void esperar(int tempo) {
        try {
            TimeUnit.MILLISECONDS.sleep(tempo);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}