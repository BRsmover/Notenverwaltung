package models;

import java.io.Serializable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * 
 * @author Benjamin Jenni
 *
 */
public class Eintrag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringProperty vorname;
	private StringProperty name;
	private StringProperty fach;
	private DoubleProperty noteEins;
	private DoubleProperty noteZwei;
	private DoubleProperty noteDrei;

	public Eintrag() {
	}

	public Eintrag(String vorname, String name, String fach, double noteEins, double noteZwei, double noteDrei) {
		this.vorname = new SimpleStringProperty(vorname);
		this.name = new SimpleStringProperty(name);
		this.fach = new SimpleStringProperty(fach);
		this.noteEins = new SimpleDoubleProperty(noteEins);
		this.noteZwei = new SimpleDoubleProperty(noteZwei);
		this.noteDrei = new SimpleDoubleProperty(noteDrei);
	}

	public DoubleProperty getNoteEinsProperty() {
		return noteEins;
	}

	public double getNoteEins() {
		return noteEins.get();
	}

	public void setNoteEins(double noteEins) {
		this.noteEins = new SimpleDoubleProperty(noteEins);
	}

	public DoubleProperty getNoteZweiProperty() {
		return noteZwei;
	}

	public double getNoteZwei() {
		return noteZwei.get();
	}

	public void setNoteZwei(double noteZwei) {
		this.noteZwei = new SimpleDoubleProperty(noteZwei);
	}

	public DoubleProperty getNoteDreiProperty() {
		return noteDrei;
	}

	public double getNoteDrei() {
		return noteDrei.get();
	}

	public void setNoteDrei(double noteDrei) {
		this.noteDrei = new SimpleDoubleProperty(noteDrei);
	}

	public StringProperty getVornameProperty() {
		return vorname;
	}

	public String getVorname() {
		return vorname.get();
	}

	public void setVorname(String vorname) {
		this.vorname = new SimpleStringProperty(vorname);
	}

	public StringProperty getNameProperty() {
		return name;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public StringProperty getFachProperty() {
		return fach;
	}

	public String getFach() {
		return fach.get();
	}

	public void setFach(String fach) {
		this.fach = new SimpleStringProperty(fach);
	}
}