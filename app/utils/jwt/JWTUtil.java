package utils.jwt;

import com.nimbusds.jose.JOSEException;
import play.Play;
import utils.CalendarUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

/**
 * Created by dustin on 2014/08/02.
 */
public class JWTUtil {

    public static String generateToken(String userName) throws JOSEException,ParseException
    {
        JWTToken jwtToken = new JWTToken();
        JWTHeader jwtHeader = new JWTHeader();
        jwtToken.setJwtHeader(jwtHeader);
        JWTPayload jwtPayload = new JWTPayload();
        jwtToken.setJwtPayload(jwtPayload);
        jwtHeader.setTyp("JWT");
        jwtHeader.setAlg(Play.application().configuration().getString("encryption.decryption.algorithm"));
        jwtPayload.setIss("boomerclient");
        jwtPayload.setSub(userName);
        jwtPayload.setExp(CalendarUtils.getCalendarDaysInFuture(30).getTimeInMillis()+"");
        return jwtToken.encrypt();
    }

    public static boolean verify(String jwtTokenString) throws JOSEException,ParseException,IllegalAccessException,InvocationTargetException
    {
        JWTToken jwtToken = new JWTToken();
        jwtToken.decrypt(jwtTokenString);
        return jwtToken.macValid()&&jwtToken.expirationValid();

    }

}
