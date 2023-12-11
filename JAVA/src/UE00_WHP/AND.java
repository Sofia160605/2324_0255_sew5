package UE00_WHP;

/**
 * @author Sofia Angerer
 */

public class AND extends Komponente{

    State state = State.STATE_0;


    public AND() {
        super(2, 2);
    }

    enum State {

        STATE_1 {
            public State handleEntry(int inputR, int inputS) {
                if(inputR == 1 && inputS == 1) {
                    return STATE_1;
                }
                return STATE_0;
            }
        },

        STATE_0 {
            public State handleEntry(int inputR, int inputS) {
                if(inputR != 1 || inputS != 1) {
                    return STATE_0;
                }
                return STATE_1;
            }
        };

        /**
         * errechnet den current state
         * @param inputR
         * @param inputS
         * @return
         */
        public abstract State handleEntry(int inputR, int inputS);
    }

    /**
     * setzt die Outputs
     */
    public void calc() {
        this.state = this.state.handleEntry(this.valueInputs[0], this.valueInputs[1]);
        if(this.state == State.STATE_0) {
            this.myOutputs[0].setValue(0);
            this.myOutputs[1].setValue(1);
        }
        else {
            this.myOutputs[0].setValue(1);
            this.myOutputs[1].setValue(0);
        }
    }
}
