package scheduler;
import org.junit.*;

public class EventTest {

    Event eve;

    @Before
    public void before()
    {
        //eve = new Event(0000, 1000, "Event");
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(eve);
    }

    @Test 
    public void testingGetStart()
    {
        Assert.assertEquals(eve.getStartTime(),0000);
    }

    @Test 
    public void testingGetEnd()
    {
        Assert.assertEquals(eve.getEndTime(),1000);
    }

    @Test 
    public void testingGetName()
    {
        Assert.assertEquals(eve.getEventName(),"Event");
    }

    @Test
    public void testingChangeStart()
    {
        //eve.changeStartTime(2000);
        Assert.assertEquals(eve.getStartTime(),2000);
        //eve.changeStartTime(8000);
        Assert.assertEquals(eve.getStartTime(),2000);
    }

    @Test
    public void testingChangeEnd()
    {
        //eve.changeEndTime(2400);
        Assert.assertEquals(eve.getEndTime(),2400);
        //eve.changeEndTime(8000);
        Assert.assertEquals(eve.getEndTime(),2400);
    }

    @Test
    public void testingChangeName()
    {
        eve.changeName("Changed");
        Assert.assertEquals(eve.getEventName(),"Changed");
    }

    @Test
    public void testingSetReminder()
    {
        //eve.setReminderTime(1200);
        Assert.assertEquals(1200,eve.getReminderTime());
        eve.getReminderTime();
    }

    @After
    public void after()
    {
        //eve.changeStartTime(0000);
        //eve.changeEndTime(1000);
        eve.changeName("Event");
    }
    
}
