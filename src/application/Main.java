package application;

import java.io.IOException;

import models.Eintraege;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import business.EintragManagement;

/**
 * 
 * @author Benjamin Jenni
 *
 */
// Main method
public class Main extends Application {
	EintragManagement logik;

	// Start application
	public static void main (String[] args) {
		launch(args);
	}

	// Define application
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Main.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			// Get icon for application
			primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
			// Showing application
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Open the editing window
	public void callEditing() {
		try {
			// Load Editing.fxml
			FXMLLoader loadAdding = new FXMLLoader();
			loadAdding.setLocation(Main.class.getResource("Editing.fxml"));
			BorderPane addLayout = (BorderPane) loadAdding.load();

			Scene addScene = new Scene(addLayout);
			Stage addStage = new Stage();
			addStage.setTitle("Bearbeiten");
			addStage.getIcons().add(new Image("file:resources/images/logo.png"));
			addStage.initModality(Modality.APPLICATION_MODAL);
			addStage.setScene(addScene);
			addStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// Close program
	public void close() {
		Platform.exit();
	}

	// Call saveToFile method in Management
	public void callSaveToFile() {
		logik.saveToFile(new Eintraege());
	}
}
