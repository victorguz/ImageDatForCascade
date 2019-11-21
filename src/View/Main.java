/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Victor
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        TextArea text = new TextArea();
        VBox root = new VBox();
        text.setPromptText("Aquí aparecen los resultados");
        text.setWrapText(true);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        btn.setText("Seleccionar carpeta de imagenes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                fc.setInitialFileName(System.getProperty("user.home")
                        + "\\Desktop\\");
                FileChooser.ExtensionFilter filter
                        = new FileChooser.ExtensionFilter("Archivos de imágen",
                                "*.jpg", "*.png", "*.jpeg");
                fc.getExtensionFilters().add(filter);
                fc.setTitle("Seleccione las imágenes");
                List<File> f = fc.showOpenMultipleDialog(primaryStage);
                if (f != null) {
                    if (!f.isEmpty()) {
                        for (File file : f) {
                            Image img = new Image(file.toURI().toString());
                            String[] folder
                                    = file.getAbsolutePath().split("\\\\");
                            System.out.println(folder[folder.length - 2]
                                    + "/" + folder[folder.length - 1]
                                    + " 1 0 0 " + img.getWidth()
                                    + " " + img.getHeight());
                            if (text.getText().isEmpty()) {
                                text.setText(folder[folder.length - 2]
                                        + "/" + folder[folder.length - 1]
                                        + " 1 0 0 " + img.getWidth()
                                        + " " + img.getHeight());
                            } else {
                                text.setText(text.getText() + "\n"
                                        + (folder[folder.length - 2] + "/"
                                        + folder[folder.length - 1]
                                        + " 1 0 0 "
                                        + (int) img.getWidth() + " "
                                        + (int) img.getHeight()));
                            }
                        }
                    }
                }
            }
        }
        );
        root.getChildren().add(btn);
        root.getChildren().add(text);
        Scene scene = new Scene(root);
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
