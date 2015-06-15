package models;

/**
 * 
 * @author Benjamin Jenni
 *
 */
public class Eintrag {
	private String vorname;
	private String name;
	private String fach;
	private double noteEins;
	private double noteZwei;
	private double noteDrei;

	public Eintrag(String vorname, String name, String fach, double noteEins, double noteZwei, double noteDrei) {
		this.vorname = vorname;
		this.name = name;
		this.fach = fach;
		this.noteEins = noteEins;
		this.noteZwei = noteZwei;
		this.noteDrei = noteDrei;
	}

	public double getNoteEins() {
		return noteEins;
	}

	public void setNoteEins(double noteEins) {
		this.noteEins = noteEins;
	}

	public double getNoteZwei() {
		return noteZwei;
	}

	public void setNoteZwei(double noteZwei) {
		this.noteZwei = noteZwei;
	}

	public double getNoteDrei() {
		return noteDrei;
	}

	public void setNoteDrei(double noteDrei) {
		this.noteDrei = noteDrei;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}
}