package scheduler;
import org.junit.*;

public class ProfileTest {

    Profile test;

    @Before
    public void before()
    {
        test = new Profile("username", "password");
    }

    @Test
    public void testingConstructor()
    {
        Assert.assertNotNull(test);
    }

    @Test
    public void testingGetName()
    {
        Assert.assertEquals("username", test.getName());
    }

    @Test
    public void testingCheckPass()
    {
        Assert.assertTrue(test.checkPass("password"));
        Assert.assertFalse(test.checkPass("intruder"));
    }
}
