import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class GoogleInterviewTest {
    GoogleInterview solution = new GoogleInterview();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {},
        };
    }

    @Test
    @UseDataProvider("data")
    public void testSum(final int[] input, final int expected) {
        Assert.assertEquals(expected, solution.solution(input));
    }
}