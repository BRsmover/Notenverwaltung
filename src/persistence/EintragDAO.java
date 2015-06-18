package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.Eintraege;
import models.Eintrag;

/**
 * 
 * @author Simon Fritschi
 *
 */
public class EintragDAO {

	private static final String eintrag_XML = "EintragXML.xml";
	// ArrayList<Eintrag> eintragList = new ArrayList<>();
	static Eintraege Liste = new Eintraege();

	public EintragDAO() {

	}

	// Saving to XML
	public boolean saving(Eintraege eingabe) {

		this.Liste = eingabe;

		try {

			JAXBContext context = JAXBContext.newInstance(Eintrag.class);
			Marshaller mEintrag = context.createMarshaller();
			mEintrag.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write to File
			mEintrag.marshal(Liste, new File(eintrag_XML));

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return true;
	}

	public Eintraege getAllEintraege() {

		try {
			JAXBContext context = JAXBContext.newInstance(Eintrag.class);
			Unmarshaller umEintrag = context.createUnmarshaller();
			Liste = (Eintraege) umEintrag.unmarshal(new File(eintrag_XML));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Liste;
	}

}