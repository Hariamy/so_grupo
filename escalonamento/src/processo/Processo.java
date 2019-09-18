package processo;


public class Processo extends Thread {
    private int numero;
    private boolean iniciada;

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


    public boolean getIniciada() {
        return iniciada;
    }

    @Override
    public void run() {
        this.iniciada = true;
        System.out.println("( START THREAD " + numero + " )");
        for (int i = 0; i < numero; i++) {
            System.out.println("[PROCESS " + numero + "]" + " - " + i);
            esperar();
        }
    }

    @Override
    public String toString() {
        return "[THREAD "+numero+"]";
    }
}
