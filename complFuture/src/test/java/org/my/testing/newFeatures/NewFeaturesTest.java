package org.my.testing.newFeatures;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by trash on 19-Sep-16.
 */
public class NewFeaturesTest {

    @Test
    public void testPredicates() {

        Predicate<String> predicate = (s) -> "foo".equals(s);

        Assert.assertTrue(predicate.test("foo"));              // true
        Assert.assertFalse(predicate.negate().test("foo"));     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        Assert.assertFalse(isEmpty.test("fooooo"));
    }

    @Test
    public void testFunctions() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");

    }

    @Test
    public void testMapFeatures() {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        for (int i = 0; i < 10; i++) {
            map.compute(i, (key, value) -> value + key);

        }

        System.out.println(map);


    }

    @Test
    public void testFileSystemTree(){

//        create filesystem reader
//                print files
        List<Integer> integers = IntStream.range(1, 10).parallel().map(number -> number * 2).boxed().collect(Collectors.toList());
        integers.stream().forEach((each)-> System.out.println(each));
        //test stream and parallel stream for finding the same results
    }

    @Test
    public void testParallelReduce(){
        //List<Long> list , listSeq, listPar;
        long[] list =  LongStream.range(1,100000).toArray();


        StopWatch stopWatch = new StopWatch();
        stopWatch= new StopWatch();
        stopWatch.start();

        //System.out.println(list.parallelStream().reduce(0L, (first, second)-> first + second));
        stopWatch.stop();
        System.out.println("Parallel execution: " + stopWatch);
        stopWatch= new StopWatch();
        stopWatch.start();
        //System.out.println(list.stream().reduce(0L, (first, second)-> first + second));
        stopWatch.stop();
        System.out.println("Sequential execution: " + stopWatch);


    }

    @Test
    public void testSortingWithStreams(){
        List<Integer> list , listSeq, listPar;
       list =  IntStream.range(1,1000000).mapToObj(Integer::new).collect(Collectors.toList());

        listSeq = IntStream.range(1000000,1).mapToObj(Integer::new).collect(Collectors.toList());
        listPar = IntStream.range(1000000,1).mapToObj(Integer::new).collect(Collectors.toList());
        StopWatch stopWatch = new StopWatch();
        stopWatch= new StopWatch();
        stopWatch.start();
        listPar.parallelStream().sorted().collect(Collectors.toList());
        stopWatch.stop();
        System.out.println("Parallel execution: " + stopWatch);
        stopWatch= new StopWatch();
        stopWatch.start();
        listSeq.stream().sorted().collect(Collectors.toList());
        stopWatch.stop();
        System.out.println("Sequential execution: " + stopWatch);

    }


}
