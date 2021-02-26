package pl.grzesk075.sandbox.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Sandbox for new features of Java 8.
 *
 * @author Grzegorz Kuprianowicz <grzesk075@gmail.com>
 * @implSpec <b>html bold markup</b>
 * @implNote {@literal Characters like '<' and '>' should be inside {@literal} to avoid HTML markup and nested
 * javadoc tag formatting issues (since 1.5).}
 * @see {@code null} {@link Object}
 */
public class Java8Tutorial
{
    public static void main( String[] args)
    {
        try
        {
            /*
            1. Lambda Expressions i wskaźniki do funkcji.
            W pakiecie java.util.function są zdefiniowane interfejsy funkcyjne (functional interface),
            pod które można podstawiać wskaźniki do funkcji lub wyrażenia lambda.
            API klas dostarczanych w dystrybucji java 8 zostało rozszerzone o metody przyjmujace jako argumenty wskaźniki do funkcji lub wyrażenia lambda,
            czyli implementacje interfejsów z java.util.function.
            Tam, gdzie argumentem jest stary interfejs zawierający jedną metodę np. w Collections.sort, nie trzeba było rozszerzać API.
            Jako argument Comparator<? super T> w Collections.sort można użyć wyrażenia lambda pasującego argumentami i wynikiem do funkcji compare z Comparator<? super T>.
            Przykładowo zamiast posługiwać się po staremu anonimową implementacją interfejsu Comparator<T>
              Collections.sort(personList, new Comparator<Person>(){
                  public int compare(Person p1, Person p2){
                      return p1.firstName.compareTo(p2.firstName);
                  }
              });
            można się posłużyć nowym API
              Collections.sort(personList, (Person p1, Person p2) -> p1.firstName.compareTo(p2.firstName));
            Nowy zapis zawiera głównie logikę biznesową bez zbędnego okładu.
            Old school notation contains boilerplate code (nadmiarowy kod wymuszony przez język). Użycie lambda skraca zapis i daje deklaratywną
            możliwość określenia co chcemy osiągnąć (w przeciwieństwie do imperatywnego starego podejścia, gdzie pokazujemy jak chcemy coś osiągnąć).
            Kompilator sam buduje ten boilerplate code i robi bardziej optymalny bytecode niż przy imperatywnej metodzie.
            W lambda można używać zmiennych z enclosing type i nie muszą one być final - wystarczy by były effective final czyli nie były modyfikowane przez lambda.
            Dodatkowo w argumentach lambdy nie można użyć nazw zmiennych z enclosing type.
            Lambda może być zastosowana jako implementacja interfejsu będącego @FunctionalInterface (adnotacja nie jest konieczna).
            Functional interface has Single Abstract Method (SAM).
            Lambda nie może być użyta jako implementacja klasy abstrakcyjnej.
            Lambda powinna być prosta i jednoliniowa, by nie trzeba było jej debugować.
            W przypadku bardziej skomplikowanych operacji należy przekazać referencję do metody, którą można już debugować.
            */
            //Function - apply
            Function<Integer,Long> tripleInt = a -> 3L * a; //Wyrażenie lambda, czyli anonimowa funkcja, którą przez wskaźnik tripleInt można przekazać jako argument do innej funkcji i w niej wywołać.
            Function<Integer,Long> doubleInt = ( Integer i) -> { return  2L * i;}; //( Integer) { return ;}  - te znaki są opcjonalne i w prostych lambda może ich nie być
            Function<Integer,Long> powInt = Java8Tutorial::pow;
            Function<Integer,Long> instancePowInt = new Java8Tutorial()::instancePow;

            BiFunction<Integer,Integer,Integer> doSum = (x, y) -> x + y;

            UnaryOperator<Integer> increment = i -> ++i;
            LongSummaryStatistics summaryStatistics = Stream.of( 1, 2, 3)
                    .map( increment)
                    .filter( i -> i < 3)
                    .map( Long::valueOf)
                    .collect( Collectors.summarizingLong( i -> i));
            System.out.println( summaryStatistics);

            //Predicate - test
            Predicate<String> isNullStr = s -> s == null;
            //Consumer - accept
            Consumer<String> printStr = s -> System.out.println( s);
            //Supplier - get
            Supplier<Double> randomValueSupplier = () -> Math.random();

            Stream.generate( randomValueSupplier).limit( 10).map( String::valueOf).forEach( printStr);
            Stream.of( "A", "B", "C").parallel().forEach( printStr);

            IntStream.range( 1, 5).flatMap( i -> IntStream.rangeClosed( 1, i)).forEach( System.out::println);

            final Function<int[],Integer> lengthOfArray = i -> i.length;  // int[] extends Object, likewise interface
            final IntFunction<Long> intToLongCustFunction = i -> (long) i;
            final long custed = intToLongCustFunction.apply(4);
            System.out.println("intToLongCustFunction: " + custed);
            
            /*
            Są 4 rodzaje wskaźników do funkcji:
            a) Reference to a static method - przykład powInt.
            b) Reference to an instance method of a particular object - przykład instancePowInt.
            c) Reference to a constructor - przykład 'Double::new' jest poniżej w strumieniu danych.
               Instancja Integer przychodząca ze strumienia danych do funkcji mapToDouble jest podstawiana do pasującego konstruktora z klasy Double.
               Wynik działania konstruktora w postaci nowej instancji Double jest wysyłany do następnej funkcji w strumieniu.
            d) Reference to an instance method of an arbitrary object of a particular type - przykład 'Long::intValue' jest poniżej w strumieniu danych.
               Do funkcji mapToInt przychodzi ze strumienia danych instancja Long. Na tej instancji jest wywoływana funkcja instancyjna intValue().
               Wynik działania funkcji w postaci Integer jest wysyłany do następnej funkcji w strumieniu danych. 
            */
            
            
            /*
            2. Strumienie danych.
            Nie są to strumienie bajtów z pakietu java.io, ale strumienie danych Stream<T> z pakietu java.util.stream.
            Są one tak zaprojektowane, by łatwo używać w nich Lambda Expressions.
            Strumienie szeregowe (przykład transformed) są jednowątkowe.
            Strumienie równoległe (przykład avg) mogą być przez maszynę wirtualną wykonywane na wielu rdzeniach wielu procesorów.
            Kolejność obiektów na wyjściu strumienia szeregowego jest taka jak na wejściu, natomiast dla strumienia równoległego może być dowolna.
            Zamiast pętli for można użyć strumienia równoległego zakończonego forEach.
            Pętla for będzie wykonywana synchronicznie przez jeden rdzeń. Przetwarzanie forEach może być wykonywane jednocześnie na wszystkich dostępnych rdzeniach i trwać krócej.
            */
            List<Integer> ints = Arrays.asList( 1, null, 1, 3, 3, 3, 4, 2);

            List<Long> transformed = ints.stream().filter( i -> i != null && i <= 3).sorted().distinct().map( doubleInt).collect( Collectors.toList());

            transformed.stream().forEach( l -> System.out.println( "Item: " + l));

            OptionalDouble avg = transformed.parallelStream().mapToInt( Long::intValue).mapToDouble( Double::new).average();
            if( avg.isPresent())
                System.out.println( "Avg: " + avg.getAsDouble());
            
            
            /*
            3. java.util.Optional<T>.
            Jest to koncepcja unikania NullPointerException zaczerpnięta z języka Scala. Ma w zamyśle uwolnić programistę od ciągłego sprawdzania, czy obiekt nie jest null, co zaciemnia kod.
            Trzeba z tego umiejętnie korzystać, bo zamiast NullPointerException jest NoSuchElementException.
            API Java 8 czasami zmusza do użycia Optional, bo zwraca je ze swych funkcji.
            Dodatkową zaletą jest oznaczanie w obiektach biznesowych pól, które mogą być nieustawione.
            Była propozycja już w Java 7, by wprowadzić jak jest w języku Groovy, safe navigation operator (null safe dereference operator) '?.', który można by było użyć zamiast operatora '.'.
            Zamiast obj.method() pisałoby się obj?.method(), co zwracałoby null zamiast NullPointerException, gdyby obj był null.
            Może doczekamy się wdrożenia tej koncepcji w Java 9, gdyby Optional się nie przyjął.
            */

            Optional<Integer> any = Stream.iterate( 1, i -> ++i).limit( 10).findAny();
                                any.filter( i -> i > 0).ifPresent( System.out::println);
                                any.flatMap( i -> Optional.of( i + 1)).map( Long::valueOf).ifPresent( i -> {});
            Integer orElseGet = any.orElseGet( () -> 0);
            Integer orElse    = any.orElse( 0);
            Integer orElseThr = any.orElseThrow( () -> new RuntimeException());
            
            /*
            4. Wbudowany silnik JavaScript o nazwie Nashorn.
            Nie spodziewam się jego użycia. Angular 2 używa silnika node.js.
            Skrypty js można wywoływać w kodzie Java przez klasę ScriptEngine lub bezpośrednio przez program jjs z jdk/bin.
            Można w skryptach używać obiektów Java oraz przekazywać do skryptów i odbierać ze skryptów obiekty Java.
            */
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine nashorn = sem.getEngineByName( "nashorn");

            String js = "var obj = { a: 2, b: 3}; var sum = obj.a + obj.b; print( 'sum=' + sum); " +
                        "function getName( name) { return 'myName is ' + name;}; " +
                        "var Integer = Java.type( 'java.lang.Integer'); function getSum() { return new Integer( sum);};";

            nashorn.eval( js);

            Object name = ( ( Invocable) nashorn).invokeFunction( "getName", "Grzegorz");
            System.out.println( name);

            Integer sum = ( Integer) ( ( Invocable) nashorn).invokeFunction( "getSum");
            System.out.println( "Sum is " + sum);
            
            
            /*
            5. Nowe API do daty i czasu.
            Klasy Date i GregorianCalendar zostały uznane za przestarzałe, ale nie oznaczono ich jako deprecated.
            Nowe API jest w pakiecie java.time.
            LocalDateTime przechowuje czas lokalny bez strefy czasowej z dokładnością do nanosekund
            od '-999999999-01-01T00:00:00' do '+999999999-12-31T23:59:59.999999999' i zgodnie z ISO-8601.
            ZonedDateTime dodatkowo obsługuje strefy czasowe w zgodzie z ISO-8601.
            Dodano klasy Period i Duration.
            */

            LocalDateTime currentTime = LocalDateTime.now();
            System.out.println("Current DateTime: " + currentTime);

            LocalDateTime currentTimeMovedTo2014 = currentTime.withYear( 2014);
            System.out.println("Current DateTime with 2014: " + currentTimeMovedTo2014);

            LocalDateTime date3 = LocalDateTime.of( 2016, Month.JANUARY, 31, 22, 10, 1);
            System.out.println("date3: " + date3);

            LocalDateTime monthLater = date3.plus(1, ChronoUnit.MONTHS); //!
            System.out.println("1 month later: " + monthLater);

            Period period = Period.between( date3.toLocalDate(), monthLater.toLocalDate()); //z dokładnością do dnia
            System.out.println("Period: " + period);

            Duration duration = Duration.between( date3, monthLater); //z dokładnością do nanosekund
            System.out.println("Duration: " + duration);

            ZoneId currentZone = ZoneId.systemDefault();
            System.out.println("CurrentZone: " + currentZone);
            
            
            /*
            6. Wbudowana obsługa Base64.
            Dotychczas używamy Base64 od apache.
            */

            String base64encodedString = Base64.getEncoder().encodeToString("Test Java 8".getBytes("utf-8"));
            System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);

            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
            
            
            /*
            7. Profile kompaktowe.
            Z zestawu wszystkich klas dystrybucji Java SE 8 wydzielono trzy podzbiory compact1, compact2 i compact3 (compact1 jest podzbiorem compact2 itd.).
            W dokumentacji javadoc jest podane do którego podzbioru należy klasa.
            Kompilator javac ma opcję -profile, która pozwala na kompilację z ograniczonym zestawem klas, celem uruchamiania programu na urządzeniach o ograniczonych zasobach. 
            */
        }
        catch( IOException | NullPointerException e) //multicatch since java7 (one can't be superclass of the other)
        {
        	e.printStackTrace( System.err);
        }
        catch( Exception e)
        {
            e.printStackTrace( System.out);
        }
    }
    
    
    /*
    8. Domyślne implementacje metod w interfejsach oraz metody statyczne w interfejsach.
    Domyślne metody można ale nie trzeba nadpisywać (override) w klasach implementujących interfejs.
    */

    public interface ObjectFactory
    {
        default public Object newInstance()
        {
            return new Object();
        }
    }
    
    
    /*
    9. Adnotacje do typów obiektów.
    Jest to zupełnie nowe zastosowanie adnotacji do typów (enum where annotations may appear - java.lang.annotation.ElementType, został rozszerzony o TYPE_USE i TYPE_PARAMETER).
    Liczne adnotacje do typów zostały dodane do pakietów org.checkerframework.checker.*.qual, które nie są częścią java 8 - należą do Checker Framework.
    Idea jest taka, by IDE jak Eclipse (rozszerzone o plugin Checker Framework) ostrzegało w trakcie kompilacji o problematycznych miejscach w kodzie,
    gdy zostało poinformowane przez adnotację, że np. obiekt nie może być null.
    Przykłady
    @NonNull String str = "abc"; //miejsca w kodzie, gdzie str mógłby uzyskać wartość null bedą wskazane w trakcie kompilacji
    List<@NonNull String> l; //na liście nie może być obiektów null
    Są też inne Checker-y, które mają swoje adnotacje NonNull np. org.eclipse.jdt.annotation.NonNull, org.netbeans.api.annotations.common.NonNull, android.annotation.NonNull, itd.
    Trzeba poczekać na okrzepniecie tej koncepcji.
    */


    public static Long pow( Integer i)
    {
        return 1L * i * i;
    }

    public Long instancePow( Integer i)
    {
        return 1L * i * i;
    }

    public static String getFirstLineOfFile( File f) {
    	//try-with-resources - opened resource, which implements AutoClosable, are closed after statement, since java7
    	try ( BufferedReader r = new BufferedReader( new InputStreamReader(new FileInputStream( f), Charset.forName( "UTF-8"))))
        {
        	return r.readLine();
        }
    	catch (Exception e)
    	{
			e.printStackTrace();
		}

		return null;
    }
}