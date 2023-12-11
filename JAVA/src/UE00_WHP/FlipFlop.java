package UE00_WHP;

/**
 * @author Sofia Angerer
 */

public class FlipFlop extends Komponente{

    State state = State.STATE_0;

    //2, 2
    public FlipFlop() {
        super(2, 2);
    }

    enum State {

        STATE_0 {
            @Override
            public State handleEntry(int inputR, int inputS) {
                if(inputR == 1 && inputS == 0) {
                    return STATE_1;
                }
                return STATE_0;
            }
        },

        STATE_1 {
            @Override
            public State handleEntry(int inputR, int inputS) {
                if(inputR == 0 && inputS == 1) {
                    return STATE_1;
                }
                return STATE_0;
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
     * setzt Outputs
     */
    public void calc() {
        this.state = this.state.handleEntry(this.valueInputs[0], this.valueInputs[1]);
        if(this.state == State.STATE_0) {
            this.myOutputs[0].setValue(0);
            this.myOutputs[1].setValue(1);
        }
        else{
            this.myOutputs[0].setValue(1);
            this.myOutputs[1].setValue(0);
        }
    }
}
