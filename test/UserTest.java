import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import play.test.FakeApplication;
import play.test.Helpers;

public class UserTest extends DataStoreTest{

    public static FakeApplication app;

    @Before
    public void before()
    {
        app = Helpers.fakeApplication();
        Helpers.start(app);

//        super.createDataSore();
    }

    @After
    public void after()
    {
        Helpers.stop(app);
    }
    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void testCrud() {
        User user = User.newUser("testUser@email.com","testUserPassword","testUser");
        //save
        User.save(user);

        Long id = user.getId();
        User foundById = User.findById(id);
        Assert.isTrue(foundById.getId()==id);

        //read
        User foundUser = User.findByMail("testUser@email.com");
        Assert.notNull(foundUser);
        //update
        foundUser.setEmail("testUserUpdated@email.com");
        User.save(foundUser);

        User foundUserAfterUpdate = User.findByMail("testUserUpdated@email.com");
        Assert.isTrue(foundUserAfterUpdate.getEmail().equals("testUserUpdated@email.com"));

        User foundPreUserAfterUpdate = User.findByMail("testUser@email.com");
        Assert.isNull(foundPreUserAfterUpdate);

        //delete
        User.deleteAllByEmail("testUserUpdated@email.com");
        User foundUserAfterDelete = User.findByMail("testUserUpdated@email.com");
        Assert.isNull(foundUserAfterDelete);

    }


}
