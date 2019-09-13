package processo;

import java.util.concurrent.TimeUnit;

public class Processo extends Thread {
    private int numero;
    private long inicio;
    private long fim;

    public Processo(int numero) {
        this.numero = numero;
    }

    private void esperar() {
        try {
            sleep(5);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void setInicio() {
        this.inicio = System.nanoTime();
    }

    public void setFim() {
        this.fim = System.nanoTime();
    }

    public long getTurnaround() {
        return TimeUnit.MILLISECONDS.convert(fim-inicio, TimeUnit.NANOSECONDS);
    }

    @Override
    public void run() {
        System.out.println("Start thread " + numero);
        for (int i = 0; i < numero; i++) {
            System.out.println("[PROCESS "+numero+"]" + " - "+i);
            esperar();
        }
    }

    @Override
    public String toString() {
        return "[THREAD "+numero+"]";
    }
}
