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
        Java classes are placed compiled to native machine code in classes.jsa instead of rt.jar with bytecode.
        Java Shared Archive has native machine code copied directly to memory instead of classloading and
        Just In Time Compiling.
        Loading from jsa file is faster and memory footprint is lower.
        Multiple JVM shares loaded classes.
        Bytecode in class files is still in jmod files.

        Using Dynamic Class Data Sharing, you can dump your classes to jsa file and use later with the same benefits.
        java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
        java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello
        */

        /*
        2. JEP 351: ZGC: Uncommit Unused Memory
        Garbage collectors as G1 can return unused heap to operating system (e.g. to avoid pay for non-needed resources in cloud).
        The Z Garbage Collector also can do so.
        */

        /*
        3. JEP 354: Switch Expressions (Preview)
        Uncomment and use java 13 in src\main\java folder:
        javac --enable-preview --release 13 pl\grzesk075\sandbox\java\Java13Tutorial.java
        java --enable-preview pl.grzesk075.sandbox.java.Java13Tutorial
        */
/*
        final int month = 4;
        String season = switch(month){
            case 3, 4, 5    -> "spring";
            case 6, 7, 8    -> "summer";
            case 9, 10, 11  -> "autumn";
            case 12, 1, 2   -> "winter";
            default -> throw new IllegalArgumentException("month can be from 1 to 12");
        };
        System.out.println("Season is " + season);
        season = switch(month){
            case 3:
            case 4:
            case 5:
                yield "spring";
            case 6, 7, 8:
                yield "summer";
            case 9:
            case 10:
            case 11:
                yield "autumn";
            case 12:
            case 1:
            case 2:
                yield "winter";
            default:
                throw new IllegalArgumentException("month can be from 1 to 12");
        };
        System.out.println("Season is " + season);
*/
    }
}