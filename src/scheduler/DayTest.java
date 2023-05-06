package scheduler;
import org.junit.*;
public class DayTest {    
    Day test;

    @Before
    public void before()
    {
        test = new Day();
    }

    @After
    public void after()
    {
      
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(test);
    }


}

