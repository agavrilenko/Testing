package org.my.testing.concurrency.complFeature;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class CompleFutureParalledCalcsTest {
    private static int size = 500000000;

    @Test
    public void completable_addition_of_numbers() {

        int n = Runtime.getRuntime().availableProcessors();
        System.out.println("number of cores " + n);
        int[] arr = new int[size];
        ExecutorService servise = Executors.newFixedThreadPool(n);
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        int portion = size / n;
        int lo = 0, hi = 0;
        BigDecimal expected = new BigDecimal(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            expected.add(new BigDecimal(arr[i]));
        }
        long cycleAdd = System.currentTimeMillis() - start;
        System.out.println("Cycle adding " + cycleAdd);
        start = System.currentTimeMillis();
        CompletableFuture<BigDecimal>[] futures = new CompletableFuture[n];
        for (int i = 0; i < n; i++) {
            lo = hi;
            hi = lo + portion;
            if (i + 1 == n) {
                hi = size;
            }
//            CompletableFuture<BigDecimal> future = CompletableFuture.supplyAsync(new CalculateSumOfSubarray(arr, hi, lo), servise)
//                    .exceptionally(throwable -> BigDecimal.ZERO);
            CompletableFuture<BigDecimal> future = get(lo, hi, arr, servise)
                    .exceptionally(throwable -> BigDecimal.ZERO);
            futures[i] = future;
        }
        BigDecimal sum = Arrays.stream(futures).map(CompletableFuture::join).reduce(BigDecimal::add).get();
//        CompletableFuture<Void> completed = CompletableFuture.allOf(futures);
//        completed.thenApply(v -> Arrays.stream(futures).map(future -> future.join()).collect(Collectors.toList()));


        long threadAdd = System.currentTimeMillis() - start;
        System.out.println("Thread adding " + threadAdd);
        Assert.assertTrue(threadAdd < cycleAdd);
        Assert.assertEquals(expected.toString(), sum.toString());


    }

    public static class CalculateSumOfSubarray implements Supplier<BigDecimal> {

        private int[] arr;
        int hi, lo;

        public CalculateSumOfSubarray(int[] arr, int hi, int lo) {
            this.arr = arr;
            this.hi = hi;
            this.lo = lo;
        }

        @Override
        public BigDecimal get() {
            BigDecimal sum = new BigDecimal(0);
            for (int i = lo; i < hi; i++) {
                sum.add(new BigDecimal(arr[i]));
            }
            return sum;
        }
    }

    public CompletableFuture<BigDecimal> get(int lo, int hi, int[] arr, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            BigDecimal sum = new BigDecimal(0);
            for (int i = lo; i < hi; i++) {
                sum.add(new BigDecimal(arr[i]));
            }
            return sum;
        }, service).exceptionally((ex) -> BigDecimal.ZERO);
    }

    @Test
    public void runnable_addition_of_numbers() throws InterruptedException {

        int n = Runtime.getRuntime().availableProcessors();
        System.out.println("number of cores " + n);
        int[] arr = new int[size];
        CountDownLatch latch = new CountDownLatch(n);
        ExecutorService servise = Executors.newFixedThreadPool(n);
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        int portion = size / n;
        int lo = 0, hi = 0;
        AtomicLong sum = new AtomicLong(0);
        BigDecimal expected = new BigDecimal(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            expected.add(new BigDecimal(arr[i]));
        }
        long cycleAdd = System.currentTimeMillis() - start;
        System.out.println("Cycle adding " + cycleAdd);
        BigDecimal[] portions = new BigDecimal[n];
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            lo = hi;
            hi = lo + portion;
            if (i + 1 == n) {
                hi = size;
            }
            Summator summator = new Summator(arr, lo, hi, latch, i, portions);
            servise.execute(summator);
        }
        latch.await();
        BigDecimal fin = new BigDecimal(0);
        for (int i = 0; i < portions.length; i++) {
            fin.add(portions[i]);
        }
        long threadAdd = System.currentTimeMillis() - start;
        System.out.println("Thread adding " + threadAdd);
        Assert.assertTrue(threadAdd < cycleAdd);
        Assert.assertEquals(expected.toString(), sum.toString());
    }

    private static class Summator implements Runnable {
        private int[] arr;
        int hi, lo, i;
        CountDownLatch latch;
        BigDecimal[] portions;

        public Summator(int[] arr, int lo, int hi, CountDownLatch latch, int i, BigDecimal[] portions) {
            this.arr = arr;
            this.hi = hi;
            this.lo = lo;
            this.latch = latch;
            this.i = i;
            this.portions = portions;
        }

        @Override
        public void run() {
//                Thread.sleep(1000);
            BigDecimal sum = new BigDecimal(0);
            for (int i = lo; i < hi; i++) {
                sum.add(new BigDecimal(arr[i]));
            }
//                System.out.println(sum);
            portions[i] = sum;
            latch.countDown();
        }
    }
}
