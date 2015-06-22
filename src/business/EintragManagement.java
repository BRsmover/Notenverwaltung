package business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Eintrag;
import persistence.EintragDAO;

/**
 * This is the logic of our application.
 * Here we create our singleton Management and our observablelist.
 * @author Simon Fritschi
 */
public class EintragManagement {

	static EintragManagement Management;
	ObservableList<Eintrag> Eintraege;
	EintragDAO Daten;

	/**
	 * This is the constructor. As you can see this is where we get all the entries.
	 * @author Simon Fritschi
	 */
	protected EintragManagement() {
		Daten = new EintragDAO();
		try {
			Eintraege = Daten.getAllEintraege();
		} catch(Exception e) {
			Eintraege = FXCollections.observableArrayList();
		}
	}

	/**
	 * Here we get the instance of our singleton. If it is null we create one.
	 * @author Simon Fritschi
	 * @return Management
	 */
	public static EintragManagement getInstance() {
		if(Management == null) {
			Management = new EintragManagement();
		}
		return Management;
	}

	/**
	 * Getting the entries of the observable list.
	 * @author Simon Fritschi
	 * @return
	 */
	public ObservableList<Eintrag> getEintraege() {
		return Eintraege;
	}

	/**
	 * Adding an entry to the observable list.
	 * @author Simon Fritschi
	 * @param eintrag
	 */
	public void addEintrag(Eintrag eintrag) {
		Eintraege.add(eintrag);
	}

	/**
	 * Removing an entry from the observable list.
	 * @author Simon Fritschi
	 * @param eintrag
	 */
	public void removeEintrag(Eintrag eintrag) {
		Eintraege.remove(eintrag);
	}

	/**
	 * We need this to make sure the index stays the same after
	 * editing an entry. (The entry you edited is still on the top
	 * after editing and saving.)
	 * @author Simon Fritschi
	 * @param oldEintrag
	 * @param newEintrag
	 */
	public void editEintrag(Eintrag oldEintrag, Eintrag newEintrag) {
		int index = Eintraege.indexOf(oldEintrag);
		Eintraege.set(index, newEintrag);
	}

	/**
	 * Saving the entries from the observable list.
	 * @author Simon Fritschi
	 * @return
	 */
	public boolean saveEintraege() {
		try {
			Daten.saveAllEintraege(Eintraege);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
