import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(new Group());
        stage.setTitle("Dogs");
        stage.setWidth(250);
        stage.setHeight(250);

        network network = new network();
        network.sendRequest();

        Image image = new Image(new FileInputStream(network.getImage()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);


        final VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene.getRoot()).getChildren().addAll(vbox,imageView);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
