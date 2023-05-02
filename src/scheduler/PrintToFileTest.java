package scheduler;
import org.junit.*;

public class PrintToFileTest 
{
    PrintToFile test;
    Calendar testCal;

    @Before
    public void before()
    {
        testCal = new Calendar();
        test = new PrintToFile(testCal);
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(test);
    }

    @Test
    public void testingPrinting()
    {
        //need to be edited once printing functionality is created
    }
}
