package pl.grzesk075.sandbox.sii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        
        final List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        list.stream().forEach(s -> { 
            if (s.equals("B")) {
                
                list.remove(s);  // NullPointerException ?
            }
        });

    }

}
