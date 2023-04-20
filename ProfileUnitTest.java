import org.junit.*;

public class ProfileUnitTest 
{
    @BeforeClass
    public void before()
    {
        Profile pro = new Profile("username", "password");
    }

    @Test
    public void testConst()
    {
        Assert.assertNotNull(pro);
    }

    @Test
    public void testGets()
    {
        Assert.assertEquals(pro.getName(),"username");
    }

    @Test 
    public void testCheckPass()
    {
        Assert.assertEquals(pro.checkPass("password"),true);
    }
}

