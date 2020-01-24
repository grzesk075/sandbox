package pl.grzesk075.sandbox.java;

/**
 * New features in JAVA 13.
 */
public class Java13Tutorial {

    public static void main(String[] args) {

        System.out.println("New features in JAVA 13.");

        /*
        1. JEP 350: Dynamic CDS Archives
        Static Class Data Sharing is still available.
        Java system classes are placed in classes.jsa instead of rt.jar.
        Loading from jsa file is faster and memory footprint is lower.
        Jsa file has closer format to metaspace structure in java heap, where classes definitions are stored.
        Multiple JVM shares loaded classes.

        Using Dynamic Class Data Sharing, you can dump your classes to jsa file and use later with the same benefits.
        java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
        java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello
        */
    }
}