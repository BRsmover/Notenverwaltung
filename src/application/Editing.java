package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import models.Eintrag;
import business.EintragManagement;

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

	// Save button set on action
	@FXML
	public void actionSave() {
		Eintrag eintrag = new Eintrag();
		eintrag.setVorname(vorname.getText());
		eintrag.setName(name.getText());
		eintrag.setFach(fach.getText());

		if (note1.getText().matches("[1-6]")){
			double first = Double.parseDouble(note1.getText());
			eintrag.setNoteEins(first);
		}
		if (note2.getText().matches("[1-6]")) {
			double second = Double.parseDouble(note2.getText());
			eintrag.setNoteZwei(second);
		}
		if (note3.getText().matches("[1-6]")) {
			double third = Double.parseDouble(note3.getText());
			eintrag.setNoteDrei(third);
		}

		EintragManagement management = new EintragManagement();
		management.saving(eintrag);
	}

	// Cancel button set on action
	@FXML
	public void actionCancel(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
}
