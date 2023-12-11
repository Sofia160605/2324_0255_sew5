package UE00_WHP;

/**
 * @author Sofia Angerer
 */

public class LED extends Komponente{

    int isOn = 0;

    public LED() {
        super(1, 0);
    }

    public void phase1() {
        this.isOn = myInputs[0].otherOutput.getValue();
    }

    public void calc() {}
}