package models;

/**
 * 
 * @author Benjamin Jenni, Simon Fritschi
 *
 */
public class Note {
	// Instanzvariablen Klasse Note
	private int noteId;
	private double wert;

	// Konstruktor Klasse Note
	public Note(int noteId, double wert) {
		this.noteId = noteId;
		this.wert = wert;
	}

	public int getNoteId() {
		return noteId;
	}

	public double getWert() {
		return wert;
	}

	public void setWert(double wert) {
		this.wert = wert;
	}
}
