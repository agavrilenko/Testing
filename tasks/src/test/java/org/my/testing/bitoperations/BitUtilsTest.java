package org.my.testing.bitoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trash on 20-Mar-17.
 */
public class BitUtilsTest {
    @Test
    public void testSwap_Simple() throws Exception {
        Assert.assertEquals(0x00000001, BitUtils.swap(0x00000010, 0, 4));
        Assert.assertEquals(0x40000000, BitUtils.swap(0x00000001, 0, 30));
    }

    @Test
    public void testSwap_Equal() throws Exception {
        Assert.assertEquals(0x08001111, BitUtils.swap(0x08001111, 5, 28));
        Assert.assertEquals(0x08001111, BitUtils.swap(0x08001111, 5, 6));
    }

}