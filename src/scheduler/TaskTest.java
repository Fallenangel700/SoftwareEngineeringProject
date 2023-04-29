package scheduler;
import org.junit.*;

public class TaskTest {
    
    Task testWoDetails;
    Task testWithDetails;

    @Before
    public void before()
    {
        testWoDetails = new Task("Testing without Details");
        testWithDetails = new Task("Testing with Details", "Details");
    }

    @After
    public void after()
    {
        testWoDetails.changeName("Testing without Details");
        testWithDetails.changeDetails("Details");
    }

    @Test
    public void testingConstructors()
    {
        Assert.assertNotNull(testWithDetails);
        Assert.assertNotNull(testWoDetails);
    }

    @Test
    public void testingChangeName()
    {
        testWoDetails.changeName("Hello There!");
        Assert.assertEquals("Hello There!", testWoDetails.getName());
    }

    @Test
    public void testingChangeDetails()
    {
        testWithDetails.changeDetails("General Kenobi");
        Assert.assertEquals("General Kenobi", testWithDetails.getDetails());
    }

    @Test
    public void testingGetName()
    {
        Assert.assertEquals("Testing without Details", testWoDetails.getName());
    }

    @Test
    public void testingGetDetails()
    {
        Assert.assertEquals("Details", testWithDetails.getDetails());
    }
}
