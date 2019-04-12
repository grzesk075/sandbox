package pl.grzesk075.sandbox.microtasks.elm;

import java.util.List;

/**
 * Zadanie nr 2.
 * Z funkcji jest rzucany czasami NullPointerException. Poprawić funkcję, by nie było to możliwe.
 * Zaproponować testowe wywołania funkcji.
 * @author grzesk
 */
public class Test2e
{
    public interface ArgumentsProvider
    {
        public List<Integer> getIntArgs();
    }
    
    /**
     * @param p obiekt udostępniający listę argumentów klasy Integer
     * @return suma argumentów całkowitych, zero w przypadku ich braku
     */
    public int calculateSum( ArgumentsProvider p)
    {
        int sum = 0;
        
        List<Integer> intArgs = p.getIntArgs();
        
        for( Integer i : intArgs)
            sum += i;
        
        return sum;
    }
}
