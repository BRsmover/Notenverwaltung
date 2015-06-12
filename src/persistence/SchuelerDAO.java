package persistence;

import models.Schueler;

public class SchuelerDAO {
	// Speichern
	public boolean SpeicherSchueler(Schueler s) {
		return true;
	}

	// Loeschen
	public boolean LoeschenSchueler(Schueler s) {
		return true;
	}

	// Get all
	public Schueler getAllSchueler() {
		// Date-Wert? Format?
		Schueler s = new Schueler(1, "Meier", "Hans", "Basel, Marktplatz 2", null, "0618498374");
		return s;
	}
}
