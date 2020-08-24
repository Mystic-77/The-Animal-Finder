import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller3 {
    Main m = new Main();
    @FXML
    Pane scene_search;
    @FXML
    TextField tf_name;
    @FXML
    TextField tf_color;
    @FXML
    TextField tf_activity;
    @FXML
    TextField tf_diet;
    @FXML
    TextField tf_habitat;
    @FXML
    TextField tf_sname;
    @FXML
    TextArea tf_miscf;
    @FXML
    public Button btn_back2;
    @FXML
    public Button btn_get;
    @FXML
    public Button btn_exit;
    @FXML
    public TextArea results;
    @FXML
    public Pane scene_results;
    @FXML
    public Label l_rno;
    @FXML
    public Button btn_delete;


    public void toHome() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("scene_home.fxml"));
        scene_search.getChildren().setAll(root1);
    }

    public String createJson()
    {
        String json = "{";
        /*System.out.println("string json created");
        System.out.println(tf_sname.getText());
        System.out.println(tf_activity.getText());
        System.out.println(tf_color.getText());
        System.out.println(tf_diet.getText());
        System.out.println(tf_habitat.getText());
        System.out.println(tf_name.getText());
        System.out.println(ta_miscf.getText());*/
        if (!tf_sname.getText().equals("")) {
            System.out.println("sname field");
            json += "'_id':'" + tf_sname.getText() + "'";
            json += "}";
        } else {
            System.out.println("else part");
            if (!tf_name.getText().equals("")) {
                json += "'name':'" + tf_name.getText() + "',";
            }
            if (!tf_color.getText().equals("")) {
                json += "'color':'" + tf_color.getText() + "',";
            }
            if (!tf_habitat.getText().equals("")) {
                json += "'habitat':'" + tf_habitat.getText() + "',";
            }
            if (!tf_activity.getText().equals("")) {
                json += "'activity':'" + tf_activity.getText() + "',";
            }
            if (!tf_diet.getText().equals("")) {
                json += "'diet':'" + tf_diet.getText() + "',";
            }
            if (!tf_miscf.getText().equals("")) {
                json += "'miscf':'" + tf_miscf.getText() + "'";
            }
            int l = json.length();
            if (json.charAt(l - 1) == ',') {
                json = json.substring(0, l - 1);
            }
            json += "}";
            if (json.equals("{}")) {
                json = "";
            }
            System.out.println("Query string has been made");
        }
        return json;
    }
    public void searchQuery() throws IOException {
        System.out.println("searchQuery started");
        String json=createJson();
        m.searchEntities(json);
        System.out.println("Array of required results" + m.sqal);

        Pane root = FXMLLoader.load(getClass().getResource("scene_results.fxml"));
        scene_search.getChildren().setAll(root);
    }

    public void deleteQuery() throws IOException
    {
        System.out.println("Deletion processing");
        String id="{'_id':'"+tf_sname.getText()+"'}";
        System.out.println(id);
        m.deleteEntity(id);
    }


    public void exitApplication() {
        m.exitApplication();
    }

    public void getResult() {
        results.setText(m.sqal.toString());
        //none yet

    }
    public void toSearch(ActionEvent event) throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("scene_search.fxml"));
        scene_results.getChildren().setAll(root1);
    }
}