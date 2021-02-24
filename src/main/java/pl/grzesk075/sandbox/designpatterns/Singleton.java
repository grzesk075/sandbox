package pl.grzesk075.sandbox.designpatterns;

public class Singleton {

    private static final Object MONITOR = new Object();

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (MONITOR) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
