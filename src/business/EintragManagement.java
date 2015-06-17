package business;

import java.util.ArrayList;

import javafx.application.Platform;
import models.Eintraege;
import models.Eintrag;
import persistence.EintragDAO;

/**
 * 
 * @author Simon Fritschi
 *
 */
public class EintragManagement {
	
	EintragDAO Daten;
	Eintraege Eintraege;
	
	public EintragManagement(){
		EintragDAO Daten = new EintragDAO();
		
		
		Eintraege = Daten.getAllEintraege();
	}
	
	//Speichert in XML
	public boolean saveToFile(Eintraege ToFile){
		boolean geht = Daten.saving(ToFile);
		return geht;
	}
	
	// Add entry
	public Eintraege saving(Eintrag e) {
		Eintraege.getEintraege().add(e);
		
		return Eintraege;
	}

	// Delete entry
	public boolean deleting(Eintrag e) {
		return true;
	}

	// Calculate average
	public double average(double eins, double zwei, double drei) {
		return 0;
	}

	// Cancel button
	public void cancel() {
		Platform.exit();
	}
}