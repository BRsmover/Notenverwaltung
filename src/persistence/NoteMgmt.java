package persistence;

import java.util.ArrayList;

import models.Note;
import business.NoteDAO;

public class NoteMgmt {
	private ArrayList<Note> note;
	private NoteDAO DAON;
	
	public boolean addNote(Note n) {
		return true;
	}

	public boolean delNote(Note n) {
		return true;
	}
}
