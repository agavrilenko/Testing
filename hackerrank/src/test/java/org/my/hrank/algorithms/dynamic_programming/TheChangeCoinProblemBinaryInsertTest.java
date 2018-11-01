package org.my.hrank.algorithms.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TheChangeCoinProblemBinaryInsertTest {

    @Test
    public void testInsert() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L));
        ArrayList<Long> expected = TheChangeCoinProblemSolution.binaryInsert(list, 4);
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L, 4L, 5L), expected);
    }

    @Test
    public void testInsert_3() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 2);
        Assert.assertEquals(Arrays.asList(1L, 2L, 2L, 3L, 5L), longs);
    }

    @Test
    public void testInsert_4() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 6);
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L, 5L, 6L), longs);
    }

    @Test
    public void testInsert_5() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 0);
        Assert.assertEquals(Arrays.asList(0L, 1L, 2L, 3L, 5L), longs);
    }

    @Test
    public void testInsert_6() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 1);
        Assert.assertEquals(Arrays.asList(1L, 1L, 2L, 3L, 5L), longs);
    }

    @Test
    public void testInsert_7() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 2);
        Assert.assertEquals(Arrays.asList(1L, 2L, 2L, 2L, 3L, 5L), longs);
    }

    @Test
    public void testInsert_8() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 2L, 3L, 5L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 5);
        Assert.assertEquals(Arrays.asList(1L, 2L, 2L, 3L, 5L, 5L), longs);
    }

    @Test
    public void testInsert_1() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 3);
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), longs);
    }

    @Test
    public void testInsert_2() {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L));
        ArrayList<Long> longs = TheChangeCoinProblemSolution.binaryInsert(list, 2);
        Assert.assertEquals(Arrays.asList(1L, 2L), longs);
    }

}