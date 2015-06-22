package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	ObservableList<Eintrag> observableeintraege;

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
		observableeintraege = FXCollections.observableArrayList(management.getEintraege());
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

			addStage.setScene(addScene);
			addStage.setResizable(false);
			addStage.show();

			EintragManagement management = EintragManagement.getInstance();
			tableview.setItems(management.getEintraege());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void callDeleting() {
		Eintrag eintrag = tableview.getSelectionModel().getSelectedItem();
		if(eintrag != null)
		{
			if(observableeintraege.contains(eintrag))
			{
				EintragManagement management = EintragManagement.getInstance();
				management.removeEintrag(eintrag);
				if(management.saveEintraege())
				{
					tableview.setItems(management.getEintraege());
				}
				else
				{
					observableeintraege.add(eintrag);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Eintrag löschen");
					alert.setHeaderText("Eintrag löschen");
					alert.setContentText("Der angewählte Eintrag konnte nicht gelöscht werden.");
					alert.showAndWait();
				}
			}
		}
	}

	// Close program
	public void callClose() {
		Platform.exit();
	}
}
