package org.my.hrank;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void testDummy() {
        Assert.assertEquals(1, Dummy.ret(0));
        Assert.assertEquals(1, Dummy.ret(3));
    }

    public static class Dummy {
        static int ret(int v) {
            try {
                throwSurprise(v);
                return 2;
            } catch (Exception e) {
                throw e;
            } finally {
                return 1;
            }
        }

        private static int throwSurprise(int v) {
            if (v > 0) {
                return 3;
            }
            throw new RuntimeException("Yo matherfucker");
        }
    }
}

