package old_stuff;

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
	private ArrayList<Note> noten;

	// Konstruktor Klasse Fach
	public Fach(int fachId, String name, String kuerzel, ArrayList<Note> noten) {
		this.fachId = fachId;
		this.name = name;
		this.kuerzel = kuerzel;
		this.noten = noten;
	}

	public int getFachId() {
		return fachId;
	}

	public String getName() {
		return name;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public ArrayList<Note> getNoten() {
		return noten;
	}
}
