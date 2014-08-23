import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;
import utils.MailSenderUtil;

public class MailSenderTest {

    public static FakeApplication app;

//    @Test
//    public void testMailPluginSender() {
//        app = Helpers.fakeApplication();
//        Helpers.start(app);
//        MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
//        System.out.println(play.Play.application().configuration().getString("smtp.user"));
//        System.out.println(play.Play.application().configuration().getString("smtp.port"));
//        System.out.println(mail);
//        mail.setSubject("Boomer Account Verification");
//        mail.setRecipient("dustin_oosthuizen@yahoo.com");
//        mail.setFrom("Boomer@gmail.com");
////sends html
//        mail.sendHtml("<html>This is from BOOMER</html>");
//        Helpers.stop(app);
//
//    }

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
    public void testMailPluginSender() {
        System.out.println("test1");
        MailSenderUtil.sendConfirmationEmail("dustin.oosthuizen@gmail.com", 1234567L);
    }


//    @Test
//    public void test2() {
//        System.out.println("test2");
//    }

}
