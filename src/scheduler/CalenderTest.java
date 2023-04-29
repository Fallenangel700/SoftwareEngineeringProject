package scheduler;
import org.junit.*;


public class CalenderTest
{
    Calendar cal;
    @Before
    public void before()
    {
        cal = new Calendar();
    }

    //testing creation of class
    @Test
    public void testConst()
    {
        Assert.assertNotNull(cal);
    }


}