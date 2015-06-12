package business;

import java.util.ArrayList;

import models.Note;
import persistence.NoteDAO;

public class NoteManagement {
	private ArrayList<Note> note;
	private NoteDAO DAON;

	public boolean addNote(Note n) {
		return true;
	}

	public boolean delNote(Note n) {
		return true;
	}
}
