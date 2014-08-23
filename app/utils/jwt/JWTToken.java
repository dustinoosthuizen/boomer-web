package utils.jwt;

import utils.EncryptionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

/**
 * Created by dustin on 2014/08/03.
 */
public class JWTToken {

    private JWTHeader jwtHeader;
    private JWTPayload jwtPayload;
    private String mac;

    public JWTHeader getJwtHeader() {
        return jwtHeader;
    }

    public void setJwtHeader(JWTHeader jwtHeader) {
        this.jwtHeader = jwtHeader;
    }

    public JWTPayload getJwtPayload() {
        return jwtPayload;
    }

    public void setJwtPayload(JWTPayload jwtPayload) {
        this.jwtPayload = jwtPayload;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String encrypt()
    {
        String header = jwtHeader.toJson();
        String payload = jwtPayload.toJson();
        String headerPayload = header+"."+payload;
        mac = "{"+EncryptionUtil.encrypt(headerPayload)+"}";
        String token = header+"."+payload+"."+mac;
        String encryptedToken = EncryptionUtil.encrypt(token);
        encryptedToken.replaceAll("//","_");
        return encryptedToken;
    }

    public void decrypt(String encryptedString) throws IllegalAccessException,InvocationTargetException
    {
        encryptedString.replaceAll("_","//");
        String token = EncryptionUtil.decrypt(encryptedString);
        String[] parts = token.split("\\.\\{");
        String header = parts[0];
        String payload = "{"+parts[1];
        String mac = "{"+parts[2];

        this.jwtHeader = new JWTHeader();
        jwtHeader.fromJson(header);
        this.jwtPayload = new JWTPayload();
        jwtPayload.fromJson(payload);
        this.mac = mac;
//        JWTPayload jwtPayload = Json.fromJson(JsonNodeFactory.instance.textNode(aString), this.getClass());
//        BeanUtils.copyProperties(this, jwtPayload);
    }

    public boolean macValid() {
        String header = jwtHeader.toJson();
        String payload = jwtPayload.toJson();
        String headerPayload = header + "." + payload;
        String macDecryptred = EncryptionUtil.decrypt(mac);
        String[] parts = macDecryptred.split("\\.\\{");
        String headerDecrypted = parts[0];
        String payloadDecrypted = "{"+parts[1];
        if(headerDecrypted.equals(header)&&payloadDecrypted.equals(payload)){
            return true;
        } else {
            return false;
        }
    }

    public boolean expirationValid()
    {
        String exp = jwtPayload.getExp();
        if(exp!=null)
        {
            Long expiryTimeInMilliseconds = Long.parseLong(exp);
            Calendar nowCal = Calendar.getInstance();
            Calendar expiryCal = Calendar.getInstance();
            expiryCal.setTimeInMillis(expiryTimeInMilliseconds);
            if(nowCal.before(expiryCal))
            {
                return true;
            }else
            {
                return false;
            }
        }
        return true;
    }
}
