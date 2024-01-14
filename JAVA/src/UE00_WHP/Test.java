//package UE00_WHP;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @author Sofia Angerer
// */
//
//class Tests {
//
//    @Test
//    public void doFlipFlop(){
//        Taster t1 = new Taster();
//        Taster t2 = new Taster();
//        LED led1 = new LED();
//        LED led2 = new LED();
//        FlipFlop flip = new FlipFlop();
//
//        List<Komponente> alle = List.of(t1, t2, flip, led1, led2);
//
//        flip.connect(t1, 0, 0);
//        flip.connect(t2, 1, 0);
//        led1.connect(flip, 0, 0);
//        led2.connect(flip, 0, 1);
//
//        t1.press();
//        update(alle);
//        update(alle);
//        update(alle);
//        assertEquals(1, led1.isOn);
//        t2.press();
//        assertEquals(1, led1.isOn);
//        update(alle);
//        t1.press();
//        assertEquals(0, led1.isOn);
//        update(alle);
//        update(alle);
//        assertEquals(0, led1.isOn);
//    }
//
//    @Test
//    public void doAnd(){
//        Taster t1 = new Taster();
//        Taster t2 = new Taster();
//        LED led1 = new LED();
//        AND flip = new AND();
//
//        List<Komponente> alle = List.of(t1, t2, flip, led1);
//
//        flip.connect(t1, 0, 0);
//        flip.connect(t2, 1, 0);
//        led1.connect(flip, 0, 0);
//
//        t1.press();
//        update(alle);
//        update(alle);
//        update(alle);
//        assertEquals(0, led1.isOn);
//        t2.press();
//        update(alle);
//        update(alle);
//        update(alle);
//        assertEquals(1, led1.isOn);
//        t1.press();
//        update(alle);
//        update(alle);
//        update(alle);
//        assertEquals(0, led1.isOn);
//
//    }
//
//    private void update(List<Komponente> alle) {
//        for (Komponente c : alle) {
//            c.phase1();
//        }
//        for (Komponente c2 : alle) {
//            c2.calc();
//        }
//    }
//}