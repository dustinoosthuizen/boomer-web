import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import play.test.FakeApplication;
import play.test.Helpers;
import utils.jwt.JWTUtil;

/**
 * Created by dustin on 2014/08/02.
 */
public class JWTUtilTest {

        public static FakeApplication app;

        @Before
        public void before()
        {
            app = Helpers.fakeApplication();
            Helpers.start(app);
        }

        @After
        public void after()
        {
            Helpers.stop(app);
        }

        @Test
        public void testJWTGenerate() throws Exception
        {
            String encryptedValue = JWTUtil.generateToken("testUser@gmail.com");
            boolean verified = JWTUtil.verify(encryptedValue);
            Assert.isTrue(verified);

        }



}
