
package jvafx_projet;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP830G5
 */
public class LoginController  {

    @FXML
    private Button loginbtn;
    @FXML
    private TextField usernametextfield;
    Parent root;
    Stage stage;
    Scene scene;
      

    @FXML
    private void Login(ActionEvent event) throws IOException {
    	//open the shop scene and use an alert to show you that you're connected
    	root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	//if the textfield is empty you can't connect
    	if(usernametextfield.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR,"Error You Need To Enter A Username");
    		alert.setTitle("Error!");
            alert.setHeaderText("Error!");
    		alert.show();
    	}

    	else {
        Alert alert = new Alert(AlertType.INFORMATION,"Hello "+usernametextfield.getText(),ButtonType.OK);
        alert.setTitle("You Are Connected!");
        alert.setHeaderText("You Are Connected!");
        alert.show();
        //set our scene
        scene = new Scene(root);
        stage.setTitle("Home");
        stage.setScene(scene);
        //afficher le stage
        stage.show();
    	}
    }
    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }
    
}
