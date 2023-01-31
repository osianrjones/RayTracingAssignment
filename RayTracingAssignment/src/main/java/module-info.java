module com.example.raytracingassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.raytracingassignment to javafx.fxml;
    exports com.example.raytracingassignment;
}