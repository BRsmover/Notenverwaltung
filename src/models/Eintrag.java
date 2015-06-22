package models;

import java.io.Serializable;
import java.math.BigDecimal;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * The only object we ever use is Eintrag. This is its class.
 * @author Benjamin Jenni, Simon Fritschi
 */
public class Eintrag implements Serializable {

	private static final long serialVersionUID = 1L;
	private StringProperty vorname;
	private StringProperty name;
	private StringProperty fach;
	private DoubleProperty noteEins;
	private DoubleProperty noteZwei;
	private DoubleProperty noteDrei;

	/**
	 * A constructor without any parameters.
	 * @author Benjamin Jenni, Simon Fritschi
	 */
	public Eintrag() {
	}

	/**
	 * This is our constructor where we give the object already its
	 * parameters.
	 * @author Benjamin Jenni, Simon Fritschi
	 * @param vorname
	 * @param name
	 * @param fach
	 * @param noteEins
	 * @param noteZwei
	 * @param noteDrei
	 */
	public Eintrag(String vorname, String name, String fach, double noteEins, double noteZwei, double noteDrei) {
		this.vorname = new SimpleStringProperty(vorname);
		this.name = new SimpleStringProperty(name);
		this.fach = new SimpleStringProperty(fach);
		this.noteEins = new SimpleDoubleProperty(noteEins);
		this.noteZwei = new SimpleDoubleProperty(noteZwei);
		this.noteDrei = new SimpleDoubleProperty(noteDrei);
	}

	/**
	 * In the following code we have the setters and getters for our variables.
	 * @author Benjamin Jenni, Simon Fritschi
	 */
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

	/**
	 * Here we calculate the average of the marks.
	 * @author Benjamin Jenni, Simon Fritschi
	 * @return rounded average value
	 */
	public DoubleProperty getDurchschnittProperty() {
		double noteEins = getNoteEins();
		double noteZwei = getNoteZwei();
		double noteDrei = getNoteDrei();
		double note = 0;
		int noteCount = 0;
		if (noteEins > 0) {
			note += noteEins;
			noteCount += 1;
		}
		if (noteZwei > 0) {
			note += noteZwei;
			noteCount += 1;
		}
		if (noteDrei > 0) {
			note += noteDrei;
			noteCount += 1;
		}
		return new SimpleDoubleProperty(round(note / noteCount, 2, BigDecimal.ROUND_HALF_UP));
	}

	/**
	 * This method is used to round the average value.
	 * @author Benjamin Jenni, Simon Fritschi
	 * @param unrounded
	 * @param precision
	 * @param roundingMode
	 * @return
	 */
	private double round(double unrounded, int precision, int roundingMode) {
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
}
