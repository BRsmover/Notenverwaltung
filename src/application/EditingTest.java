package application;

import javafx.collections.ObservableList;
import models.Eintrag;

import org.junit.Test;

import business.EintragManagement;

/**
 * Testing if an observable list with entries that we get is not null.
 * If it isn't null it's good.
 * @author Benjamin Jenni
 */
public class EditingTest {

	@Test
	public void test() {
		EintragManagement management = EintragManagement.getInstance();
		ObservableList<Eintrag> eintragList = management.getEintraege();
		if (eintragList != null) {
			System.out.println("There is no value in eintrag!");
		} else {
			System.out.println("There is a value in eintrag!");
		}
	}

}
