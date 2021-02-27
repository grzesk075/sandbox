package pl.grzesk075.sandbox.java;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * New major features in JAVA versions 9 to 12 summary.
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
        'module-info.java' file contains also dependencies to another modules. (This duplicates maven functionality.)
        JDK is now divided into modules e.g. 'java.base' containing package 'java.lang'
        and other base packages.
        Modules starting with 'java' are considered as public API of java.
        Modules starting with 'jdk' are considered as internal API of sdk,
        therefore should not be used (they are available on a flag so far).
        Between compile time and run time there is new phase called link phase,
        where modules are applied.
        You can use jlink tool to generate your own runtime environment only with
        necessary things. So compact profiles are obsolete now.
        Jmod format is added as similar to jar, but it can contain native code and config files.
        Jmod tool supports jmod format.
        There is new URI format for modules and classes in runtime image.
        Endorsed and extension mechanisms are removed.
        Rt.jar and tools.jar are removed, new folder structure of jdk/sdk is introduced.
        JRE is not installed as a part of jdk/sdk.
        */

        /*
        2. The Java Shell (Read-Eval-Print Loop).
        REPL environment is introduced in JAVA9 as a JEP 222 implementation.
        Jshell tool stands a command line shell environment for java developers.
        */
        
        /*
        3. Enable in OpenJDK 11 free profiler as features: Java Flight Recorder and Java Mission Control.
        IntelliJ commercial version supports this.
        Extended jcmd tool able to send diagnostic commands to running HotSpot JVM.
        */
        
        /*
        4. Multi-Release JAR Files (JEP 238 in JAVA 9).
        Extends the JAR file format to enable multiple, Java release-specific versions of class files to coexist in a single archive.
        */
        
        /*
        5. Minor language changes as part of Coin Project (JAVA 9).
        Allow @SafeVarags on private instance methods.
        Allow effectively final variables to be used as resources in the try-with-resources statement.
        Allow the diamond with anonymous classes if the argument type of the inferred type is denotable.
        Complete the removal, begun in Java SE 8, of the underscore from the set of legal identifier names.
        Add support for private interface methods.
        */
        Card<String> myCard = new Card<>() { //diamond with anonymous classes become to be enabled

            @Override
            public String get() {
                return "my card";
            }

            @SafeVarargs
            private void display(List<String>... products) {
                for (List<String> product : products) {
                    for (String str : product)
                        System.out.println(str);
                }
                //final List<String>[] lists = new List<String>[5]; //generic array creation - compiler reported error
                final List[] lists = new List[5]; //this is created and information about type is lost
            }

            //instead of new T[] {args} compiler can do only new Object[] {args}
            //compiler warn against possible exception in runtime
            //this example is safe - iteration over array only
            @SafeVarargs
            private final <T> void foo(T... args) {
                for (T x : args) {
                    // do stuff with x
                }
            }

            //this is really unsafe operation new Object[] {args} will be returned
            private <T> T[] asArray(T... args) {
                return args;
            }

            @SafeVarargs
            private <T> List<T> flatten(List<? extends T>... lists) {
                List<T> result = new ArrayList<>();
                for (List<? extends T> list : lists) {
                    result.addAll(list);
                }
                return result;
            }

            private void heapPollutionExample(){
                List ln = new ArrayList<Number>();
                List<String> ls = ln; // heap pollution
            }
        };
        System.out.println("card vendor: " + myCard.getDescription() + ", get(): " + myCard.get() +
                ", dummieNumber: " + Card.dummieNumber);

        Closeable closable = () -> System.out.println("Closing my closable."); //one method to override
        try (closable) {
            //
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        6. Maintenance like deprecation of Applets and JavaFX, upgrades for Unicode 11 and HTTP 2,
        javadoc with HTML 5 and search util, improved G1 garbage collector (doesn't stop application to clean).
        */
        
        /*
        7. Convenience Factory Methods for Collections (JAVA 9 JEP 269).
        */
        Set<String> alphabet = Set.of("a", "b", "c");
        List immutableList = List.of();
        Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three");

        
        /*
        8. IntStream.iterate()
        */
        IntStream.iterate(0, i -> i < 10, i -> i + 2).forEach(System.out::println);

        /*
        9. Optional.stream()
        */
        List<Optional<String>> listOfOptionals = Arrays.asList(Optional.empty(), Optional.of("Foo"),
                Optional.empty(), Optional.of("Bar"));
        List<String> filteredList = listOfOptionals.stream()
                .flatMap(Optional::stream) //each optional produces stream (empty or one element), flatMap concatenates results
                .collect(Collectors.toList());

        final Stream<Object> emptyStream = Optional.empty().stream();
        final Stream<String> oneElementStream = Optional.of("elem").stream();
        Stream<String> emptyStream1 = Stream.empty();
        IntStream.range(1, 10).average().ifPresent(System.out::println);

        /*
        10. OS process API.
        Getting info and destroying subprocesses.
        */
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: = " + currentProcess.pid());

        ProcessHandle.Info procInfo = currentProcess.info();
        Optional<String[]> arguments = procInfo.arguments();
        Optional<String> cmd = procInfo.commandLine();
        Optional<Instant> startTime = procInfo.startInstant();
        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();

        /*
        11. Common tool log system. Examples under
        java -Xlog:help
        */

        /*
        12. New HTTP client.
        */
        try {
            final HttpRequest request = HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))
                    .timeout(Duration.ofSeconds(20))
                    .header("myname", "myvalue")
                    .GET()
                    .build();
            final HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(30))
                    .build();
            //synchronously
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            //asynchronously
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println);
            Thread.sleep(2000);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface Card<T> { //inner interface is static by default (every interface is also abstract)

        long dummieNumber = getDummieNumber(); // field is public static

        T get();

        default String getDescription() {  // method is public (and abstract, when not default)

            return getVendor();
        }

        private String getVendor() { //to use in default methods

            return "company";
        }

        private static long getDummieNumber() {

            return 129374623L;
        }
    }
}