package application;

import java.io.IOException;

import models.Eintraege;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import business.EintragManagement;

/**
 * 
 * @author Benjamin Jenni
 *
 */
public class Main extends Application {
	EintragManagement logik;

	public static void main (String[] args) {
		launch(args);
	}

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

	public void callEditing() {
		try {
			// Load Editing.fxml
			FXMLLoader loadAdding = new FXMLLoader();
			loadAdding.setLocation(Main.class.getResource("Editing.fxml"));
			BorderPane addLayout = (BorderPane) loadAdding.load();

			Scene addScene = new Scene(addLayout);
			Stage addStage = new Stage();
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
	public void callSaveToFile(Eintraege ToFile) {
		logik.saveToFile(ToFile);
	}
}
