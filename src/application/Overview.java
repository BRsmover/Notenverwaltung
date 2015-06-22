package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		columnVorname.setCellValueFactory(cellData -> cellData.getValue().getVornameProperty());
		columnName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		columnFach.setCellValueFactory(cellData -> cellData.getValue().getFachProperty());
		columnNote1.setCellValueFactory(cellData -> cellData.getValue().getNoteEinsProperty().asString());
		columnNote2.setCellValueFactory(cellData -> cellData.getValue().getNoteZweiProperty().asString());
		columnNote3.setCellValueFactory(cellData -> cellData.getValue().getNoteDreiProperty().asString());
		columnDurchschnitt.setCellValueFactory(cellData -> cellData.getValue().getDurchschnittProperty().asString());
		tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableview.setItems(management.getEintraege());
	}

	// Open the editing window
	public void actionEditing() {
		try {
			// Load Editing.fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Editing.fxml"));
			BorderPane addLayout = (BorderPane) loader.load();

			Scene addScene = new Scene(addLayout);
			Stage addStage = new Stage();
			addStage.getIcons().add(new Image("file:resources/images/logo.png"));
			addStage.initModality(Modality.APPLICATION_MODAL);

			Editing editing = loader.getController();
			Eintrag eintrag = tableview.getSelectionModel().getSelectedItem();
			if(eintrag != null) {
				editing.setEintrag(eintrag);
			}

			addStage.setScene(addScene);
			addStage.setTitle("Bearbeiten/ Erstellen");
			addStage.setResizable(false);
			addStage.show();

			EintragManagement management = EintragManagement.getInstance();
			tableview.setItems(management.getEintraege());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionDeleting() {
		Eintrag eintrag = tableview.getSelectionModel().getSelectedItem();
		if(eintrag != null) {
			EintragManagement management = EintragManagement.getInstance();
			if(management.getEintraege().contains(eintrag)) {
				management.removeEintrag(eintrag);
				if(management.saveEintraege()) {
					tableview.setItems(management.getEintraege());
				} else {
					management.addEintrag(eintrag);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Eintrag löschen");
					alert.setHeaderText("Eintrag löschen");
					alert.setContentText("Der angewählte Eintrag konnte nicht gelöscht werden.");
					alert.showAndWait();
				}
			}
		}
	}

	// Close program
	public void actionClose() {
		Platform.exit();
	}
}
