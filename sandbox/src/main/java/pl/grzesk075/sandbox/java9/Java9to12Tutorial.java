package pl.grzesk075.sandbox.java9;

/**
 * New major features in JAVA versions 9 to 12 summary.
 * Should be run on JAVA 12 or above.
 * 
 * @author Grzegorz Kuprianowicz <grzesk075@gmail.com>
 */
public class Java9to12Tutorial {
    
    public static void main(String[] args) {
        
        System.out.println("New major features in JAVA versions 9 to 12 summary.");
        
        /*
        1. Java Platform Module System (JSR 376 introduced in JAVA 9).
        Modules increase encapsulation.
        They are part of Jigsaw Project.
        Using module system is optional. You can use only packages to fulfill structured paradigm.
        To use modules in your application create module-info.java file in each module directory.
        This files contains packages list to assign packages as public API of this module for another modules.
        'module-info.java' file contains also depandencies to another modules. (This duplicates maven functionality.)
        JDK is now divided into modules e.g. 'java.base' containing package 'java.lang'
        and other base packages.
        Modules starting with 'java' are considered as public API of java.
        Modules starting with 'jdk' are considered as internal API of sdk,
        therefore should not be used (they are available on a flag so far).
        Between compile time and run time there is new phase called link phase,
        where modules are applied.
        You can use jlink tool to generate your own runtime environment only with
        necessary things. So compact profiles are obsolete now.
        Jmod format is added as similar to jar, but it can contain native code and config liles.
        Jmod tool supports jmod format.
        New URI format for modules and classes in runtime image.
        Endorsed and exrtension mechanisms are removed.
        Rt.jar and tools.jar are removed, new folder structure of jdk/sdk is introduced.
        JRE is not installed as a part of jdk/sdk.
        */
        
        /*
        2. The Java Shell (Read-Eval-Print Loop).
        REPL environment is introduced in JAVA9 as a JEP 222 implementation.
        Jshell tool stands a command line shell environment for java developers.
        */
        
        /*
        3. Extended jcmd tool able to send diagnostic commands to running HotSpot JVM.
        */
        
        /*
        4. Multi-Release JAR Files (JEP 238 in JAVA 9).
        Extends the JAR file format to enable multiple, Java release-specific versions of class files to coexist in a single archive.
        */
        
        /*
        5. Minor language changes as part of Coin Project (JAVA 9).
        Allow @SafeVargs on private instance methods.
        Allow effectively final variables to be used as resources in the try-with-resources statement.
        Allow the diamond with anonymous classes if the argument type of the inferred type is denotable.
        Complete the removal, begun in Java SE 8, of the underscore from the set of legal identifier names.
        Add support for private interface methods.
        */
        
        /*
        6. Maintanance like deprecation of Applets and JavaFX, ppgrades for Unicode 11 and HTTP 2,
        javadoc with HTML 5 and search util, improved G1 garbage collector (doesn't stop application to clean).
        */
        
        /*
        7. Convenience Factory Methods for Collections (JAVA 9 JEP 269).
        Set<String> alphabet = Set.of("a", "b", "c");
        */
        
        /*
        8. IntStream.iterate()
        */
        
        /*
        9. Optional.stream()
        */
    }
}