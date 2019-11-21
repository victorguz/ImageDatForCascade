/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Victor
 */
public class JavaFXApplication10 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Seleccionar carpeta de imagenes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                fc.setInitialFileName(System.getProperty("user.home") + "\\Desktop\\");
                FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos de imágen", "*.jpg", "*.png", "*.jpeg");
                fc.getExtensionFilters().add(filter);
                fc.setTitle("Seleccione las imágenes");
                List<File> f = fc.showOpenMultipleDialog(primaryStage);
                String[] folder = f.get(0).getAbsolutePath().split("\\");
                System.out.println(folder[folder.length - 1] + "\\" + f.get(0).getName());
                /*  for (int i = 0; i < list.length; i++) {
                    File f = new File("src/pos/" + list[i]);
                    Image img = new Image(f.toURI().toString());
                    System.out.println("pos/" + list[i]);
                }*/
            }
        }
        );
        VBox root = new VBox();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
