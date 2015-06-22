package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Eintrag;
import business.EintragManagement;

public class Overview {
	EintragManagement logik;

	@FXML
	TableView<Eintrag> tableview;

	@FXML
	private TableColumn<Eintrag, String> columnVorname;

	@FXML
	private TableColumn<Eintrag, String> columnName;

	@FXML
	private TableColumn<Eintrag, String> columnFach;

	@FXML
	private TableColumn<Eintrag, String> columnNote1;

	@FXML
	private TableColumn<Eintrag, String> columnNote2;

	@FXML
	private TableColumn<Eintrag, String> columnNote3;

	@FXML
	private TableColumn<Eintrag, String> columnDurchschnitt;

	@FXML
	public void initialize() {
		EintragManagement management = EintragManagement.getInstance();
		ArrayList<Eintrag> eintraege = management.getEintraege();
		ObservableList<Eintrag> observableeintraege = FXCollections.observableArrayList(eintraege);
		columnVorname.setCellValueFactory(cellData -> cellData.getValue().getVornameProperty());
		columnName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		columnFach.setCellValueFactory(cellData -> cellData.getValue().getFachProperty());
		columnNote1.setCellValueFactory(cellData -> cellData.getValue().getNoteEinsProperty().asString());
		columnNote2.setCellValueFactory(cellData -> cellData.getValue().getNoteZweiProperty().asString());
		columnNote3.setCellValueFactory(cellData -> cellData.getValue().getNoteDreiProperty().asString());
		columnDurchschnitt.setCellValueFactory(cellData -> cellData.getValue().getDurchschnittProperty().asString());
		tableview.setItems(observableeintraege);
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
			addStage.setResizable(false);
			addStage.show();

			/*// Just add a few entries while programming
			EintragManagement management = EintragManagement.getInstance(); // Get instance and load the existing data
			management.addEintrag(new Eintrag("Simon", "Wächter", "Informatik", 5.7, 5.4, 5.55)); // Add entry
			management.addEintrag(new Eintrag("Benjamin", "Jenni", "Informatik", 4.7, 4.9, 5.3)); // Add entry
			management.saveEintraege(); // Save the existing entries + 2 new entries*/
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
		logik.addEintrag(new Eintrag("Peter", "Schwarz", "Justiz", 5.5, 6.0, 5.75));
	}

	public void callDeleting() {
		logik.deleting(new Eintrag("Peter", "Schwarz", "Justiz", 5.5, 6.0, 5.75));
	}
}
