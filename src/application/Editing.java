package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import models.Eintrag;
import business.EintragManagement;

/**
 * In the editing class we make the GUI for the editing form.
 * (And in the Editing.fxml)
 * @author Benjamin Jenni
 */
public class Editing {
	@FXML
	private TextField vorname;
	@FXML
	private TextField name;
	@FXML
	private TextField fach;
	@FXML
	private TextField note1;
	@FXML
	private TextField note2;
	@FXML
	private TextField note3;

	Eintrag currenteintrag;

	/**
	 * In our initialize method we test if the input in the mark fields is valid.
	 * @author Benjamin Jenni
	 */
	@FXML
	public void initialize() {
		note1.focusedProperty().addListener((arg0, oldValue, newValue) -> {
			if (!newValue) {
				if(!note1.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")){
					note1.setText("");
		        }
		    }
		});

		note2.focusedProperty().addListener((arg0, oldValue, newValue) -> {
			if (!newValue) {
				if(!note2.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")){
					note2.setText("");
		        }
		    }
		});

		note3.focusedProperty().addListener((arg0, oldValue, newValue) -> {
			if (!newValue) {
				if(!note3.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")){
					note3.setText("");
		        }
		    }
		});
	}

	/**
	 * If the user clicks the save button we automatically save into the csv
	 * and we refresh the tableview.
	 * If the user edits an existing entry we display its values in the form.
	 * @author Benjamin Jenni
	 * @param event - An actionevent
	 * @see editEintrag
	 */
	@FXML
	public void actionSave(ActionEvent event) {
		Eintrag eintrag = new Eintrag();
		eintrag.setVorname(vorname.getText());
		eintrag.setName(name.getText());
		eintrag.setFach(fach.getText());

		if (note1.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")) {
			double first = Double.parseDouble(note1.getText());
			eintrag.setNoteEins(first);
		}
		if (note2.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")) {
			double second = Double.parseDouble(note2.getText());
			eintrag.setNoteZwei(second);
		}
		if (note3.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")) {
			double third = Double.parseDouble(note3.getText());
			eintrag.setNoteDrei(third);
		}

		EintragManagement management = EintragManagement.getInstance();
		ObservableList<Eintrag> eintraege = management.getEintraege();

		if(currenteintrag != null) {
			management.editEintrag(currenteintrag, eintrag);
		} else {
			eintraege.add(eintrag);
		}

		if(!management.saveEintraege()) {
			management.addEintrag(eintrag);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Eintrag bearbeiten/erstellen");
			alert.setHeaderText("Eintrag löschen");
			alert.setContentText("Der angewählte Eintrag konnte nicht bearbeitet/erstellt werden.");
			alert.showAndWait();
		}

		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	/**
	 * If a user clicks on the cancel button we close the editing window.
	 * @author Benjamin Jenni
	 * @param event
	 */
	@FXML
	public void actionCancel(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	/**
	 * We need this method to set the values into the form if the user
	 * wants to edit an existing entry.
	 * @param eintrag
	 */
	public void setEintrag(Eintrag eintrag) {
		vorname.setText(eintrag.getVorname());
		name.setText(eintrag.getName());
		fach.setText(eintrag.getFach());
		note1.setText(Double.toString(eintrag.getNoteEins()));
		note2.setText(Double.toString(eintrag.getNoteZwei()));
		note3.setText(Double.toString(eintrag.getNoteDrei()));
		currenteintrag = eintrag;
	}
}
