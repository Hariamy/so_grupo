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
        System.out.println(valor + " contagem "+tempo);
        this.ready = ready;
    }

    private void esperar() {
        try {
            sleep(this.valor);
            System.out.println(valor + " contagem ");
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        esperar();
        ready.modify(this.processo);
    }
}
