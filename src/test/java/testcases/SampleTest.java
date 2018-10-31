package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SampleTest {
    private int runFirstInvocationCount = 0;

    @Test(priority = 2)
    public void runSecond() {
        assertEquals(runFirstInvocationCount, data().length);
        System.out.println("priority = 2");
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {/* your data values here */}
        };
    }

    @Test(priority = 1, dataProvider = "data")
    public void runFirst(/* your data parameters here */) {
        runFirstInvocationCount++;
        System.out.println("priority=1");
    }
}
