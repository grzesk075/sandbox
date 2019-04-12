package pl.grzesk075.sandbox.microtasks;

import java.util.Arrays;
import java.util.List;

import pl.grzesk075.sandbox.microtasks.elm.Test1e;
import pl.grzesk075.sandbox.microtasks.elm.Test2e;

/**
 * Mikrozadania do weryfikacji umiejętności programistów i kandydatów na programistów.
 * @author grzesk
 */
public class Main
{
    public static void main( String[] args)
    {
        try
        {
            System.out.println( "Test1e.calculateSum( 4, 7, 5)=" + Test1e.calculateSum( 4, 7, 5)); //5
            System.out.println( "Expected exception");
            System.out.println( "Test1e.calculateSum( 4, 7)=" + Test1e.calculateSum( 4, 7)); //Exception
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
        	Thread.sleep( 20L);
        	System.out.println( "Expected exception");
            Test2e test2 = new Test2e();
            System.out.println( test2.calculateSum( new Test2e.ArgumentsProvider()
            {
                @Override
                public List<Integer> getIntArgs()
                {
                    return Arrays.asList( 1, 2, null); //Exception
                }
            }));
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
    }
}
