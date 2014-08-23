package utils;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import play.Play;

/**
 * Created by dustin on 2014/07/27.
 */
public class EncryptionUtil {



    public static String encrypt(String value)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String encryptedText = encryptor.encrypt(value);
        return encryptedText;
    }

    public static String decrypt(String value)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String plainText = encryptor.decrypt(value);
        return plainText;
    }

    public static String encryptLong(Long value)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String encryptedText = encryptor.encrypt(value+"");
        return encryptedText;
    }

    public static Long decryptLong(String value)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String plainText = encryptor.decrypt(value);
        return new Long(plainText);
    }

    public static String encryptLongReplaceForwardSlash(Long value,String replacement)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String encryptedText = encryptor.encrypt(value+"");
        replacement = replacement.replaceAll("/",replacement);
        return encryptedText;
    }

    public static Long decryptLongReplaceForwardSlash(String value,String replacement)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        value =value.replace(replacement,"/");
        String plainText = encryptor.decrypt(value);
        return new Long(plainText);
    }

    public static String encryptLongReplaceForwardSlashWithSalt(Long value,String replacement)
    {
        String salt = Play.application().configuration().getString("encryption.salt");
//        String salt = "WR9bdtN3tMHg75PDK9PoIQ==";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String encryptedText = encryptor.encrypt(salt+value+"");
        encryptedText = encryptedText.replaceAll("/",replacement);
        return encryptedText;
    }



    public static Long decryptLongReplaceForwardSlashWithSalt(String value,String replacement)
    {
        String salt = Play.application().configuration().getString("encryption.salt");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        value =value.replace(replacement,"/");
        String plainText = encryptor.decrypt(value);
        plainText = plainText.replace(salt,"");
        return new Long(plainText);
    }

    public static String encryptStringReplaceForwardSlashWithSalt(String value,String replacement)
    {
        String salt = Play.application().configuration().getString("encryption.salt");
//        String salt = "WR9bdtN3tMHg75PDK9PoIQ==";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        String encryptedText = encryptor.encrypt(salt+value+"");
        encryptedText = encryptedText.replaceAll("/",replacement);
        return encryptedText;
    }

    public static String decryptStringReplaceForwardSlashWithSalt(String value,String replacement)
    {
        String salt = Play.application().configuration().getString("encryption.salt");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(Play.application().configuration().getString("encryption.password"));
        encryptor.setAlgorithm(Play.application().configuration().getString("encryption.decryption.algorithm"));
        value =value.replace(replacement,"/");
        String plainText = encryptor.decrypt(value);
        plainText = plainText.replace(salt,"");
        return plainText;
    }

    public static String digest(String aString)
    {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");
        digester.setStringOutputType("base64");
        digester.setIterations(1);
        String encryptedPassword = digester.digest(aString);
        return encryptedPassword;
    }

    public static boolean digesterMatches(String password,String encryptedPassword)
    {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");
        digester.setStringOutputType("base64");
        digester.setIterations(1);
        return digester.matches(password,encryptedPassword);

    }


}
