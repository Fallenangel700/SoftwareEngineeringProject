package scheduler;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.*;

public class ListTest {

    List list;
    Task test;
    
    @Before
    public void before()
    {
        list = new List();
        test = new Task("Testing");
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(list);
    }

    @Test
    public void testingAddSingleTask()
    {
        list.addTask(test);
        Assert.assertEquals(1, list.listedTasks.size());
    }

    @Test
    public void testingAddingMultipleTasks()
    {
        list.addTask(test);
        list.addTask(test);
        list.addTask(test);
        list.addTask(test);
        list.addTask(test);
        Assert.assertEquals(5, list.listedTasks.size());
    }

    @Test
    public void testingRemovingTask()
    {
        list.addTask(test);
        Assert.assertEquals(1, list.listedTasks.size());
        list.removeTask(test);
        Assert.assertEquals(0, list.listedTasks.size());
    }

    //needs to be fixed cant accept multiple user inputs
    @Test
    public void testingEditTask()
    {       
        list.addTask(test);

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        list.editTask();
        System.setIn(sysInBackup);
        Assert.assertEquals("1", list.listedTasks.get(1).getName());
        Assert.assertEquals("1", list.listedTasks.get(1).getDetails());
    }

    @After
    public void after()
    {
        while(list.listedTasks.size()>0)
        {
            list.removeTask(test);
        }
    }
}
