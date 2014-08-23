import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import morphia.MorphiaObject;
import play.Logger;

import java.net.UnknownHostException;

/**
 * Created by dustin on 2014/07/26.
 */
public class DataStoreTest {

    public void createDataSore()
    {
        Logger.debug("** onStart **");
        try {
            MorphiaObject.mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MorphiaObject.morphia = new Morphia();
        MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(MorphiaObject.mongo, "boomer","admin","password".toCharArray());
        MorphiaObject.datastore.ensureIndexes();
        MorphiaObject.datastore.ensureCaps();
        Logger.debug("** Morphia datastore: " + MorphiaObject.datastore.getDB());
    }
}
