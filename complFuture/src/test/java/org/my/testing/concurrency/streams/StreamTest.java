package org.my.testing.concurrency.streams;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by trash on 13-Sep-16.
 */
public class StreamTest {

    public static final Person PAMELA = new Person("Pamela", 23);

    @Test
    public void testStream() {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        String prefix = "c";
        List<String> strings = myList
                .stream()
                .filter(s ->
                        s.startsWith(prefix)
                )
                .map(String::toUpperCase)
                .sorted().collect(Collectors.toList());

        Assert.assertEquals("C1", strings.remove(0));
        Assert.assertEquals("C2", strings.remove(0));
    }

    @Test
    public void testFindFirst() {

        List<String> results = new ArrayList<>();
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .sorted((a, b) ->
                        a.compareTo(b)
                )
                .findFirst()
                .ifPresent(results::add);

        Assert.assertEquals("a1", results.get(0));
    }

    @Test
    public void testWithMap() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

    }

    @Test
    public void testWithMapAndFilter() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void testWithFilterMap() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void testCollectorAndFilter() {

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        Assert.assertEquals("Peter", filtered.remove(0).name);
        Assert.assertEquals("Pamela", filtered.remove(0).name);
    }

    @Test
    public void testGroupping() {


        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    }

    @Test
    public void testCustomCollector() {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }

    @Test
    public void testFlatMap() {
        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

    @Test
    public void testInlineFooToBar() {
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

    @Test

    public void testFlatMap1() {

        List<String> list = Stream.of("he;ll;o", "H;el;lo;1", "y;o;yo").collect(Collectors.toList());
        StringBuilder fin = new StringBuilder("");
        Stream<String> stream = list.stream()
                .flatMap(s -> Arrays.asList(s.split(";")).stream());
        stream
                .filter(s -> s.toLowerCase().contains("l"))
                .forEach((s) -> {
                    fin.append(s);
                });
        Assert.assertEquals("llello", fin.toString());
    }

    @Test
    public void testOptional() {


        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

    }

    @Test
    public void testReduce() {
        Person person = persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .get();

        Assert.assertEquals(PAMELA, person);
    }

    @Test
    public void testReduceWithAccumulator() {
        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        });

        System.out.format("name=%s; age=%s", result.name, result.age);
// name=MaxPeterPamelaDavid; age=76
    }

    @Test
    public void testAnotherAccumulater() {
        Integer ageSum = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s; person age = %s\n", sum, p, p.age);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        System.out.println(commonPool.getParallelism());
        Assert.assertEquals(86, ageSum.intValue());
// accumulator: sum=0; person=Max
// accumulator: sum=18; person=Peter
// accumulator: sum=41; person=Pamela
// accumulator: sum=64; person=David

    }

    @Test
    public void testParallelStream() {

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));
    }

    @Test
    public void testMapPersonFromString() {
        List<String> list = Arrays.<String>asList("One", "Two", "Three");
        AtomicInteger age = new AtomicInteger(10);
        list.parallelStream().
                map(s -> {
                    Person person = new Person(s, age.incrementAndGet());
                    System.out.println(person + "->" + Thread.currentThread().getName());
                    return person;
                })
                .sorted((a, b) -> a.age == b.age ? 0 : a.age > b.age ? 1 : -1)
                .filter(a -> a.age > 11)
                .flatMap(a -> {
                    List<String> newList = new ArrayList<String>();
                    for (int i = 0; i < a.name.length(); i++) {
                        newList.add(String.valueOf(a.name.charAt(i)));
                    }
                    return newList.stream();
                }).forEach(a -> {
            Function<Integer, Supplier<String>> func = new Function<Integer, Supplier<String>>() {
                @Override
                public Supplier<String> apply(Integer integer) {
                    return new Supplier<String>() {

                        @Override
                        public String get() {
                            return integer.toString();
                        }
                    };
                }
            };
            Supplier<String> supplier = func.apply(100);
            CompletableFuture<String> future = CompletableFuture.supplyAsync(supplier);
            try {
                System.out.println(future.get());
                System.out.println(a.charAt(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return new EqualsBuilder()
                    .append(age, person.age)
                    .append(name, person.name)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(name)
                    .append(age)
                    .toHashCode();
        }
    }


    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    static class Outer {
        Nested nested;
    }

    static class Nested {
        Inner inner;
    }

    static class Inner {
        String foo;
    }

    List<Foo> foos = new ArrayList<>();

    // create foos
    @Before
    public void initFoos() {
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

// create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
    }

    List<Person> persons =
            Arrays.asList(
                    new Person("Max", 18),
                    new Person("Maxx", 10),
                    new Person("Peter", 23),
                    PAMELA,
                    new Person("David", 12));

}
