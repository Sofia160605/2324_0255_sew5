package UE00_WHP;

/**
 * @author Sofia Angerer
 */

public class Taster extends Komponente{
    int isPressed;

    public Taster() {
        super(0, 1);
    }

    public void press() {
        if(this.isPressed == 0) {
            this.isPressed = 1;
        }
        else if(this.isPressed == 1) {
            this.isPressed = 0;
        }
    }

    /**
     * setzt Outputs
     */
    public void calc() {
        myOutputs[0].setValue(isPressed);
    }


}
