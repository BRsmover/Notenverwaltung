package business;

import java.util.ArrayList;

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
	EintragDAO Daten;
	ArrayList<Eintrag> Eintraege;

	// Protected constructor
	protected EintragManagement() {
		Daten = new EintragDAO();
		Eintraege = Daten.getAllEintraege();
	}

	// Get management instance
	public static EintragManagement getInstance() {
		if(Management == null) {
			Management = new EintragManagement();
		}
		return Management;
	}

	// Get Eintraege
	public ArrayList<Eintrag> getEintraege() {
		return Daten.getAllEintraege();
	}

	// Add entry
	public void addEintrag(Eintrag eintrag) {
		Eintraege.add(eintrag);
	}

	// Delete entry
	public boolean deleting(Eintrag eintrag) {
		Eintraege.remove(eintrag);
		return true;
	}

	// Save all items
	public boolean saveEintraege() {
		return Daten.saveAllEintraege(Eintraege);
	}

	// Calculate average
	public double average(double eins, double zwei, double drei) {
		
		return 0;
	}
}
