package UE00_WHP;


/**
 * @author Sofia Angerer
 */
public abstract class Komponente {
    int[] valueInputs;
    Input[] myInputs;
    Output[] myOutputs;

    /**
     * verbindet zwei Komponenten miteinander
     * @param otherKomp Komponente, mit der verbunden wird
     * @param myInput Input, an dem die andere Komponente angeschlossen wird
     * @param otherOutput Output, der am Input angeschlossen wird
     */
    public void connect(Komponente otherKomp, int myInput, int otherOutput) {
        myInputs[myInput].connect(otherKomp.myOutputs[otherOutput]);
    }

    /**
     * Werte an den Inputs setzen --> Werte der anderen Outputs erfahren
     */
    public void phase1() {
        for (int i = 0; i < valueInputs.length; i++) {
            valueInputs[i] = myInputs[i].otherOutput.getValue();
        }
    }

    /**
     * calc-Methode
     */
    public void calc() {

    }

    public Komponente(int anzahlInputs, int anzahlOutputs) {
        this.myInputs = new Input[anzahlInputs];
        for (int i = 0; i < anzahlInputs; i++) {
            myInputs[i] = new Input();
        }
        this.myOutputs = new Output[anzahlOutputs];
        for (int i = 0; i < anzahlOutputs; i++) {
            myOutputs[i] = new Output();
        }
        this.valueInputs = new int[anzahlInputs];
    }
}
