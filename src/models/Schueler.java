package models;

import java.util.Date;

/**
 * 
 * @author Benjamin Jenni, Simon Fritschi
 *
 */
public class Schueler {
	// Instanzvariablen Klasse Schueler
	private int schuelerId;
	private String name;
	private String vorname;
	private String adresse;
	private Date jahrgang;
	private String telefonnummer;

	// Konstruktor Klasse Schueler
	public Schueler(int schuelerId, String name, String vorname, String adresse, Date jahrgang, String telefonnummer) {
		this.schuelerId = schuelerId;
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
		this.jahrgang = jahrgang;
		this.telefonnummer = telefonnummer;
	} 
}
