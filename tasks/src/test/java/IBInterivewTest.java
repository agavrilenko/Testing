import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class IBInterivewTest {

    IBInterivew solution = new IBInterivew();
    static int[] d = new int[10];
    static int[] d1 = new int[]{1};
    static int[] d2 = new int[0];

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, -2, -3, 5}, 1},
                {new int[]{1, 2, 3, -5}, -1},
                {new int[]{1, 2, 0, -5}, 0},
                {new int[]{-1, -2, 0, -5}, 0},
                {new int[]{-1, -2, -5}, -1},
                {new int[]{-1, -2, -5, -5}, 1},
                {d, 0},
                {d1, 1},
                {d2, 0},
                {new int[]{1000, 1000, -1, 20000, 0}, 0},
                {new int[]{1000, 1000, -1, 20000}, -1},
                {new int[]{1000, 1000, -1, 20000, 1000,1000,1000,1000,1000,1000,10000,10000000,1000,10000,10000000,1000000,1000000}, -1},

        };
    }

    @Test
    @UseDataProvider("data")
    public void testSum(final int[] input, final int expected) {
        Assert.assertEquals(expected, solution.solution(input));
    }
}