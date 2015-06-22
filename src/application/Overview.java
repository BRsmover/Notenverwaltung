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

/**
 * In the class Overview we define the tableview and their columns.
 * @author Benjamin Jenni
 */
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

	/**
	 *  In the initialize method we get the data from the singleton into our tableview.
	 * @author Benjamin Jenni
	 */
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

	/**
	 * In actionEditing we call our editing window if the user click on add/edit.
	 * For this we need the Editing.fxml
	 * @author Benjamin Jenni
	 */
	public void actionEditing() {
		try {
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

	/**
	 * This action is called if the user clicks the delete button. If there is an 
	 * error an alert is shown.
	 * @author Benjamin Jenni
	 */
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

	/**
	 * This action is called if the user clicks on exit in the menu.
	 * It simply closes the windows.
	 * @author Benjamin Jenni
	 */
	public void actionClose() {
		Platform.exit();
	}

	/**
	 * If a user clicks on help he will see a popup with this content which 
	 * will guide him through the application.
	 * @author Benjamin Jenni
	 */
	public void actionHelp() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Hilfe");
		alert.setHeaderText("Hilfe");
		alert.setContentText("Um einen Wert hinzuzufügen klicken Sie unten auf >Hinzufügen/Bearbeiten<."
				+ "\r\nUm einen bestehenden Wert zu bearbeiten, wählen Sie ihn an und anschliessend"
				+ " klicken Sie auf >Hinzufügen/Bearbeiten<."
				+ "\r\nUm einen Wert zu löschen wählen Sie ihn an und anschliessen klicken Sie auf >Löschen<."
				+ "\r\nFalls Sie mehr über das Programm erfahren möchten, klicken Sie oben auf >Über uns<.");
		alert.showAndWait();
	}

	/**
	 * If a user clicks on about he will see a popup with these informations about our program.
	 * @author Benjamin Jenni
	 */
	public void actionAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Über uns");
		alert.setHeaderText("Über uns");
		alert.setContentText("Version: Notenverwaltung 1.0\r\n\r\n" + "Autoren: Simon Fritschi, Benjamin Jenni\r\n\r\n" + "Information: Mit "
				+ "unserer Notenverwaltung können Sie auf eine einfache Art und Weise Ihre eigenen Noten oder die Ihrer Schüler "
				+ "verwalten.\r\nDie Notenverwaltung wurde im Rahmen eines Kompetenznachweises im Modul 226 an der Gewerblich "
				+ "industriellen Berufsschulen Muttenz programmiert.");
		alert.showAndWait();
	}
}
