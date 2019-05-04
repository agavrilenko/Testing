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
    public void testFactorial(){

        Assert.assertEquals("15511210043330985984000000", Dummy.extraLongFactorials(25).toString());
}
}

