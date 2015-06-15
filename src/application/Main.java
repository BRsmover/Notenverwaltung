package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Benjamin Jenni
 *
 */
public class Main extends Application {
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
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void callAdding() {
		try {
			// Load Adding.fxml
			FXMLLoader loadAdding = new FXMLLoader();
			loadAdding.setLocation(Main.class.getResource("Adding.fxml"));
			BorderPane addLayout = (BorderPane) loadAdding.load();

			Scene addScene = new Scene(addLayout);
			Stage addStage = new Stage();
			addStage.setScene(addScene);
			addStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		Platform.exit();
	}
}
