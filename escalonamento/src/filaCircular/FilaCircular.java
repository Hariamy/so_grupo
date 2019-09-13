package filaCircular;

import processo.Processo;

import java.util.ArrayList;

public class FilaCircular {

    ArrayList<Processo> ready;

    public FilaCircular() {
        this.ready = new ArrayList<>();
    }

    private synchronized void addProcesso(Processo processo) {
        ready.add(processo);
    }

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

    public int getSize() {
        return ready.size();
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
