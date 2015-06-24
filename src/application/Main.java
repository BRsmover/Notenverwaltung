package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is the main method. It is the beginning of our application.
 * It's the method that get's called if you start the application.
 * @author Benjamin Jenni
 */
public class Main extends Application {
	/**
	 * This is the start which launches the application.
	 * @author Benjamin Jenni
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The start method is used by JavaFX. In this case it is used to instance the rootlayout
	 * on which the table is displayed.
	 * For example we set the title and the icon. We also load our Overview.fxml in this method.
	 * @author Benjamin Jenni
	 * @param primarystage - This is the stage on which our GUI is built.
	 */
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
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
