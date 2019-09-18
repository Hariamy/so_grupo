package filaCircular;

import processo.Processo;

import java.lang.annotation.Documented;
import java.util.ArrayList;

public class FilaCircular {

    ArrayList<Processo> ready;

    public FilaCircular() {
        this.ready = new ArrayList<>();
    }

    /**
     * ele adiciona processo
     * @param processo: processo eh um borogodo que sera usado paraborogoda
     */
    private synchronized void addProcesso(Processo processo) {
       //lallll
        ready.add(processo);
    }

    /**
     * Esse metodo processo faz tal coisa
     * @return uma listade borogosdo
     */
    private synchronized Processo getProcesso() {

        if (!ready.isEmpty()) {
            Processo processo = ready.get(0);

            ArrayList<Processo> newReady = new ArrayList<>();

            for ( Processo p: ready ) {
                if (p != processo) newReady.add( p);
            }

            ready = newReady;
            return processo;

        }
        return null;
    }

    public synchronized Processo modify(Processo processo) {
        if (processo != null) {
            addProcesso(processo);
            return null;
        } else {
            return getProcesso();
        }
    }
}
