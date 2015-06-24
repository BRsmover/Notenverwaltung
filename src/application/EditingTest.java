package application;

import static org.junit.Assert.fail;
import javafx.event.ActionEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * We're testing the method actionSave.
 * At the moment there's a fail because the method doesn't
 * receive any data from the fxml textfields.
 * 
 * @author Benjamin Jenni
 */
public class EditingTest {

	Editing edit;
	ActionEvent event;

	@Before
	public void setUp() throws Exception {
		edit = new Editing();
		event = new ActionEvent();
	}

	@Test
	public void test() {
		try {
			edit.actionSave(event);
			System.out.println("successfull");
		} catch (Exception e){
			System.out.println("failed");
			fail("failed");
			//e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		edit = null;
		event = null;
	}

}
