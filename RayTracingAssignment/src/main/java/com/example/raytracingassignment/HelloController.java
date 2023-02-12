package com.example.raytracingassignment;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Objects;

public class HelloController {
    private Sphere currentSphere;

    public ToggleGroup chooseSphere;

    public Slider redSlider;
    public Slider greenSlider;
    public Slider blueSlider;

    public RadioButton sphereOne;
    public RadioButton sphereTwo;
    public RadioButton sphereThree;
    public RadioButton sphereFour;

    public Slider sphereX;
    public Slider sphereY;
    public Slider sphereZ;

    public Slider cameraAzimuth;
    public Slider cameraAltitude;

    public void setSphereOne() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere: spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereOne")) currentSphere = sphere;
        }
    }

    public void setSphereTwo() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere: spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereTwo")) currentSphere = sphere;
        }
    }
    public void setSphereThree() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere: spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereThree")) currentSphere = sphere;
        }
    }
    public void setSphereFour() {
        ArrayList<Sphere> spheres = Main.getSpheres();
        for (Sphere sphere: spheres) {
            if (Objects.equals(sphere.getSphereName(), "sphereFour")) currentSphere = sphere;
        }
    }
    public void changeSphereX() {
        this.currentSphere.cs = new Vector(sphereX.getValue(), this.currentSphere.getY(), this.currentSphere.getZ());
    }

    public void initialize() {

    }



}
