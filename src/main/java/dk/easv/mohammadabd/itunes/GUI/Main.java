package dk.easv.mohammadabd.itunes.GUI;

import dk.easv.mohammadabd.itunes.DAL.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML and initialize the scene
        FXMLLoader fxmlLoader = new FXMLLoader(Main2.class.getResource("/dk/easv/mohammadabd/itunes/GUI/MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 500);
        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();

        // Test database connection
        testDatabaseConnection();
    }

    /**
     * Test database connection from DBConnection class.
     */
    private void testDatabaseConnection() {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Database connected successfully!");
            DBConnection.closeConnection();
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}