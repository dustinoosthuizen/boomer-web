package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import play.Play;

/**
 * Created by dustin on 2014/07/27.
 */
public class MailSenderUtil {

    public static void sendConfirmationEmail(String email,String userId)
    {
        try {

            Email mailer = new SimpleEmail();
            mailer.setHostName(Play.application().configuration().getString("mail.smtp.host"));
//            mailer.setHostName("smtp.googlemail.com");
            mailer.setSmtpPort(465);
            mailer.setAuthenticator(new DefaultAuthenticator(Play.application().configuration().getString("mail.smtp.user"), Play.application().configuration().getString("mail.smtp.password")));
//            mailer.setAuthenticator(new DefaultAuthenticator("dustinosthzn", "frenzal2"));
            mailer.setSSLOnConnect(true);
            mailer.setFrom(Play.application().configuration().getString("mail.from"));
//            mailer.setFrom("registrations@boomer.com");
            mailer.setSubject("Boomer Registration");
            String encryptedUserId = EncryptionUtil.encryptLongReplaceForwardSlashWithSalt(email+"","_");
            mailer.setMsg("Thanks for registering with boomer, please click on link to finish registration "+ Play.application().configuration().getString("base.url")+"/api/registration/confirmation/"+encryptedUserId);
            mailer.addTo(email);
            mailer.send();
        }catch(EmailException exc)
        {
            exc.printStackTrace();
        }
    }
}
