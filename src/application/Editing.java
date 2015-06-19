package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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

	public Editing() {
	}

	// Test if input is valid
	@FXML
	public void initialize() {
		note1.focusedProperty().addListener((arg0, oldValue, newValue) -> {
			if (!newValue) {
				if(!note1.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(.0{1,2}){0,1}")){
					note1.setText("");
		        }
		    }
		});
	}

	// Save button set on action
	@FXML
	public void actionSave() {
		Eintrag eintrag = new Eintrag();
		eintrag.setVorname(vorname.getText());
		eintrag.setName(name.getText());
		eintrag.setFach(fach.getText());

		if (note1.getText().matches("[1-6]")) {
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
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	public void validate(KeyEvent event) {
		String content = event.getCharacter();
		if ("123456.".contains(content)) {
			
		} else {
			event.consume();
		}
	}
}
