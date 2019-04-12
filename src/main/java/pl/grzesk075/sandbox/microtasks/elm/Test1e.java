package pl.grzesk075.sandbox.microtasks.elm;

import java.util.Arrays;

/**
 * Zadanie nr 1.
 * Co robi ta funkcja? Dostosować kod do dokumentacji. Zaproponować testowe wywołania funkcji.
 * @author grzesk
 */
public abstract class Test1e
{
    /**
     * Oblicza średnią arytmetyczną.
     * @param args argumenty całkowite
     * @return średnia arytmetyczna argumentów
     */
    public static int calculateSum( int... args)
    {
        if( args == null || args.length == 0)
            throw new IllegalArgumentException( "Exception in Test1.calculateSum - arguments are required.");
        
        if( args.length % 2 == 0)
            throw new IllegalArgumentException( "Number of arguments must be odd.");
        
        Arrays.sort( args);
        
        int centralIndex = ( args.length - 1) / 2;
        
        int mediana = args[ centralIndex];
        
        return mediana;
    }
}
