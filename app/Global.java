import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import morphia.MorphiaObject;
import play.GlobalSettings;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;
import utils.jwt.JWTUtil;

import java.lang.reflect.Method;
import java.net.UnknownHostException;

public class Global extends GlobalSettings {

    @Override
    public void onStart(play.Application arg0) {
        super.beforeStart(arg0);
        Logger.debug("** onStart **");
        try {
            MorphiaObject.mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MorphiaObject.morphia = new Morphia();
        MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(MorphiaObject.mongo, "boomer", "admin", "password".toCharArray());
        MorphiaObject.datastore.ensureIndexes();
        MorphiaObject.datastore.ensureCaps();

        Logger.debug("** Morphia datastore: " + MorphiaObject.datastore.getDB());
    }

    @Override
    public Action onRequest(Http.Request request, Method actionMethod) {
        try {
            boolean pass = false;
            if (actionMethod.getName().equals("index") || actionMethod.getName().equals("login") || actionMethod.getName().equals("register") || actionMethod.getName().equals("confirmation")) {
                pass = true;
            } else {
                String authorizationHeader = request.getHeader("Authorization");

                if (authorizationHeader == null && JWTUtil.verify(authorizationHeader)) {
                    pass = false;
                } else {

                    pass = true;
                }

            }
            if (!pass) {
                return new Action.Simple() {
                    @Override
                    public F.Promise<SimpleResult> call(play.mvc.Http.Context ctx) throws Throwable {
                        return F.Promise.pure((SimpleResult) unauthorized("unauthorized"));
                    }
                };
            } else {
                return super.onRequest(request, actionMethod);
            }
        } catch (final Exception exc) {
            exc.printStackTrace();
            return new Action.Simple() {
                @Override
                public F.Promise<SimpleResult> call(play.mvc.Http.Context ctx) throws Throwable {
                    return onError(ctx.request(), exc);
                }
            };
        }
    }
}