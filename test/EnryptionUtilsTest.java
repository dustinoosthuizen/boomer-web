import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;
import play.test.FakeApplication;
import play.test.Helpers;
import utils.EncryptionUtil;

/**
 * Created by dustin on 2014/07/27.
 */
public class EnryptionUtilsTest {

    public static FakeApplication app;

    @BeforeClass
    public static void before()
    {
        app = Helpers.fakeApplication();
        Helpers.start(app);
    }

    @AfterClass
    public static void after()
    {
        Helpers.stop(app);
    }

    @Test
    public void testEncrypt()
    {
        String encryptedValue = EncryptionUtil.encryptLong(123456789L);
        Long decryptedValue = EncryptionUtil.decryptLong(encryptedValue);
        Assert.isTrue(123456789L == decryptedValue);
    }

    @Test
    public void testEncryptForwardSlash()
    {
        String encryptedValue = EncryptionUtil.encryptLongReplaceForwardSlash(123456789L, "_");
        Long decryptedValue = EncryptionUtil.decryptLongReplaceForwardSlash(encryptedValue, "_");
        Assert.isTrue(123456789L == decryptedValue);
    }

    @Test
    public void testWithSalt()
    {
        String encryptedValue = EncryptionUtil.encryptLongReplaceForwardSlashWithSalt(123456789L, "_");
        Long decryptedValue = EncryptionUtil.decryptLongReplaceForwardSlashWithSalt(encryptedValue, "_");
        Assert.isTrue(123456789L == decryptedValue);
    }

    @Test
    public void testDigest()
    {
        String aPassword = "frenzal2";
        String digestedPassword = EncryptionUtil.digest(aPassword);
        Assert.isTrue(EncryptionUtil.digesterMatches(aPassword,digestedPassword));
        String aPassword2 = "aPassword2";
        Assert.isTrue(!EncryptionUtil.digesterMatches(aPassword2,digestedPassword));
    }
}
