package old_stuff;

import java.util.ArrayList;

public class FachDAO {
	// Speichern
	public boolean SpeicherFach(Fach f) {
		return true;
	}

	// Loeschen
	public boolean LoeschenFach(Fach f) {
		return true;
	}

	// Get all
	public Fach getAllFach() {
		ArrayList<Note> noten = new ArrayList<>();
		Fach f = new Fach(1, "Biologie", "B", noten);
		return f;
	}
}
