package ablakos;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Ablakos extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();

        File file = new File(" ../../file.txt ");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println(" A fá jl nem tal á lhat ó .");
            return;
        }

        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Button b1 = new Button("" + sc.nextInt());
                b1.setMinSize(70, 70);
                grid.add(b1, j, i);
                b1.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        int szam =  Integer.parseInt(b1.getText());
                        b1.setText(""+(szam+1));
                    }
                });
            }

        }
        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
