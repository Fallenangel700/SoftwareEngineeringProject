package scheduler;
import org.junit.*;

public class ReminderTest {
    
    Reminder test;

    @Before
    public void before()
    {
        test = new Reminder();
        test.setReminderTime(1000);
    }

    @After
    public void after()
    {
        test.setReminderTime(1000);
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(test);
    }

    @Test
    public void testingSetReminderTime()
    {
        test.setReminderTime(1234);
        Assert.assertEquals(1234,test.getReminderTime());
    }

    @Test
    public void testingGetReminderTime()
    {
        Assert.assertEquals(1000,test.getReminderTime());
    }
}
