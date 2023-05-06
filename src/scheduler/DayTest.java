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

    @Test
    public void testAddEvent()
    {
    	Assert.assertTrue(test.addEvent("Test", "01 01 0111", "01 01 0211")); 
    }
    
    @Test
    public void testAddEventIncorrect()
    {
    	Assert.assertFalse(test.addEvent("Test", "01 d 0111", "01 d 0211")); 
    }
    
    @Test
    public void testRemoveEvent()
    {
    	test.addEvent("Test", "01 d 0111", "01 d 0211");
    	Assert.assertTrue(test.removeEvent("01 01 0111-01 01 0211")); 
    }
    
    @Test
    public void testRemoveEventIncorrect()
    {
    	test.addEvent("Test", "01 d 0111", "01 d 0211");
    	Assert.assertFalse(test.removeEvent("01 d 0111")); 
    }
    @Test
    public void testEditEvent()
    {
    	Assert.assertTrue(test.editEvent("01 01 0111-01 01 0211", "Test", "01 01 0111", "01 01 0211")); 
    }
    
    @Test
    public void testEditEventIncorrect()
    {
    	Assert.assertFalse(test.editEvent( "01 d 0111","Test", "01 d 0111", "01 d 0211")); 
    }
    
    @Test
    public void testQueryFreeTime()
    {
    	test.queryFreeTime(); 
    }
    
    
    
    
}

