package utils.jwt;

import org.apache.commons.beanutils.BeanUtils;
import play.libs.Json;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by dustin on 2014/08/03.
 */
public class JWTHeader {

//
//
//  "typ" (Type) Header Parameter The "typ" (type) Header Parameter defined by [JWS] and [JWE] is used to declare the MIME Media Type [IANA.MediaTypes] of this complete JWT in contexts where this is useful to the application.  This parameter has no effect upon the JWT processing.  If present, it is RECOMMENDED that its value be "JWT" to indicate that this object is a JWT.  While  media type names are not case-sensitive, it is RECOMMENDED that "JWT" always be spelled using uppercase characters for compatibility with egacy implementations.  Use of this Header Parameter is OPTIONAL.
    private String typ;
//  "cty" (Content Type) Header Parameter The "cty" (content type) Header Parameter defined by [JWS] and [JWE] is used by this specification to convey structural information aboutthe JWT.
    private String cty;
//  "alg" (Algorithm used)
    private String alg;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String toJson()
    {
        return Json.toJson(this).toString();
    }

    public  void fromJson(String aString) throws IllegalAccessException,InvocationTargetException
    {
        JWTHeader jwtHeader = Json.fromJson(Json.parse(aString),this.getClass());
        BeanUtils.copyProperties(this, jwtHeader);
    }
}
