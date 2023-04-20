import org.junit.*;

public class ReminderUnitTest 
{
    @BeforeClass
    public void before()
    {
        Reminder rem = new Reminder();
    }

    @Test
    public void testConst()
    {
        Assert.assertNotNull(rem);
    }

    @Test 
    public void testGets()
    {
        Assert.assertEquals(eve.getReminderTime(),-1);
    }

    @Test 
    public void testSet()
    {
        rem.setReminderTime(0000);
        Assert.assertEquals(eve.getReminderTime(),0000);
        rem.setReminderTime(-1);
    }
}
