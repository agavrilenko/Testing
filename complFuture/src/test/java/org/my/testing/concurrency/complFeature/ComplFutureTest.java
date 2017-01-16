package org.my.testing.concurrency.complFeature;

import javafx.beans.Observable;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 * Created by trash on 06-Sep-16.
 */
public class ComplFutureTest {

    @Test
    public void test() throws Exception {
        CompletableFuture data = CompletableFuture.supplyAsync(()
                -> {
            return new AtomicInteger(10);
        })
                .thenApply(count -> {
                    int transformedValue = count.accumulateAndGet(25, (x, y) -> x * y);
                    return transformedValue;
                }).thenApply(transformed -> "data-" + transformed);

        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsync() throws InterruptedException {
        long time = System.currentTimeMillis();
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.print("Hello async before");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Hello async after");
        });
        System.out.println(System.currentTimeMillis() - time);
        Thread.sleep(1001);
        System.out.println(System.currentTimeMillis() - time);
        Assert.assertTrue(future.isDone());
        System.out.println(System.currentTimeMillis() - time);
    }

    @Test
    public void testSupply() throws ExecutionException, InterruptedException {
        long time = System.currentTimeMillis();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Before sleep " + (System.currentTimeMillis() - time));
                Thread.sleep(1000);
                System.out.println("After sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hi";
        });
        System.out.println("Before get " + (System.currentTimeMillis() - time));
        Assert.assertEquals("hi", future.get());
        System.out.println("After get " + (System.currentTimeMillis() - time));
    }

    @Test
    public void test_then_run_async() throws Exception {
        Map<String, String> cache = new HashMap<>();
        cache.put("key", "value");
        CompletableFuture<String> taskUsingCache = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cache.get("key");
        });
        CompletableFuture<Void> cleanUp = taskUsingCache.thenRunAsync(cache::clear);
        cleanUp.get();
        String theValue = taskUsingCache.get();
        Assert.assertTrue(cache.isEmpty());
        Assert.assertEquals(theValue, "value");
    }

    @Test
    public void test_accept_result() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<String> results = new ArrayList<>();
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> "add when done", service);

        CompletableFuture<Void> acceptingTask = task.thenAccept(results::add);
        Thread.sleep(2000);
        Assert.assertTrue(acceptingTask.isDone());
        Assert.assertEquals(results.size(), 1);
        Assert.assertTrue(results.contains("add when done"));

    }

    @Test
    public void test_then_compose() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Function<Long, Supplier<List<Long>>> getFirstTenMultiples = num ->
                () -> Stream.iterate(num, i -> i + num).limit(10).collect(Collectors.toList());

        Supplier<List<Long>> multiplesSupplier = getFirstTenMultiples.apply(13L);

        //Original CompletionStage
        CompletableFuture<List<Long>> getMultiples = CompletableFuture.supplyAsync(multiplesSupplier, service);

        //Function that takes input from orignal CompletionStage
        Function<List<Long>, CompletableFuture<Long>> sumNumbers = multiples ->
                CompletableFuture.supplyAsync(() -> multiples.stream().mapToLong(Long::longValue).sum());

        //The final CompletableFuture composed of previous two.
        CompletableFuture<Long> summedMultiples = getMultiples.thenComposeAsync(sumNumbers, service);

        Assert.assertEquals(summedMultiples.get().intValue(), 715);
    }

    @Test
    public void test_then_combine_async() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> "combine all", service);

        CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(() -> "task results", service);

        CompletableFuture<String> combined = firstTask.thenCombineAsync(secondTask, (f, s) -> f + " " + s, service);

        Assert.assertEquals(combined.get(), "combine all task results");
    }

    @Test
    public void test_then_combine_with_one_supplied_value() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<String> asyncComputedValue = CompletableFuture.supplyAsync(() -> "calculated value", service);
        CompletableFuture<String> knowValueToCombine = CompletableFuture.completedFuture("known value");

        BinaryOperator<String> calcResults = (f, s) -> "taking a " + f + " then adding a " + s;
        CompletableFuture<String> combined = asyncComputedValue.thenCombine(knowValueToCombine, calcResults);

        Assert.assertEquals(combined.get(), "taking a calculated value then adding a known value");
    }


    @Test
    public void test_accept_either_async_nested_finishes_first() throws Exception {

        CompletableFuture<String> callingCompletable = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "calling";
        });
        CompletableFuture<String> nestedCompletable = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "nested";
        });

        List<String> results = new ArrayList<>();
        CompletableFuture<Void> collector = callingCompletable.acceptEither(nestedCompletable, results::add);

        TimeUnit.SECONDS.sleep(2);
        Assert.assertTrue(collector.isDone());
        Assert.assertEquals(results.size(), 1);
        Assert.assertTrue(results.contains("nested"));
    }

    @Test

    public void test_several_stage_combinations() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Function<String, CompletableFuture<String>> upperCaseFunction = s -> CompletableFuture.completedFuture(s.toUpperCase());

        CompletableFuture<String> stage1 = CompletableFuture.completedFuture("the quick ");

        CompletableFuture<String> stage2 = CompletableFuture.completedFuture("brown fox ");

        CompletableFuture<String> stage3 = stage1.thenCombine(stage2, (s1, s2) -> s1 + s2);

        CompletableFuture<String> stage4 = stage3.thenCompose(upperCaseFunction);

        CompletableFuture<String> stage5 = CompletableFuture.supplyAsync(simulatedTask(2, "jumped over"));

        CompletableFuture<String> stage6 = stage4.thenCombineAsync(stage5, (s1, s2) -> s1 + s2, service);

        CompletableFuture<String> stage6_sub_1_slow = CompletableFuture.supplyAsync(simulatedTask(4, "fell into"));

        CompletableFuture<String> stage7 = stage6.applyToEitherAsync(stage6_sub_1_slow, String::toUpperCase, service);

        CompletableFuture<String> stage8 = CompletableFuture.supplyAsync(simulatedTask(3, " the lazy dog"), service);

        CompletableFuture<String> finalStage = stage7.thenCombineAsync(stage8, (s1, s2) -> s1 + s2, service);

        Assert.assertEquals(finalStage.get(), "THE QUICK BROWN FOX JUMPED OVER the lazy dog");

    }

    private Supplier<String> simulatedTask(int i, String s) {
        return new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return s;
            }
        };
    }
}
