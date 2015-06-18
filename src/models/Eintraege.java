package models;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "eintraege")
@XmlAccessorType(XmlAccessType.FIELD)
public class Eintraege {

	@XmlElement(name = "eintraege")
	private ArrayList<Eintrag> Eintraege = null;

	public ArrayList<Eintrag> getEintraege() {
		return Eintraege;
	}

	public void setEintraege(ArrayList<Eintrag> Eintraege) {

		this.Eintraege = Eintraege;
	}

}
