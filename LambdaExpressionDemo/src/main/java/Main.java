import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Adam", 19, Person.Sex.MALE),
                new Person("Krzysztof", 23, Person.Sex.MALE),
                new Person("Nela", 58, Person.Sex.FEMALE),
                new Person("Zbigniew", 47, Person.Sex.MALE),
                new Person("Izabela", 24, Person.Sex.FEMALE),
                new Person("Jozef", 77, Person.Sex.MALE)
        ));

        System.out.println("Usage of an anonymous class:");
        // Usage of an anonymous class that implements a custom interface - bulky
        printPersonsCI(persons, new Check<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <=25;
            }
        });

        System.out.printf("%nUsage of Lambda Expression:%n");
        // Usage of Lambda Expression that is more concise.
        // However:
        //   * requires Functional Interface with only one abstract method
        //   * can omit the name of that method when you implement it.
        printPersonsCI(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);

        System.out.printf("%nUsage of  Lambda expression with a Predicate<T> from JDK:%n");
        // Usage of  Lambda expression with a Predicate<T> from JDK
        printPersonsCI(persons, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);

        System.out.printf("%nUsage of Lambda expression to define Predicate<T> and Consumer<T> from JDK:%n");
        // Usage of Lambda expression to define Predicate<T> and Consumer<T> from JDK
        // Class name Person cam be omitted in (Perons p) -> ...
        // p -> System.out.println(p)) can be replaced with method reference `System.out::println`
        printPersonsSPSC(persons,
                p -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25,
                p -> System.out.println(p));   // being kept for demo

        System.out.printf("%nMapped to names:%n");
        // Additional mapper Function<T, R>
        // p -> System.out.println(p)) changed to method reference
        // mapper p -> p.getName() changed to method reference
        processPersonsWithFunction(persons,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getName,
                System.out::println);

        System.out.printf("%nUsage of Generics:%n");
        // Usage of Generics
        processPersonsGenerics(persons,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getName,
                System.out::println);


        System.out.printf("%nUsage of Stream<E>:%n");
        // Usage of the Stream
        // Extra interfaces, classes, methods are not even required!
        persons.stream()
                .filter(p -> p.getAge() >= 18 &&
                        p.getAge() <= 25 &&
                        p.getGender() == Person.Sex.MALE)
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.printf("%nUsage of Stream<E> without mapping:%n");
        persons.stream()
            .filter(p -> p.getAge() >= 18 &&
                p.getAge() <= 25 &&
                p.getGender() == Person.Sex.MALE)
            .forEach(System.out::println);
    }


    // Usage of a custom interface
    public static void printPersonsCI(List<Person> itsList, Check<Person> checker) {
        for (Person p: itsList) {
            if (checker.test(p)) {
                System.out.println(p);
            }
        }
    }

    // Usage of the Predicate<T> interface from JDK
    public static void printPersonsSP(List<Person> itsList, Predicate<Person> predicate) {
        for (Person p: itsList) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    // Usage of the Predicate<T> interface and Consumer<T> from JDK.
    // Predicte<T> declare test(T t) and Consumer<T> declare accept(T t)
    public static void printPersonsSPSC(List<Person> roster,
                                        Predicate<Person> predicate,
                                        Consumer<Person> consumer) {
        for (Person p: roster) {
            if (predicate.test(p)) consumer.accept(p);
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(mapper.apply(p));
            }
        }
    }

    // Usage of Generics streams
    public static <E,R> void processPersonsGenerics(
            Iterable<? extends E> roster,
            Predicate<? super E> tester,
            Function<? super E, ? extends R> mapper,
            Consumer<? super R> invoker) {
        StreamSupport
                .stream(roster.spliterator(), false)
                .filter(tester)
                .map(mapper)
                .forEach(System.out::println);
    }
}
