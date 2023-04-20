import org.junit.*;

public class EventUnitTest 
{
    @BeforeClass
    public void before()
    {
        Event eve = new Event(0000, 1000, "Event");
    }

    @Test
    public void testConst()
    {
        Assert.assertNotNull(eve);
    }

    @Test 
    public void testGets()
    {
        Assert.assertEquals(eve.getStartTime(),0000);
        Assert.assertEquals(eve.getEndTime(),1000);
        Assert.assertEquals(eve.getEventName(),"Event");
    }

    @Test 
    public void testValidateTime()
    {
        Assert.assertTrue(eve.validateTime(0000));
        Assert.assertFalse(eve.validateTime(4000));
    }

    @Test 
    public void testChanges()
    {
        eve.changeName("Changed");
        Assert.assertEquals(eve.getEventName(),"Changed");
        eve.changeStartTime(2000);
        Assert.assertEquals(eve.getStartTime(),2000);
        eve.changeStartTime(8000);
        Assert.assertEquals(eve.getStartTime(),2000);
        eve.changeEndTime(2400);
        Assert.assertEquals(eve.getEndTime(),2400);
        eve.changeEndTime(8000);
        Assert.assertEquals(eve.getStartTime(),2400);
        eve.changeStartTime(0000);
        eve.changeEndTime(1000);
    }
}
