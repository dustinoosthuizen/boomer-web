package controllers;

import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

/**
 * Created by dustin on 2014/08/02.
 */
public class Authenticated extends Action.Simple {

    @Override
    public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
        return F.Promise.pure((SimpleResult) unauthorized("unauthorized"));
    }
}
