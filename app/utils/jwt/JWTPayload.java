package utils.jwt;

import org.apache.commons.beanutils.BeanUtils;
import play.libs.Json;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by dustin on 2014/08/03.
 */
public class JWTPayload {

//    The "iss" (issuer) claim identifies the principal that issued the JWT.  The processing of this claim is generally application specific. value.  Use of this claim is OPTIONAL.
    private String iss;
//    The "sub" (subject) claim identifies the principal that is the subject of the JWT.  The Claims in a JWT are normally statements about the subject.  The subject value MAY be scoped to be locally unique in the context of the issuer or MAY be globally unique.  The processing of this claim is generally application specific.  The "sub" value is a case-sensitive string containing a StringOrURI value.  Use of this claim is OPTIONAL.
    private String sub;
    private String aud;
//    The "aud" (audience) claim identifies the recipients that the JWT is intended for.  Each principal intended to process the JWT MUST identify itself with a value in the audience claim.  If the principal processing the claim does not identify itself with a value in the "aud" claim when this claim is present, then the JWT MUST be rejected.  In the general case, the "aud" value is an array of case- sensitive strings, each containing a StringOrURI value.  In the special case when the JWT has one audience, the "aud" value MAY be a single case-sensitive string containing a StringOrURI value.  The interpretation of audience values is generally application specific. Use of this claim is OPTIONAL.
    private String exp;
//    The "exp" (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing.  The processing of the "exp" claim requires that the current date/time MUST be before the expiration date/time listed in the "exp" claim. Implementers MAY provide for some small leeway, usually no more than a few minutes, to account for clock skew.  Its value MUST be a number containing an IntDate value.  Use of this claim is OPTIONAL.
    private String nbf;
//    The "nbf" (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing.  The processing of the "nbf" claim requires that the current date/time MUST be after or equal to
    private String iat;
//     The "iat" (issued at) claim identifies the time at which the JWT was issued.  This claim can be used to determine the age of the JWT.  Its value MUST be a number containing an IntDate value.  Use of this claim is OPTIONAL.


    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getNbf() {
        return nbf;
    }

    public void setNbf(String nbf) {
        this.nbf = nbf;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String toJson()
    {
        return Json.toJson(this).toString();
    }

    public void fromJson(String aString) throws IllegalAccessException,InvocationTargetException
    {
        JWTPayload jwtPayload = Json.fromJson(Json.parse(aString),this.getClass());
        BeanUtils.copyProperties(this,jwtPayload);
    }
}
