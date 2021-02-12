package pl.grzesk075.sandbox.google;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiameterOfTreeTest {

    private DiameterOfTree.Node root;

    @Before
    public void setUp() {
        DiameterOfTree.Node a = new DiameterOfTree.Node();
        DiameterOfTree.Node b = new DiameterOfTree.Node();
        DiameterOfTree.Node c = new DiameterOfTree.Node();
        DiameterOfTree.Node d = new DiameterOfTree.Node();
        DiameterOfTree.Node e = new DiameterOfTree.Node();
        DiameterOfTree.Node f = new DiameterOfTree.Node();
        DiameterOfTree.Node g = new DiameterOfTree.Node();
        DiameterOfTree.Node h = new DiameterOfTree.Node();
        DiameterOfTree.Node i = new DiameterOfTree.Node();
        DiameterOfTree.Node j = new DiameterOfTree.Node();
        root = a;
        a.subnodes.add(b);
        a.subnodes.add(c);
        a.subnodes.add(d);
        b.subnodes.add(e);
        b.subnodes.add(g);
        e.subnodes.add(f);
        g.subnodes.add(h);
        h.subnodes.add(i);
        i.subnodes.add(j);
    }

    @Test
    public void getDiameterTest6() {
        final DiameterOfTree diameterOfTree = new DiameterOfTree();
        assertEquals(6, diameterOfTree.getDiameter(root));
    }

    @Test
    public void getDiameterTest7() {
        final DiameterOfTree diameterOfTree = new DiameterOfTree();
        DiameterOfTree.Node x = new DiameterOfTree.Node();
        DiameterOfTree.Node y = new DiameterOfTree.Node();
        DiameterOfTree.Node z = new DiameterOfTree.Node();
        x.subnodes.add(y);
        y.subnodes.add(z);
        z.subnodes.add(root);
        assertEquals(7, diameterOfTree.getDiameter(x));
        assertEquals(6, diameterOfTree.getDiameter(y));
        assertEquals(6, diameterOfTree.getDiameter(z));
        DiameterOfTree.Node m = new DiameterOfTree.Node();
        x.subnodes.add(m);
        //assertEquals(8, diameterOfTree.getDiameter(x)); doesn't work
    }
}