package pl.grzesk075.sandbox.google;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {

    enum Color {
        RED,
        BLUE;
    }

    void test(){
        Map<Color,Integer> c2c = new HashMap<>();
        c2c.put(Color.RED,1);
        c2c.get(Color.BLUE);
        Color.RED.hashCode();
        Color[] c = new Color[]{Color.RED};
        Color color = Color.BLUE;
        switch (color){
            case RED:
                break;
        }
    }
}
