package processo;


public class Processo extends Thread {
    private int numero;
    private boolean iniciada;
    private long startTime;
    private long endTime;

    public Processo(int numero) {
        this.numero = numero;
        this.iniciada = false;
    }

    private void esperar() {
        try {
            sleep(5);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public long turnaround() {
        return (endTime - startTime)/10000000;
    }

    public boolean getIniciada() {
        return iniciada;
    }

    @Override
    public void run() {
        this.startTime = System.nanoTime();
        this.iniciada = true;
        System.out.println("( START PROCESS " + numero + " )");
        for (int i = 0; i < numero; i++) {
            System.out.println("[PROCESS " + numero + "]" + " - " + i);
            esperar();
        }
        this.endTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return "[PROCESS "+numero+"]";
    }
}
