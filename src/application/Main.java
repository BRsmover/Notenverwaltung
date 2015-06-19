package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Benjamin Jenni
 *
 */
// Main method
public class Main extends Application {
	// Start application
	public static void main(String[] args) {
		launch(args);
	}

	// Define application
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Overview.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			// Get icon for application
			primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
			
			// Showing application
			primaryStage.setTitle("Notenverwaltung");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
