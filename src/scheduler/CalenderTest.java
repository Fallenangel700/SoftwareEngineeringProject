package scheduler;
import org.junit.*;


public class CalenderTest
{
    Calendar cal;
    @Before
    public void before()
    {
        cal = new Calendar();
    }

    //testing creation of class
    @Test
    public void testConst()
    {
        Assert.assertNotNull(cal);
    }

    @Test
    public void testAddEvent()
    {
    	Assert.assertTrue(cal.addEvent("Test", "01 01 0111", "01 01 0211")); 
    }
    
    @Test
    public void testAddEventIncorrect()
    {
    	Assert.assertFalse(cal.addEvent("Test", "01 d 0111", "01 d 0211")); 
    }
    
    @Test
    public void testRemoveEvent()
    {
    	Assert.assertTrue(cal.addEvent("Test", "01 01 0111", "01 01 0211"));
    	cal.removeEvent("Test");
    }
    
    @Test
    public void testRemoveEventIncorrect()
    {
    	Assert.assertTrue(cal.addEvent("Test", "01 01 0111", "01 01 0211"));
    	cal.removeEvent("False");

    }
    
    @Test
    public void testEditEvent()
    {
    	Assert.assertTrue(cal.addEvent("Test", "01 01 0111", "01 01 0211"));
    	cal.editEvent("Test" ,"Test2", "01 02 0111", "01 02 0211");
    }
    
    @Test
    public void testEditEventIncorrect()
    {
    	Assert.assertTrue(cal.addEvent("Test", "01 01 0111", "01 01 0211"));
    	cal.editEvent("False","Test2", "01 02 0111", "01 02 0211");

    }
    
    
    
    
    
    
}