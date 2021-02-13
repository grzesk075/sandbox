package pl.grzesk075.sandbox.google;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiameterOfTreeLinearTest {

    private DiameterOfTreeLinear.Node root;

    @Before
    public void setUp() {
        DiameterOfTreeLinear.Node a = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node b = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node c = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node d = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node e = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node f = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node g = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node h = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node i = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node j = new DiameterOfTreeLinear.Node();
        root = a;
        a.subnodes.add(b);
        a.subnodes.add(c);
        a.subnodes.add(d);
        b.subnodes.add(e);
        b.subnodes.add(g);
        e.subnodes.add(f);
        g.subnodes.add(h);
        h.subnodes.add(i);
        f.subnodes.add(j);
    }

    @Test
    public void getDiameterTest7() {
        final DiameterOfTreeLinear DiameterOfTreeLinear = new DiameterOfTreeLinear();
        assertEquals(7, DiameterOfTreeLinear.getDiameter(root));
    }

    @Test
    public void getDiameterTest8() {
        final DiameterOfTreeLinear DiameterOfTreeLinear = new DiameterOfTreeLinear();
        DiameterOfTreeLinear.Node x = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node y = new DiameterOfTreeLinear.Node();
        DiameterOfTreeLinear.Node z = new DiameterOfTreeLinear.Node();
        x.subnodes.add(y);
        y.subnodes.add(z);
        z.subnodes.add(root);
        assertEquals(8, DiameterOfTreeLinear.getDiameter(x));
        assertEquals(7, DiameterOfTreeLinear.getDiameter(y));
        assertEquals(7, DiameterOfTreeLinear.getDiameter(z));
        DiameterOfTreeLinear.Node m = new DiameterOfTreeLinear.Node();
        x.subnodes.add(m);
        assertEquals(8, DiameterOfTreeLinear.getDiameter(x));
    }
}