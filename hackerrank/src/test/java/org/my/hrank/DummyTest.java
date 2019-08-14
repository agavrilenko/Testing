package org.my.hrank;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void testDummy() {
        Assert.assertEquals(1, Dummy.ret(0));
        Assert.assertEquals(1, Dummy.ret(3));
    }

    @Test
    public void testFactorial() {

        Assert.assertEquals("15511210043330985984000000", Dummy.extraLongFactorials(25).toString());
    }

    @Test
    public void testAcmTeam() {
        Assert.assertArrayEquals(new int[]{5,1}, Dummy.acmTeam(new String[]{"10101","11110","00010"}));
        Assert.assertArrayEquals(new int[]{5,2}, Dummy.acmTeam(new String[]{"10101","11100","11010","00101"}));

    }
    @Test
    public  void testSum(){

        Assert.assertEquals(150, Dummy.sum(1,2,3,4,56,9).longValue());
    }
}

