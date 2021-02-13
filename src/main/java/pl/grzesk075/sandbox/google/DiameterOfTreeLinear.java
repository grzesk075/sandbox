package pl.grzesk075.sandbox.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Find diameter of a tree.
 *
 * Linear.
 */
public class DiameterOfTreeLinear {

    public static class Node {
        List<Node> subnodes = new LinkedList<>();
    }

    public int getDiameter(Node n) {
        Diameter d = new Diameter();
        getHeight(n, d);
        return d.d;
    }

    private int getHeight(Node n, Diameter d) {
        if (n == null) {
            return 0;
        }
        int subd = 0;
        int secondd = 0;
        for (Node sub : n.subnodes) {
            int h = getHeight(sub, d);
            if (h >= subd)
                secondd = subd;
            subd = Math.max(subd, h);
            d.d = Math.max(d.d, subd + secondd + 1);
        }
        return subd + 1;
    }

    static class Diameter {
        int d = 0;
    }
}
