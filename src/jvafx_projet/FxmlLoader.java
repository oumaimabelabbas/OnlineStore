package jvafx_projet;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
// a class to return the Pane to change the center of the SHOP borderpane
public class FxmlLoader {
	private Pane view;
	public Pane getPage(String filename) {
	try {
		URL fileUrl = getClass().getResource(filename);
		if(fileUrl==null) {
			throw new java.io.FileNotFoundException("FXML file not found");
		}
		view = new FXMLLoader().load(fileUrl);
		
	}
	catch(Exception e) {
		  e.printStackTrace();
	}
	return view;
	}

}
