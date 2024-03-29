package simulador;

import filaCircular.FilaCircular;
import processo.Processo;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulador extends Thread{

    Processo processo;
    int valor;
    FilaCircular ready;

    public Simulador(int tempo, FilaCircular ready) {
        this.processo = new Processo(tempo);
        this.valor = (int)(Math.random()*(500 - 100) + 100);

        System.out.println("| " + valor + " | ENTRADA NA FILA READ DO PROCESSO " + tempo);
        this.ready = ready;
    }

    private void esperar() {
        try {
            sleep(this.valor);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public Processo getProcesso() {
        return processo;
    }

    @Override
    public void run() {
        esperar();
        this.processo.setStartTime();
        ready.modify(this.processo);
    }
}
