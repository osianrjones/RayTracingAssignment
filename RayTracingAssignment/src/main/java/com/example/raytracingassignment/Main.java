package com.example.raytracingassignment;/*
CS-255 Getting started code for the assignment
I do not give you permission to post this code online
Do not post your solution online
Do not copy code
Do not use JavaFX functions or other libraries to do the main parts of the assignment (i.e. ray tracing steps 1-7)
All of those functions must be written by yourself
You may use libraries to achieve a better GUI
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {
    public static int Width = 720;
    public static int Height = 500;
    public static ArrayList<Sphere> spheres = new ArrayList<>();
    public static Stage stage;
    int green_col = 255; //just for the test example
    Sphere sphereOne = new Sphere(0, 0, 100, 0, 1, 0, 50, "sphereOne");
    Sphere sphereTwo = new Sphere(100, 100, 0, 1, 0, 0, 50, "sphereTwo");

    public static Stage getStage() {
        return stage;
    }

    public static void Render(WritableImage image) {
        //Get image dimensions, and declare loop variables
        int w = (int) image.getWidth(), h = (int) image.getHeight(), i, j;
        PixelWriter image_writer = image.getPixelWriter();
        Vector o = new Vector(0, 0, 0);  //Origin of the ray
        Vector d = new Vector(0, 0, 1); //Direction of ray


        Vector Light = new Vector(100, 100, -100);


        for (j = 0; j < h; j++) {
            for (i = 0; i < w; i++) {
                ArrayList<Double> intersects = new ArrayList<>();
                for (Sphere sphere : spheres) {
                    intersects.add(sphere.intersect(o, Light, d, h, w, j, i));
                }
                double lowest = 999;
                int lowestIndex = -1;
                for (int k = 0; k < intersects.size(); k++) {
                    if (intersects.get(k) != 0) {
                        if (intersects.get(k) < lowest) {
                            lowest = intersects.get(k);
                            lowestIndex = k;
                        }
                    }
                }
                if (lowestIndex != -1) {
                    image_writer.setColor(i, j, Color.color(spheres.get(lowestIndex).getCol() * spheres.get(lowestIndex).r, spheres.get(lowestIndex).getCol() * spheres.get(lowestIndex).g, spheres.get(lowestIndex).getCol() * spheres.get(lowestIndex).b, 1.0));
                } else {
                    image_writer.setColor(i, j, Color.color(0, 0, 0, 1.0));
                }

            } // column loop
        } // row loop
    }

    public static ArrayList<Sphere> getSpheres() {
        return spheres;
    }

    public static int getWidth() {
        return Width;
    }

    public static int getHeight() {
        return Height;
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        stage.setTitle("Ray Tracing");
        spheres.add(sphereOne);
        spheres.add(sphereTwo);

        //We need 3 things to see an image
        //1. We create an image we can write to
    /*
    WritableImage image = new WritableImage(Width, Height);
    //2. We create a view of that image
    ImageView view = new ImageView(image);
    //3. Add to the pane (below)

    //Create the simple GUI
    Slider g_slider = new Slider(0, 255, green_col);


    //Add all the event handlers
    g_slider.valueProperty().addListener(
      new ChangeListener < Number > () {
        public void changed(ObservableValue < ? extends Number >
          observable, Number oldValue, Number newValue) {
          green_col = newValue.intValue();
          Render(image);
        }
      });

    //The following is in case you want to interact with the image in any way
    //e.g., for user interaction, or you can find out the pixel position for debugging
    view.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> {
      System.out.println(event.getX() + " " + event.getY());
      event.consume();
    });

    Render(image);

    GridPane root = new GridPane();
    root.setVgap(12);
    root.setHgap(12);

    //3. (referring to the 3 things we need to display an image)
    //we need to add it to the pane

    root.add(view, 0, 0);
    root.add(g_slider, 0, 1);
    */
        //Display to user
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}