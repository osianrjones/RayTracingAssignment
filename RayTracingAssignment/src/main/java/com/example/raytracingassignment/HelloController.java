package com.example.raytracingassignment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;
import java.util.Objects;

public class HelloController {
    @FXML
    public ToggleGroup chooseSphere;
    @FXML
    public Slider redSlider;
    @FXML
    public Slider greenSlider;
    @FXML
    public Slider blueSlider;
    @FXML
    public RadioButton sphereOne;
    @FXML
    public RadioButton sphereTwo;
    @FXML
    public RadioButton sphereThree;
    @FXML
    public RadioButton sphereFour;
    @FXML
    public Slider sphereX;
    @FXML
    public Slider sphereY;
    @FXML
    public Slider sphereZ;
    @FXML
    public Slider cameraAzimuth;
    @FXML
    public Slider cameraAltitude;
    @FXML
    public ImageView imageView = new ImageView();
    public WritableImage image;
    @FXML
    public Slider sphereRadius;
    private Sphere currentSphere;



    public void setSphereOne() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere : spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereOne")) currentSphere = sphere;
        }
        setCurrentSpherePosition();
        setCurrentSphereColourSliders();
    }

    public void setSphereTwo() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere : spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereTwo")) currentSphere = sphere;
        }
        setCurrentSpherePosition();
        setCurrentSphereColourSliders();
    }

    public void setSphereThree() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere : spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereThree")) currentSphere = sphere;
        }
        setCurrentSpherePosition();
        setCurrentSphereColourSliders();
    }

    public void setSphereFour() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere : spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereFour")) currentSphere = sphere;
        }
        setCurrentSpherePosition();
        setCurrentSphereColourSliders();
    }

    public void changeSphereX() {
        this.currentSphere.setX((int) sphereX.getValue());
        this.currentSphere.cs = new Vector(sphereX.getValue(), this.currentSphere.getY(), this.currentSphere.getZ());
        render();
    }

    public void changeSphereY() {
        this.currentSphere.setY((int) sphereY.getValue());
        this.currentSphere.cs = new Vector(this.currentSphere.getX(), sphereY.getValue(), this.currentSphere.getZ());
        render();
    }
    public void changeSphereZ() {
        this.currentSphere.setZ((int) sphereZ.getValue());
        this.currentSphere.cs = new Vector(this.currentSphere.getX(), this.currentSphere.getY(), sphereZ.getValue());
        render();
    }

    public void displayImage() {
        image = new WritableImage(Main.getWidth(), Main.getHeight());
        imageView.setImage(image);
        render();
    }

    public void changeRedColour() {
        this.currentSphere.updateR(redSlider.getValue());
        render();
    }
    public void changeGreenColour() {
        this.currentSphere.updateG(greenSlider.getValue());
        render();
    }
    public void changeBlueColour() {
        this.currentSphere.updateB(blueSlider.getValue());
        render();
    }

    public void changeCameraAltitude() {
        Main.changeO((int) cameraAltitude.getValue());
        render();
    }

    public void render() {
        Main.Render(image);
    }

    public void changeCurrentSphereRadius() {
        this.currentSphere.radius = sphereRadius.getValue();
        render();
    }

    public void setCurrentSpherePosition() {
        this.sphereX.adjustValue(this.currentSphere.getX());
        this.sphereY.adjustValue(this.currentSphere.getY());
        this.sphereZ.adjustValue(this.currentSphere.getZ());
        this.sphereRadius.adjustValue(this.currentSphere.getRadius());
        this.cameraAltitude.adjustValue(Main.getCameraHeight());
    }
    public void setCurrentSphereColourSliders() {
        this.redSlider.adjustValue(this.currentSphere.r);
        this.greenSlider.adjustValue(this.currentSphere.g);
        this.blueSlider.adjustValue(this.currentSphere.b);
    }

    public void setSliderListeners() {
        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> changeRedColour());
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> changeBlueColour());
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> changeGreenColour());
    }

    public void setPositionListeners() {
        sphereX.valueProperty().addListener((observableValue, oldValue, newValue) -> changeSphereX());
        sphereY.valueProperty().addListener((observableValue, oldValue, newValue) -> changeSphereY());
        sphereZ.valueProperty().addListener((observableValue, oldValue, newValue) -> changeSphereZ());
        sphereRadius.valueProperty().addListener((observableValue, oldValue, newValue) -> changeCurrentSphereRadius());
        cameraAltitude.valueProperty().addListener((observableValue, oldValue, newValue) -> changeCameraAltitude());

    }

    public void initialize() {
        displayImage();
        setSphereOne();
        setCurrentSphereColourSliders();
        setCurrentSpherePosition();
        setSliderListeners();
        setPositionListeners();
    }

}



