package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Eintraege;
import models.Eintrag;
import business.EintragManagement;

public class Overview {
	EintragManagement logik;

	@FXML
	TableView<Eintrag> tableview;

	// Open the editing window
	public void callEditing() {
		try {
			// Load Editing.fxml
			FXMLLoader loadAdding = new FXMLLoader();
			loadAdding.setLocation(Main.class.getResource("Editing.fxml"));
			BorderPane addLayout = (BorderPane) loadAdding.load();

			Scene addScene = new Scene(addLayout);
			Stage addStage = new Stage();
			addStage.getIcons().add(new Image("file:resources/images/logo.png"));
			addStage.initModality(Modality.APPLICATION_MODAL);

			Eintrag eintrag = tableview.getSelectionModel().getSelectedItem();
			if(eintrag != null) {
				// TODO
				addStage.setTitle("Bearbeiten");
			} else {
				addStage.setTitle("Erstellen");
			}
			
			addStage.setScene(addScene);
			addStage.show();

		} catch (IOException e) {
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

	// Call average calculator
	public double callAverage(double noteEins, double noteZwei, double noteDrei) {
		
		return logik.average(noteEins, noteZwei, noteDrei);
	}
}
