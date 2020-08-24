import com.mongodb.DBObject;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class Controller4 {

    @FXML
    public Button btn_back;
    @FXML
    public Button btn_get;
    @FXML
    public Button btn_exit;
    @FXML
    public ListView<DBObject> lv_res;
    @FXML
    public Pane scene_results;
    @FXML
    public Label l_rno;

    Main m= new Main();

    /*
        public void setLv_res(ArrayList<DBObject> sqal) {


            System.out.println("c4");
            lv_res.getItems().addAll(sqal);

            System.out.println(sqal);
            ListView<DBObject> t = new ListView<DBObject>(FXCollections.observableArrayList(sqal));
            //lv_res.setItems((ObservableList) t);
            //lv_res.setItems(FXCollections.observableArrayList(sqal));
            //lv_res.getItems().setAll(sqal);
        }
    */
    public void displayList(ArrayList<DBObject> sqal)
    {
        System.out.println("controller 4,prints the collection of results");
        System.out.println(sqal);
        int x =(FXCollections.observableArrayList(sqal).size());
        System.out.println(x);
        // ObservableList<DBObject> items=FXCollections.observableArrayList(sqal);
        //lv_res.setItems(items);

    }




    public void getResult()
    {
        //none yet

    }
    public void exitApplication(ActionEvent event) {
        m.exitApplication();
    }

    public void toSearch(ActionEvent event) throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("scene_search.fxml"));
        scene_results.getChildren().setAll(root1);
    }
}
//ListView<DBObject> t
//                = new ListView<DBObject>(FXCollections.observableArrayList(m.sqal));

