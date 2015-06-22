package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Eintrag;

/**
 * 
 * @author Simon Fritschi
 *
 */
public class EintragDAO {

	private static final String EINTRAGE_CSV = "eintraege.csv";

	// Saving to CSV file
	public void saveAllEintraege(ObservableList<Eintrag> eintraege) throws Exception {
		File file = new File(EINTRAGE_CSV);
		file.createNewFile();
		FileOutputStream outputstream = new FileOutputStream(file);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputstream));
		for (Eintrag eintrag : eintraege) {
			String query = eintrag.getVorname() + ";" + eintrag.getName() + ";" + eintrag.getFach() + ";" + eintrag.getNoteEins() + ";" + eintrag.getNoteZwei() + ";" + eintrag.getNoteDrei();
			writer.write(query);
			writer.newLine();
		}
		writer.close();
	}

	public ObservableList<Eintrag> getAllEintraege() throws Exception {
		File file = new File(EINTRAGE_CSV);
		file.createNewFile();
		ObservableList<Eintrag> eintraege = FXCollections.observableArrayList();
		FileInputStream inputstream = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] items = line.split(";");
			eintraege.add(new Eintrag(items[0], items[1], items[2], Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5])));
		}
		reader.close();
		return eintraege;
	}
}
