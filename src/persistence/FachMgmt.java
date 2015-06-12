package persistence;

import java.util.ArrayList;

import models.Fach;
import models.Note;
import business.FachDAO;

public class FachMgmt {
	private ArrayList<Fach> fach;
	private FachDAO DAOF;
	
	public boolean addFach(Fach f) {
		return true;
	}

	public boolean delFach(Fach f) {
		return true;
	}

	public double schnitt(Fach f, Note n) {
		return 1.0;
	}

	public boolean existFach(Fach f) {
		return true;
	}
}
