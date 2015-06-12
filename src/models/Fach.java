package models;

import java.util.ArrayList;

/**
 * 
 * @author Benjamin Jenni, Simon Fritschi
 *
 */
public class Fach {
	// Instanzvariablen Klasse Fach
	private int fachId;
	private String name;
	private String kuerzel;
	private ArrayList<Note> note;
	
	// Konstruktor Klasse Fach
	public Fach(int fachId, String name, String kuerzel, ArrayList<Note> note) {
		this.fachId = fachId;
		this.name = name;
		this.kuerzel = kuerzel;
		this.note = note;
	}
}
