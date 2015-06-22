package business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Eintrag;
import persistence.EintragDAO;

/**
 * 
 * @author Simon Fritschi
 *
 */
// Class EintragManagement
public class EintragManagement {

	static EintragManagement Management;
	ObservableList<Eintrag> Eintraege;
	EintragDAO Daten;

	// Protected constructor
	protected EintragManagement() {
		Daten = new EintragDAO();
		try {
			Eintraege = Daten.getAllEintraege();
		} catch(Exception e) {
			Eintraege = FXCollections.observableArrayList();
		}
	}

	// Get management instance
	public static EintragManagement getInstance() {
		if(Management == null) {
			Management = new EintragManagement();
		}
		return Management;
	}

	// Get Eintraege
	public ObservableList<Eintrag> getEintraege() {
		return Eintraege;
	}

	// Add an Eintrag
	public void addEintrag(Eintrag eintrag) {
		Eintraege.add(eintrag);
	}

	// Remove an Eintrag
	public void removeEintrag(Eintrag eintrag) {
		Eintraege.remove(eintrag);
	}

	// Edit an Eintrag
	public void editEintrag(Eintrag oldEintrag, Eintrag newEintrag) {
		int index = Eintraege.indexOf(oldEintrag);
		Eintraege.set(index, newEintrag);
	}

	// Save all items
	public boolean saveEintraege() {
		try {
			Daten.saveAllEintraege(Eintraege);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
