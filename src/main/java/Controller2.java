import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller2 {

    Main m=new Main();

    @FXML
    Pane scene_add;
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
    TextArea ta_miscf;
    public void exitApplication(ActionEvent actionEvent) {
        m.exitApplication();
    }

    public void toHome()throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("scene_home.fxml"));
        scene_add.getChildren().setAll(root1);
    }

    public void addFields(ActionEvent actionEvent) throws IOException {
        String json="{'name':'"+tf_name.getText()+"',"+
                "'color':'"+tf_color.getText()+"',"+
                "'activity':'"+tf_activity.getText()+"',"+
                "'Diet':'"+tf_diet.getText()+"',"+
                "'habitat':'"+tf_habitat.getText()+"',"+
                "'_id':'"+tf_sname.getText()+"',"+
                "'miscf':'"+ta_miscf.getText()+"'"+
                "}";
        m.mongoAdd(json);
        toHome();

    }
}
