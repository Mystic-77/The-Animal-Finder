import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Controller1 {
    Main m=new Main();
    @FXML
    private Pane scene_home;
    public void addEntry(ActionEvent event)throws IOException
    {
        System.out.println("add entry");
        Pane s2 = FXMLLoader.load(getClass().getResource("scene_add.fxml"));
        scene_home.getChildren().setAll(s2);

    }
    public void search(ActionEvent event) throws IOException {
        System.out.println("search");
        Pane s2 = FXMLLoader.load(getClass().getResource("scene_search.fxml"));
        scene_home.getChildren().setAll(s2);
    }
    public void exitApplication()
    {
        m.exitApplication();
    }
}

