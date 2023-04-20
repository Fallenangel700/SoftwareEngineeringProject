import org.junit.*;

public class CalenderUnitTest 
{
    @BeforeClass
    public void before()
    {
        Calender cal = new Calendar();
    }

    @Test
    public void testConst()
    {
        Assert.assertNotNull(cal);
    }


}
