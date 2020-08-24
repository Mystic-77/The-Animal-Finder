import com.mongodb.*;
import com.mongodb.util.JSON;

import java.util.List;
import java.util.Set;

public class Qtest {
    public void testMethods()
    {
        MongoClient mongoClient=new MongoClient("localhost",27017);
        DB db=mongoClient.getDB("Species");
        DBCollection dbCollection=db.getCollection("asdfg");

        List<String> dbs = mongoClient.getDatabaseNames();
        System.out.println(dbs);

        Set<String> collections = db.getCollectionNames();
        System.out.println(collections);
        String json="{'color':'brown'}";
        DBObject dbObject=(DBObject) JSON.parse(json);
        DBObject projection=(DBObject) JSON.parse("{'_id':1}");
        DBCursor dbCursor=dbCollection.find(dbObject,projection);
        while (dbCursor.hasNext())
        {
            System.out.println(dbCursor.next());
        }
    }
}
