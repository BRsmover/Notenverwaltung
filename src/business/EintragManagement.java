package business;

import javafx.application.Platform;
import models.Eintrag;

/**
 * 
 * @author Simon Fritschi
 *
 */
public class EintragManagement {
	// Add entry
	public boolean saving(Eintrag e) {
		return true;
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