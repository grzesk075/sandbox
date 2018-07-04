package pl.grzesk075.sandbox.microtasks.adv;

import pl.grzesk075.sandbox.microtasks.lib.OptimizationModule;
import pl.grzesk075.sandbox.microtasks.lib.StatisticsModule;

/**
 * Zadanie nr 1.
 * Obliczanie statystyk i optymalizacja są wykonywane synchronicznie i trwają za długo.
 * Przerobić program, by te dwa niezależne przetwarzania były asynchroniczne (wspłbieżne).
 * Zachować funkcjonalność oryginalnego programu na tyle, na ile jest to możliwe. Wskazać rónice po zmianach.
 * Czy po zmianach program będzie działać szybciej? Kiedy program zakończy działanie?
 * @author grzesk
 */
public class Test1a
{
    public static void main( String... args)
    {
        if( args.length != 2)
        {
            System.out.println( "Usage: Test1 statisticsModuleConfig optimizationModuleConfig");
            System.exit( 1);
        }
        
        try
        {
            new StatisticsModule().calculate( args[ 0]);
            new OptimizationModule().optimize( args[ 1]);
            
            System.out.println( "Processing completed.");
        }
        catch( Exception e)
        {
            System.out.println( "Processing error " + e);
        }
    }
}
