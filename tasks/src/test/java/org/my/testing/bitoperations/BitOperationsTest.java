package org.my.testing.bitoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trash on 14-Mar-17.
 */
public class BitOperationsTest {
    @Test
    public void testLastBitExtractionEven() {
        int x = 10;
        int lastBit = x & 1;
        Assert.assertEquals(0, lastBit);
    }

    @Test
    public void testLastBitExtractionOdd() {
        int x = 13;
        int lastBit = x & 1;
        Assert.assertEquals(1, lastBit);
    }


    @Test
    public void testShifts() {

        Assert.assertEquals("80000000", String.format("%08x", Integer.MAX_VALUE + 1));
        Assert.assertEquals("7fffffff", String.format("%08x", Integer.MAX_VALUE));
        Assert.assertEquals("80000000", String.format("%08x", Integer.MIN_VALUE));
        Assert.assertEquals("ffffffff", String.format("%08x", -1));
        Assert.assertEquals("fffffffe", String.format("%08x", -2));
        Assert.assertEquals("fffffffe", String.format("%08x", 0xffffffff - 1));
        Assert.assertEquals("00000001", String.format("%08x", 1 << 0));
        Assert.assertEquals("00000002", String.format("%08x", 1 << 1));
        Assert.assertEquals("fffffffe", String.format("%08x", -1 << 1));
        Assert.assertEquals("7fffffff", String.format("%08x", -1 >>> 1));
        Assert.assertEquals("7fffffff", String.format("%08x", 0xafffffff >> 10));
    }

}
