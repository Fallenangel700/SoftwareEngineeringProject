import org.junit.*;

public class TaskUnitTest 
{
    @BeforeClass
    public void before()
    {
        Task task1 = new Task("Task");
        Task task2 = new Task("Task", "Details");
    }

    @Test
    public void testConst()
    {
        Assert.assertNotNull(task1);
        Assert.assertNotNull(task2);
    }

    @Test 
    public void testGets()
    {
        Assert.assertEquals(task1.getName(),"Task");
        Assert.assertEquals(task1.getDetails(),"No details entered for Task");
        Assert.assertEquals(task2.getName(),"Task");
        Assert.assertEquals(task2.getDetails(),"Details");
    }

    @Test 
    public void testChanges()
    {
        task1.changeName("Changed");
        task1.changeDetails("Changed");
        Assert.assertEquals(task1.getName(),"Changed");
        Assert.assertEquals(task1.getDetails(),"Changed");
        task1.changeName("Task");
        task1.changeDetails(null);
        Assert.assertNull(task1.getDetails());
        task2.changeName("Changed");
        task2.changeDetails("Changed");
        Assert.assertEquals(task2.getName(),"Changed");
        Assert.assertEquals(task2.getDetails(),"Changed");
        task2.changeName("Task");
        task1.changeDetails("Details");
    }
}
