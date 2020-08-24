import com.mongodb.*;
import com.mongodb.util.JSON;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

//import javafx.scene.Parent;

public class Main extends Application {


    Stage primaryStage=new Stage();

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    DB db = mongoClient.getDB("Species");
    DBCollection col=db.getCollection("asdfg");

    public ArrayList<DBObject> sqal=new ArrayList<DBObject>();


    @Override
    public void start(Stage stage) throws Exception{
        primaryStage=stage;
        Parent root1 = FXMLLoader.load(getClass().getResource("scene_home.fxml"));
        primaryStage.setTitle("Animal Finder");
        primaryStage.setScene(new Scene(root1,750,500));
        primaryStage.show();

    }
    public void exitApplication()
    {
        System.out.println("exiting Application");
        Platform.exit();
    }
    public void mongoAdd(String json)
    {
        DBObject dbObject=(DBObject) JSON.parse(json);
        col.save(dbObject);
        Cursor cursor=col.find();
        System.out.println(cursor.next());

    }

    public void searchEntities(String json)
    {
        System.out.println("search entities got called with query string as \n"+json);
        DBObject dbObject=(DBObject) JSON.parse(json);
        System.out.println("JSON parsed");
        DBObject projection=(DBObject) JSON.parse("{'_id':1}");
        DBCursor dbCursor=col.find(dbObject,projection);
        System.out.println("Cursor made and retrieved");
        System.out.println(dbCursor);
        sqal.clear();
        while (dbCursor.hasNext())
        {
            //System.out.println("in while loop");
            sqal.add(dbCursor.next());
            //System.out.println(dbCursor.next());
        }
        //checking
        System.out.println(sqal);

    }
    public void deleteEntity(String id)
    {
        DBObject dbObject=(DBObject) JSON.parse(id);
        col.remove(dbObject);
    }

    public static void main(String[] args) {
        //Qtest qtest=new Qtest();
        //qtest.testMethods();
        launch(args);


    }
}
