package persistence;

import models.Note;

public class NoteDAO {
	// Speichern
	public boolean SpeicherNote(Note n) {
		return true;
	}

	// Loeschen
	public boolean LoeschenNote(Note n) {
		return true;
	}

	// Get all
	public Note getAllNote() {
		Note n = new Note(1, 5.6);
		return n;
	}
}
