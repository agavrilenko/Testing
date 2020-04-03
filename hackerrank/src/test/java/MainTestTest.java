import org.junit.Assert;
import org.junit.Test;
import org.my.hrank.AbstractPackageTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTestTest {

    @Test
    public void testSum() {

        int[] ar = new int[]{1, 2, 3, 4, 6};
        long val = Arrays.stream(ar).reduce((x, y) -> x + y).orElse(0);
        Assert.assertEquals(16, val);
    }

    @Test

    public void testAVeryBigSum() {

        int[] ar = new int[]{1, 2, 3, 4, 6};
        long val = Arrays.stream(ar).mapToObj(BigDecimal::valueOf).reduce(BigDecimal::add).orElse(BigDecimal.ZERO).longValue();
        Assert.assertEquals(16, val);
    }



}