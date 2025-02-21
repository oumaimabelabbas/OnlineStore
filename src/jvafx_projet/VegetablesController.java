package jvafx_projet;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class VegetablesController implements Initializable {

    @FXML
    private Spinner<Integer> onionspin;

    @FXML
    private Spinner<Integer> pepperspin;

    @FXML
    private Spinner<Integer> potatospin;

    @FXML
    private Spinner<Integer> tomatospin;
    
    @FXML
    private Button onionadd;

    @FXML
    private Label onionname;

    @FXML
    private Label onionprice;
    
    @FXML
    private Button bellpeperadd;
    
    @FXML
    private Label bellpeperprice;

    @FXML
    private Label bellpeppername;
    
    @FXML
    private Button potatoadd;

    @FXML
    private Label potatoname;

    @FXML
    private Label potatoprice;
    
    @FXML
    private Button tomatoadd;

    @FXML
    private Label tomatoname;

    @FXML
    private Label tomatoprice;
    
    private ShopController shopController; // Reference to the ShopController

    public void setShopController(ShopController shopController) {
        this.shopController = shopController;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//set the value factory of the spinners of the vegetables items
		SpinnerValueFactory<Integer> valuefactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		onionspin.setValueFactory(valuefactory1);
		
		SpinnerValueFactory<Integer> valuefactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		pepperspin.setValueFactory(valuefactory2);
		
		SpinnerValueFactory<Integer> valuefactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		potatospin.setValueFactory(valuefactory3);
		
		SpinnerValueFactory<Integer> valuefactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		tomatospin.setValueFactory(valuefactory4);
	}
	
	@FXML
    void addonion(ActionEvent event) {
		boolean exist = false;
		    String name = onionname.getText();
	        String priceString = onionprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = onionspin.getValue();
	        //we will see if the item is already in our tableview to not duplicate
	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        	// Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }
    }
	 @FXML
	void bellpepperadd(ActionEvent event) {
		    boolean exist = false;
		    String name = bellpeppername.getText();
	        String priceString = bellpeperprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = pepperspin.getValue();

	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }


	 }
	 @FXML
	 void potatoadd(ActionEvent event) {
		 boolean exist = false;
		 String name = potatoname.getText();
	        String priceString = potatoprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = potatospin.getValue();
	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }

	 }
	  @FXML
	    void tomatoadd(ActionEvent event) {
		    boolean exist = false;
		    String name = tomatoname.getText();
	        String priceString = tomatoprice.getText().replace("DH", "").trim();
	        double price = Double.parseDouble(priceString);
	        int quantity = tomatospin.getValue();

	        for(Item item : shopController.getitems()) {
	        	if(item.getName().equals(name)) {
	        		exist=true;
	        		item.setQuantity(quantity);
	        		DataBase.updateQuantity(name, quantity);
	        		shopController.refreshtableview();
	        		break; //leave when we found the item exists
	        	}
	        }
	        if(!exist) {
	        // Insert into the database
	        DataBase.insertItem(name, price, quantity);
	        //insert the item in the list of items
	        shopController.addItemToTable(new Item(name,price,quantity)); 
	        //refresh our tableview
	        shopController.refreshtableview();
	        }

	  }
	  
}
